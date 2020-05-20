package com.lc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    /**
     * 这三个都可以访问 http://localhost:8088/index  http://localhost:8088/api
     *
     * @return
     */
    @GetMapping({"/", "/index", "/api"})
    @ResponseBody
    public String index() {
        return "Hello,Index from LC";
    }
}
