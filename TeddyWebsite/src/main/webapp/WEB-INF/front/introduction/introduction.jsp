<%--
  Created by IntelliJ IDEA.
  User: tingyu
  Date: 2017/3/5
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
    <base id="base" data-href="${pageContext.request.contextPath}">
    <c:set var="base" value="${pageContext.request.contextPath}"></c:set>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="${base}/favicon.ico" />
    <link rel="bookmark" href="${base}/favicon.ico" type="image/x-icon"　/>
    <title>introduction</title>

    <link rel="stylesheet" href="${base}/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${base}/hplus/css/plugins/sweetalert/sweetalert.css">
    <link rel="stylesheet" href="${base}/hplus/css/animate.min.css">
    <link rel="stylesheet" href="${base}/hplus/css/style.min.css">
    <link rel="stylesheet" href="${base}/css/common.css">
    <link rel="stylesheet" href="${base}/css/introduction/introduction.css">
</head>
<body>
<div class="container-fluid">
    <div class="row content">
        <div id="content-left" class="col-xs-9 col-md-10 animated fadeInLeft">
            <div id="introduction" class="row nav-info" data-position="6">
                <div class="col-xs-12 col-sm-12 col-md-12">
                    <div class="title">NICE TO MEET YOU</div>
                    <p class="subhead">很高兴遇到你</p>
                    <p class="paragraph">
                        范中伟，一个努力奋斗的阳光小伙！离开熟悉的校园快两年了，每天过着规律而充实的生活：
                    <p>
                    <p class="paragraph">
                        清晨，一杯热水，些许杂粮，唤醒代谢；一本好书，细品片刻，激活思维。
                    </p>
                    <p class="paragraph">
                        午间，一餐温饱，齐聚好友，漫步闲谈；一方天地，抱枕小憩，养精蓄锐。
                    </p>
                    <p class="paragraph">
                        入夜，一副哑铃，强身健体，乐在其中；一串编码，千思万绪，演绎梦想。
                    </p>
                    <p class="paragraph">
                        很多人不理解我为什么每天去健身房，挥汗如雨，早出晚归，健身能让你变得富有吗？我的答案是：不能！你千万别健身，一来浪费时间，二来浪费金钱!和健身一样，有的人不理解，现在有那么多博客网站，想写博客直接注册一个不就完事儿了，非得这么麻烦。其实很早以前我就一直想要拥有一个自己的网站，记录生活，分享知识。虽然现在的社交软件、博客论坛已经能满足我以上的要求，但是这也像健身等很多事情一样，不亲身经历过，又怎能明白其中的乐趣呢。
                    </p>
                    <p class="paragraph">
                        最后我还要感谢一个人，You make me wanna be a better man.
                    </p>
                </div>
            </div>
            <div id="education" class="row nav-info" data-position="28">
                <div class="col-xs-12 col-sm-12 col-md-12">
                    <div class="title">EDUCATION</div>
                    <p class="subhead">我的教育经历</p>
                    <div class="col-xs-12 col-sm-10 col-sm-offset-2 col-md-10 col-md-offset-2 time">
                        <div class="time-line">
                            <div class="time-point">NOW</div>
                            <div class="edu-info">WORK：在物欲横流的社会里，奋笔疾书，书写新的篇章。</div>
                        </div>
                        <div class="time-line">
                            <div class="time-point"><span class="outside">2015</span></div>
                            <div class="edu-info">UNIVERSITY：在如诗画般的<a target="_blank"
                                                                      href="http://www.xhu.edu.cn/"><label>西华大学</label></a>里，满载梦想，扬帆远航。
                            </div>
                        </div>
                        <div class="time-line">
                            <div class="time-point"><span class="outside">2011</span></div>
                            <div class="edu-info">HIGH SCHOOL:在懵懵懂懂的年纪里，跟随着求知欲望，度过了我们的青葱岁月。</div>
                        </div>
                        <div class="time-line">
                            <div class="time-point"><span class="outside">2005</span></div>
                            <div class="edu-info">PRIMARY SCHOOL：在无忧无虑的年纪里，伴随着欢声笑语，推开了知识的大门。</div>
                        </div>
                        <div class="time-line">
                            <div class="time-point"><span>1999</span></div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="experience" class="row nav-info" data-position="48">
                <div class="title">WORK EXPERIENCE</div>
                <p class="subhead">我的工作经历</p>
                <div class="col-xs-12 col-sm-12 col-md-12 time">
                    <div class="time-line">
                        <div class="col-xs-2 col-sm-3 col-md-2 experience-time">
                            <span class="pull-right">2016/7-至今</span>
                        </div>
                        <div class="col-xs-2 time-point clear-padding"></div>
                        <div class="col-xs-9 col-sm-8 col-md-9 panel panel-default clear-padding experience-info">
                            <div class="panel-heading">
                                <h4 class="clear-margin">北京华宇信息技术有限公司</h4>
                                <span class="xs-experience-time hidden">2016/7-至今</span>
                            </div>
                            <div class="panel-body">
                                <p><label>职位：</label>软件工程师</p>
                                <p><label>描述：</label>主要对公司已有产品“数字法院业务应用系统”进行维护。</p>
                            </div>
                        </div>
                    </div>
                    <div class="time-line">
                        <div class="col-xs-2 col-sm-3 col-md-2 experience-time">
                            <span class="pull-right">2015/6-2016/7</span>
                        </div>
                        <div class="col-xs-2 time-point clear-padding"></div>
                        <div class="col-xs-9 col-sm-8 col-md-9 panel panel-default clear-padding experience-info">
                            <div class="panel-heading">
                                <h4 class="clear-margin">软通动力信息技术有限公司</h4>
                                <span class="xs-experience-time hidden">2015/6-2016/7</span>
                            </div>
                            <div class="panel-body">
                                <p><label>职位：</label>软件工程师</p>
                                <p><label>描述：</label>主要负责需求交流、任务计划制定、WEB框架和后台通信框架搭建。</p>
                            </div>
                        </div>
                    </div>
                    <div class="time-line">
                        <div class="col-xs-2 col-sm-3 col-md-2 experience-time">
                            <span class="pull-right">2014/7-2015/6</span>
                        </div>
                        <div class="col-xs-2 time-point clear-padding"></div>
                        <div class="col-xs-9 col-sm-8 col-md-9 panel panel-default clear-padding experience-info">
                            <div class="panel-heading">
                                <h4 class="clear-margin">中国电子科技集团第十研究所</h4>
                                <span class="xs-experience-time hidden">2014/7-2015/6</span>
                            </div>
                            <div class="panel-body">
                                <p><label>职位：</label>软件实习工程师</p>
                                <p><label>描述：</label>主要使用qt设计和开发一些窗口程序！</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="skills" class="row nav-info" data-position="69">
                <div class="title">TECHNICAL SKILLS</div>
                <p class="subhead">我的工作技能</p>
                <div class="skill panel panel-info col-xs-10 col-xs-offset-1 col-sm-5 col-sm-offset-1 col-md-5 col-md-offset-1 clear-padding">
                    <div class="panel-heading">Java</div>
                    <div class="panel-body">
                        <div class="progress">
                            <div class="progress-bar progress-bar-info progress-bar-striped active" role="progressbar"
                                 aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="skill panel panel-info col-xs-10 col-xs-offset-1 col-sm-5 col-sm-offset-1 col-md-5 col-md-offset-1 clear-padding">
                    <div class="panel-heading">Spring MVC、Hibernate、Mybatis</div>
                    <div class="panel-body">
                        <div class="progress">
                            <div class="progress-bar progress-bar-info progress-bar-striped active" role="progressbar"
                                 aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="skill panel panel-info col-xs-10 col-xs-offset-1 col-sm-5 col-sm-offset-1 col-md-5 col-md-offset-1 clear-padding">
                    <div class="panel-heading">Mysql、Postgresql、Sybase</div>
                    <div class="panel-body">
                        <div class="progress">
                            <div class="progress-bar progress-bar-info progress-bar-striped active" role="progressbar"
                                 aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="skill panel panel-info col-xs-10 col-xs-offset-1 col-sm-5 col-sm-offset-1 col-md-5 col-md-offset-1 clear-padding">
                    <div class="panel-heading">HTML5、CSS、JavaScript、JQuery</div>
                    <div class="panel-body">
                        <div class="progress">
                            <div class="progress-bar progress-bar-info progress-bar-striped active" role="progressbar"
                                 aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="skill panel panel-info col-xs-10 col-xs-offset-1 col-sm-5 col-sm-offset-1 col-md-5 col-md-offset-1 clear-padding">
                    <div class="panel-heading">Bootstrap、AngularJS、Node.js、Three.js</div>
                    <div class="panel-body">
                        <div class="progress">
                            <div class="progress-bar progress-bar-info progress-bar-striped active" role="progressbar"
                                 aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="skill panel panel-info col-xs-10 col-xs-offset-1 col-sm-5 col-sm-offset-1 col-md-5 col-md-offset-1 clear-padding">
                    <div class="panel-heading">Linux、Tomcat、SVN、GIT</div>
                    <div class="panel-body">
                        <div class="progress">
                            <div class="progress-bar progress-bar-info progress-bar-striped active" role="progressbar"
                                 aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="contact" class="row nav-info" data-position="90">
                <div class="title">CONTACT ME</div>
                <p class="subhead">联系我</p>
                <div class="col-xs-10 col-xs-offset-1 col-sm-11 col-sm-offset-1 col-md-11 col-md-offset-1 well clear-padding">
                    <!-- 16:9 aspect ratio -->
                    <div class="embed-responsive embed-responsive-16by9">
                        <iframe class="embed-responsive-item" src="${base}/front/myAddress"></iframe>
                    </div>
                </div>
                <div class="col-xs-12 col-xs-offset-0 col-sm-11 col-sm-offset-1 col-md-11 col-md-offset-1">
                    <div class="col-xs-12 col-sm-4 col-md-4 contact-info clear-padding">
                        <p class="col-md-12"><span class="glyphicon glyphicon-map-marker"></span>成都市双流县华新下街43号</p>
                        <p class="col-md-12"><span class="glyphicon glyphicon-earphone"></span>18202822990</p>
                        <p class="col-md-12"><span class="glyphicon glyphicon-envelope"></span>fzwtingyu@163.com</p>
                        <p class="col-md-12"><span class="glyphicon glyphicon-globe"></span><a href="http://www.fanzhongwei.com" target="_blank">www.fanzhongwei.com</a></p>
                    </div>
                    <div class="col-xs-12 col-sm-8 col-md-8 contact-message clear-padding">
                        <form id="contact-form">
                            <div class="form-group has-feedback col-xs-12 col-sm-6 col-md-6 clear-padding-r">
                                <input type="text" class="form-control" id="contact-name" name="contact-name" placeholder="Name" aria-describedby="InputName">
                                <span class="glyphicon glyphicon-ok form-control-feedback hidden" aria-hidden="true"></span>
                            </div>
                            <div class="form-group has-feedback col-xs-12 col-sm-6 col-md-6 clear-padding-r">
                                <div class="input-group">
                                    <input type="email" class="form-control" id="contact-email" name="contact-email" placeholder="Email" aria-describedby="InputEmail1">
                                    <span class="glyphicon glyphicon-ok form-control-feedback hidden" aria-hidden="true"></span>
                                    <div class="input-group-btn">
                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Action <span class="caret"></span></button>
                                        <ul class="dropdown-menu">
                                        </ul>
                                    </div><!-- /btn-group -->
                                </div><!-- /input-group -->
                            </div>
                            <div class="form-group has-feedback col-xs-12 col-sm-12 col-md-12 clear-padding-r">
                                <textarea class="form-control" rows="6" id="contact-message" name="contact-message" placeholder="Message" aria-describedby="InputMessage"></textarea>
                                <span class="glyphicon glyphicon-ok form-control-feedback hidden" aria-hidden="true"></span>
                            </div>
                            <div class="form-group col-xs-12 col-sm-12 col-md-12 clear-padding-r">
                                <button id="contact-btn" type="button" class="btn btn-primary btn-lg btn-outline col-xs-12 col-sm-12 col-md-12" onclick="contactMe()">
                                    <div class="sk-spinner sk-spinner-rotating-plane hidden"></div>CONTACT ME
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div id="content-right" class="col-xs-3 col-md-2 animated fadeInRight">
            <div class="row">
                <div id="introduction-nav" class="col-xs-2 col-md-2">
                    <div class="flag progress-bar-success" data-position="0" style="top:6%"></div>
                    <div class="progress clear-margin clear-padding">
                        <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar"
                             aria-valuenow="6" aria-valuemin="0" aria-valuemax="100" style="width: 6%">
                        </div>
                    </div>
                </div>
                <div id="introduction-title" class="col-xs-8 col-sm-10 col-md-10 clear-padding-l">
                    <ul class="list-group">
                        <li class="list-group-item active" data-position="6">
                            <span class="glyphicon glyphicon-user"></span>
                            <span class="title">自我介绍</span>
                        </li>
                        <li class="list-group-item" data-position="28">
                            <span class="glyphicon glyphicon-signal"></span>
                            <span class="title">教育经历</span>
                        </li>
                        <li class="list-group-item" data-position="48">
                            <span class="glyphicon glyphicon-briefcase"></span>
                            <span class="title">工作经验</span>
                        </li>
                        <li class="list-group-item" data-position="69">
                            <span class="glyphicon glyphicon-envelope"></span>
                            <span class="title">工作技能</span>
                        </li>
                        <li class="list-group-item" data-position="90">
                            <span class="glyphicon glyphicon-envelope"></span>
                            <span class="title">联系我</span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>


<script src="${base}/js/lib/jquery-1.12.2.min.js"></script>
<script src="${base}/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${base}/hplus/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="${base}/hplus/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${base}/hplus/js/plugins/suggest/bootstrap-suggest.min.js"></script>
<script src="${base}/js/common/CommonUtils.js"></script>
<script src="${base}/js/introduction/introduction.js"></script>
</body>
</html>
