package com.lc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    /**
     * 这两个都可以访问 http://localhost:8088/index  http://localhost:8088/api
     *
     * @return
     */
    @GetMapping({"/hello", "/api"})
    @ResponseBody
    public String index() {
        return "Hello,Index from LC";
    }

    /**
     * http://localhost:8088/index
     *
     * @param map
     * @return
     */
    @GetMapping({"/", "/index"})
    public String HelloIndex(ModelMap map) {
        map.addAttribute("message", "hello Thymeleaf");
        return "welcome";
    }

    /**
     * http://localhost:8088/goodslist
     *
     * @param map
     * @return
     */
    @GetMapping({"/goodslist"})
    public String goodsListIndex(ModelMap map) {
        map.addAttribute("message", "hello Thymeleaf");
        return "goodsList";
    }
}
