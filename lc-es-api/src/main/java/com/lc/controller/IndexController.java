package com.lc.controller;

import com.alibaba.fastjson.JSON;
import com.lc.mapper.MBPUserMapper;
import com.lc.pojo.MBPUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private MBPUserMapper mbpUserMapper;

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
        map.addAttribute("message", "hello Thymeleaf ElasticSearch mybatis-plus");
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

    /**
     * 查询全部MBPUser【mybatis-plus测试用户】
     * http://localhost:8088/userlist
     *
     * @return
     */
    @GetMapping({"/userlist"})
    @ResponseBody
    public String userlist() {
        List<MBPUser> mbpUsersList = mbpUserMapper.selectList(null);
        return JSON.toJSONString(mbpUsersList);
    }
}
