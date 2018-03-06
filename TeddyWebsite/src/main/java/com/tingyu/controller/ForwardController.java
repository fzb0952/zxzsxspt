package com.tingyu.controller;

import com.tingyu.utils.ParamUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 跳转控制器，该控制器仅仅用于页面直接跳转
 * Created by tingyu on 2017/3/4.
 */
@Controller
public class ForwardController {
    @RequestMapping("/teddy/{pageId}")
    public String findPageId(@PathVariable("pageId") String pageId, Model model) {
        model.addAttribute("pageId", pageId);
        return "front/index";
    }

    /**
     * Forward to home string.
     *
     * @return the string
     */
    @RequestMapping("front/home")
    public String forwardToHome() {
        return "front/home";
    }


    /**
     * Forward to introduction string.
     *
     * @return the string
     */
    @RequestMapping("front/introduction")
    public String forwardToIntroduction() {
        return "front/introduction/introduction";
    }

    /**
     * Forward to my address string.
     *
     * @return the string
     */
    @RequestMapping("front/myAddress")
    public String forwardToMyAddress() {
        return "front/introduction/myAddress";
    }

    /**
     * Forward to life story string.
     *
     * @return the string
     */
    @RequestMapping("front/lifeStory")
    public String forwardToLifeStory() {
        return "front/lifeStory/lifeStory";
    }


    /////////////////////////////////////////////////////////////////////
    /// 接下来是后台页面跳转部分   admin
    /////////////////////////////////////////////////////////////////////
    /**
     * Forward to admin login string.
     *
     * @return the string
     */
    @RequestMapping("admin")
    public String forwardToAdminLogin() {
        return "admin/login";
    }

    /**
     * Forward to admin index string.
     *
     * @return the string
     */
    @RequestMapping("admin/index")
    public String forwardToAdminIndex(){
        return "admin/index";
    }

    @RequestMapping("admin/home")
    public String forwardToAdminHome(){
        return "admin/home";
    }

    /**
     * Forward to admin book string.
     *
     * @return the string
     */
    @RequestMapping("admin/book")
    public String forwardToAdminBook(){
        return "admin/book/index";
    }

    /**
     * Forward to admin create book string.
     *
     * @return the string
     */
    @RequestMapping("admin/create-book")
    public String forwardToAdminCreateBook(){
        return "admin/book/create-book";
    }

    /**
     * Forward to admin chapters string.
     *
     * @return the string
     */
    @RequestMapping("admin/chapters")
    public String forwardToAdminChapters(Model model){
        model.addAttribute("bookId", ParamUtil.getString("bookId"));
        return "admin/book/chapters";
    }
}
