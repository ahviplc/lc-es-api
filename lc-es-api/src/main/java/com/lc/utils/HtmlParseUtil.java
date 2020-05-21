package com.lc.utils;

import com.lc.pojo.Goods;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HtmlParseUtil {

    /**
     * 不封装对象版本
     *
     * @param keywords
     */
    public static void parseJD(String keywords) {
        try {
            // 获取请求 需联网
            String url = "https://search.jd.com/Search?keyword=" + keywords;
            // 解析网页(Jsoup返回的)
            Document document = Jsoup.parse(new URL(url), 30000);
            //所有js的方法 这里都可以用
            Element element = document.getElementById("J_goodsList");
            //输出页面
            //System.out.println(element.html());
            //获取所有的li元素
            Elements elements = element.getElementsByTag("li");
            //获取元素中的内容 这里的 el 就是每一个li标签 里面是每个商品的信息上下文
            for (Element el : elements) {
                //关于JD等图片很多的网站 所有图片的资源都是延迟加载的！
                //source-data-lazy-img
                //String img = el.getElementsByTag("img").eq(0).attr("source-data-lazy-img");

                String img = el.getElementsByTag("img").eq(0).attr("src");
                String price = el.getElementsByClass("p-price").eq(0).text();
                String title = el.getElementsByClass("p-name").eq(0).text();
                // 下面两个都可以商品详情链接
                String purl = el.getElementsByClass("p-img").eq(0).get(0).getElementsByTag("a").eq(0).attr("href");
                String purl2 = el.getElementsByClass("p-name").eq(0).get(0).getElementsByTag("a").attr("href");
                System.out.println("==================================================================");
                System.out.println(img);
                System.out.println(price);
                System.out.println(title);
                System.out.println(purl);
                System.out.println(purl2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 封装对象版本
     *
     * @param keywords
     */
    public static List<Goods> parseJDToClass(String keywords) {
        //新建个list 用于接收
        List<Goods> goodsList = new ArrayList<>();
        try {
            // 获取请求 需联网
            String url = "https://search.jd.com/Search?keyword=" + keywords;
            // 解析网页(Jsoup返回的)
            Document document = Jsoup.parse(new URL(url), 30000);
            //所有js的方法 这里都可以用
            Element element = document.getElementById("J_goodsList");
            //输出页面
            //System.out.println(element.html());
            //获取所有的li元素
            Elements elements = element.getElementsByTag("li");
            //获取元素中的内容 这里的 el 就是每一个li标签 里面是每个商品的信息上下文
            for (Element el : elements) {
                //关于JD等图片很多的网站 所有图片的资源都是延迟加载的！
                //source-data-lazy-img
                //String img = el.getElementsByTag("img").eq(0).attr("source-data-lazy-img");

                String img = el.getElementsByTag("img").eq(0).attr("src");
                String price = el.getElementsByClass("p-price").eq(0).text();
                String title = el.getElementsByClass("p-name").eq(0).text();

                Goods goods = new Goods(title, img, price);
                goodsList.add(goods);
                //    System.out.println("==================================================================");
                //    System.out.println(img);
                //    System.out.println(price);
                //    System.out.println(title);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return goodsList;
    }

    public static void main(String[] args) throws Exception {
        parseJD("java");
        //HtmlParseUtil.parseJDToClass("vue").forEach(System.out::println);
    }
}
