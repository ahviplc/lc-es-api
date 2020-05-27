package com.lc;

import com.lc.pojo.easyexcel.DemoData;
import com.lc.pojo.easyexcel.DemoDataListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.excel.EasyExcel;

/**
 * 这里只有最简单的读
 * 其他在
 * https://github.com/alibaba/easyexcel/tree/master/src/test/java/com/alibaba/easyexcel/test/demo/read
 */

@Slf4j
@SpringBootTest
public class EasyExcelReadTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(EasyExcelReadTests.class);

    @Test
    void testDemo1() {
        // slf4j的两种引入方式
        log.info("info start EasyExcelReadTests test.....注解【@Slf4j】");
        LOGGER.info("info start EasyExcelReadTests test.....引入【LoggerFactory】");
        LOGGER.warn("warn start EasyExcelReadTests test.....引入【LoggerFactory】");
    }

    /**
     * 最简单的读
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoDataListener}
     * <p>
     * 3. 直接读即可
     */
    @Test
    public void simpleRead() {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        // String fileName = EasyExcelFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";

        String fileName = "D:/" + "LC1590546554346.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();

        // 写法2：
        //    fileName = EasyExcelFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        //    ExcelReader excelReader = EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).build();
        //    ReadSheet readSheet = EasyExcel.readSheet(0).build();
        //    excelReader.read(readSheet);
        //    // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        //    excelReader.finish();
    }
}
