package com.cdtu.salesplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/3/11.
 */
@Controller
public class test {
    @RequestMapping("/se")
    @ResponseBody
    String home() {
        return "test";
    }
}
