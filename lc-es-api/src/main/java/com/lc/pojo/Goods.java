package com.lc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//这里使用lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
//商品类
public class Goods {
    private String title;
    private String img;
    private String price;
    //可以自己添加属性
}
