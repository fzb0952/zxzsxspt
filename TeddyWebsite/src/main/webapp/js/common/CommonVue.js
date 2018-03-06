/**
 * Created by tingyu on 2017/4/8.
 */

/**
 * 封装本系统中创建Vue对象，以及一些常用的操作
 *
 * @param options
 * options = {
 *          element: "#id",           //页面元素选择器
 *          url: "",                  //data请求地址
 *          data: {value: []},        //数据
 *          getDataMethod: "url",     //data:从options.data中获取    url:从url中获取(默认)
 *          methods:{},               //定义函数列表
 *          isByPage: true,          //获取数据时是否采用分页方式获取  默认true
 *          pageStyle: "contact"     //contact连接，紧跟在上一页内容后面  cover覆盖方式
 *      };
 * @returns Vue
 * @constructor
 */
function TeddyVue(options) {
    this._options = options;
    this._data = {};
    this._pageBean = new PageBean();
    this._Vue = null;

    if(!Vue){
        console.error("页面未引入vue.js，请检查！");
        return null;
    }
    this._dealOptions();
    this.init();
}

TeddyVue.prototype = {
    /**
     * 获取数据源中的数据
     * @returns {data|{value}|*|{}}
     */
    getDataSource : function (key) {
      return this._data[key];
    },
    /**
     * 处理option，添加默认参数
     * @private
     */
    _dealOptions : function () {
        var options = {
            element: "#id",           //页面元素选择器
            url: "",                  //data请求地址
            data: {value: []},        //数据
            getDataMethod: "url",     //data:从options.data中获取    url:从url中获取(默认)
            methods:{},               //定义函数列表
            isByPage: true,          //获取数据时是否采用分页方式获取  默认true
            pageStyle: "contact"     //contact连接，紧跟在上一页内容后面  cover覆盖方式
        };
        for(var index in options){
            if(undefined == this._options[index]){
                this._options[index] = options[index];
            }
        }
    },
    /**
     * 刷新 this._data中的数据
     * @param data
     * @param type  "contact"   "cover"
     */
    _refreshData : function (data, type) {
        if(type == "contact"){
            /** 将数据内容连接起来 */
            for(var index in this._data){
                if($.isArray(this._data[index])){
                    this._data[index] = this._data[index].concat(data[index]);
                }else{
                    this._data[index] = data[index];
                }
            }
        }else if(type == "cover"){
            /** 清空原先的数组内容，然后push */
            for(var index in this._data){
                if($.isArray(this._data[index])){
                    this._data[index].length = 0;
                    this._data[index] = this._data[index].concat(data[index]);
                }else{
                    this._data[index] = data[index];
                }
            }
        }
    },
    /**
     * 初始化vue，从url中获取数据
     */
    init : function () {
        var nPageSize = $(this._options.element).data("page-size");
        if( this._options.isByPage && !nPageSize){
            return;
        }
        if(this._options.getDataMethod == "url"){
            if(this._options.isByPage){
                this._pageBean.setnPageSize(nPageSize);
            }
            this._data = this.getData();
        }
        else{
            this._data = this._options.data;
        }
        this._Vue = new Vue({
            el : this._options.element,
            data : this._data,
            methods : this._options.methods
        });
    },
    /**
     * 同步从url中获取数据
     * @param pageBean
     * @returns {{}}
     */
    getData : function () {
        var result = {};
        var url = this._options.url;

        if(this._options.getDataMethod == "url" && !url){
            return {};
        }
        var params = {};
        if(this._options.isByPage){
            params = this._pageBean.toJson();
        }
        $.ajax({
            url : url,
            data : params,
            dataType : "json",
            async: false ,   //使用同步的方式,true为异步方式
            success : function (data) {
                if(!data.error){
                    result = data;
                }
            },
            error : function () {
                console.error("从url：" + url + " 中获取数据失败！");
            }
        });
        return result;
    },
    /**
     * 下一页
     */
    nextPage : function () {
        if(!this._options.isByPage){
            return;
        }
        this._pageBean.nextPage();
        this._refreshData(this.getData(),this._options.pageStyle)
    },
    /**
     * 上一页
     *  只有分页方式为cover时，才有上一页
     */
    prePage : function () {
        if(!this._options.isByPage || this._options.pageStyle != "cover"){
            return;
        }
        this._pageBean.prePage();
        this._refreshData(this.getData(),"cover");
    },
    /**
     * getDataMethod='url'时有效
     * 重新加载已有的数据
     * @param params 重新加载时传递的参数，范围在this._options中，可选
     */
    reload : function (params) {
        if(params){
            for(var index in this._options){
                if(undefined != params[index]){
                    this._options[index] = params[index];
                }
            }
        }
        if(this._options.getDataMethod != "url" || !this._options.url){
            return;
        }
        var currPageBean = this._pageBean;
        if(this._options.isByPage){
            var reloadPageSize = currPageBean.nPageSize * (currPageBean.nPageNow == 0 ? 1 : currPageBean.nPageNow);
            this._pageBean = new PageBean(reloadPageSize,0)
        }
        this._refreshData(this.getData(),"cover");
        this._pageBean = currPageBean;
    }
}

/**
 * 分页信息
 * @param nPageSize
 * @param nPageNow
 * @constructor
 */
function PageBean(nPageSize,nPageNow) {
    this.nPageSize = nPageSize ? nPageSize : 0;
    this.nPageNow = nPageNow ? nPageNow : 0;

    this.setnPageSize = function (nPageSize) {
        this.nPageSize = nPageSize;
    }
    this.setnPageNow = function (nPageNow) {
        this.nPageNow = nPageNow;
    }

    this.nextPage = function () {
        this.nPageNow++;
    }
    this.prePage = function () {
        this.nPageNow--;
    }

    this.toJson = function () {
        return {
            "page.nPageSize" : this.nPageSize,
            "page.nPageNow" : this.nPageNow,
        };
    }
}