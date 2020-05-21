package com.lc.controller;

import com.lc.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 解析关键字
     * http://localhost:8088/parse/vue
     *
     * @param keywords
     * @return
     * @throws Exception
     */
    @GetMapping("/parse/{keywords}")
    @ResponseBody
    public Boolean parse(@PathVariable("keywords") String keywords) throws Exception {
        return goodsService.parseGoods(keywords);
    }

    /**
     * 分页搜索
     * http://localhost:8088/search/vue/1/10
     *
     * @param keywords
     * @param pageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    @GetMapping("/search/{keywords}/{pageNo}/{pageSize}")
    @ResponseBody
    public List<Map<String, Object>> search(@PathVariable("keywords") String keywords,
                                            @PathVariable("pageNo") int pageNo,
                                            @PathVariable("pageSize") int pageSize) throws Exception {
        //return goodsService.searchPage(keywords, pageNo, pageSize); //不是高亮版本
        return goodsService.searchPageHighlighter(keywords, pageNo, pageSize); //高亮版本
    }

}
