package com.lc;

import cn.hutool.core.codec.BCD;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Hutool是一个小而全的Java工具类库，通过静态方法封装，降低相关API的学习成本，提高工作效率，使Java拥有函数式语言般的优雅，让Java语言也可以“甜甜的”。
 * <p>
 * Hutool — A set of tools that keep Java sweet.
 * https://www.hutool.cn
 * <p>
 * GitHub - looly/hutool: A set of tools that keep Java sweet.
 * https://github.com/looly/hutool
 */
public class HutoolTests {
    @Test
    public void hutoolApp() {
        // md5
        Console.log(SecureUtil.md5().digestHex("admin")); // 21232f297a57a5a743894a0e4a801fc3

        String hex16 = new MD5().digestHex16("中国");
        Assertions.assertEquals(16, hex16.length());
        Assertions.assertEquals("cb143acd6c929826", hex16);
        // Assertions.assertEquals("cb143acd6c929827", hex16);

        // IdcardUtil 身份证工具
        String ID_18 = "321083197812162119";
        String ID_15 = "150102880730303";
        //是否有效
        boolean valid = IdcardUtil.isValidCard(ID_18);
        boolean valid15 = IdcardUtil.isValidCard(ID_15);
        //转换
        String convert15To18 = IdcardUtil.convert15To18(ID_15);
        Assertions.assertEquals(convert15To18, "150102198807303035");
        //年龄
        DateTime date = DateUtil.parse("2020-09-16");
        int age = IdcardUtil.getAgeByIdCard(ID_18, date);
        Assertions.assertEquals(age, 41);
        int age2 = IdcardUtil.getAgeByIdCard(ID_15, date);
        Assertions.assertEquals(age2, 32);
        //生日
        String birth = IdcardUtil.getBirthByIdCard(ID_18);
        Assertions.assertEquals(birth, "19781216");
        String birth2 = IdcardUtil.getBirthByIdCard(ID_15);
        Assertions.assertEquals(birth2, "19880730");
        //省份
        String province = IdcardUtil.getProvinceByIdCard(ID_18);
        Assertions.assertEquals(province, "江苏");
        String province2 = IdcardUtil.getProvinceByIdCard(ID_15);
        Assertions.assertEquals(province2, "内蒙古");

        // Dict
        Dict dict = Dict.create()
                .set("key1", 1)//int
                .set("key2", 1000L)//long
                .set("key3", DateTime.now());//Date
        Long v2 = dict.getLong("key2");//1000
        Console.log(v2);

        // BCD
        String strForTest = "123456ABCDEF";
        //转BCD
        byte[] bcd = BCD.strToBcd(strForTest);
        //解码BCD
        String str = BCD.bcdToStr(bcd);
        Console.log(str);
        Assertions.assertEquals(strForTest, str);

        // 其他
    }
}
