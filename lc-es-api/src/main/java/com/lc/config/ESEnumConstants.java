package com.lc.config;

public enum ESEnumConstants {
    IndexName("jd_goods", "索引名称"),
    Author("LC", "作者");

    // 成员变量
    public String name;//名称
    public String desc;//具体描述

    // 构造方法，注意：构造方法不能为public，因为enum并不可以被实例化
    private ESEnumConstants(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static void main(String[] args) {
        System.out.println(ESEnumConstants.IndexName.name);
        System.out.println(ESEnumConstants.IndexName.name());
        System.out.println(ESEnumConstants.IndexName.desc);
        System.out.println(ESEnumConstants.IndexName.getName());
        System.out.println(ESEnumConstants.Author.getName());
        System.out.println(ESEnumConstants.Author.getDesc());

        //    jd_goods
        //    IndexName
        //    索引名称
        //    jd_goods
        //    LC
        //    作者
    }
}
