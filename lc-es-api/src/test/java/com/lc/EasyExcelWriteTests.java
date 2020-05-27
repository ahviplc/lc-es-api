package com.lc;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.lc.pojo.easyexcel.DemoData;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 这里只有最简单的写
 * 其他在
 * https://github.com/alibaba/easyexcel/tree/master/src/test/java/com/alibaba/easyexcel/test/demo/write
 */

@Slf4j
@SpringBootTest
public class EasyExcelWriteTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(EasyExcelWriteTests.class);

    /**
     * 创建模拟数据
     *
     * @return
     */
    private List<DemoData> data() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 1; i <= 100; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    @Test
    void testDemo1() {
        // slf4j的两种引入方式
        log.info("info start EasyExcelReadTests test.....注解【@Slf4j】");
        LOGGER.info("info start EasyExcelReadTests test.....引入【LoggerFactory】");
        LOGGER.warn("warn start EasyExcelReadTests test.....引入【LoggerFactory】");
    }

    /**
     * 最简单的写
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>
     * 2. 直接写即可
     */
    @Test
    public void simpleWrite() {
        // 写法1
        // String fileName = EasyExcelFileUtil.getPath() + "simpleWriteFromLC" + System.currentTimeMillis() + ".xlsx";
        // C:/_developSoftKu/ideaIU-2019.1.3.win/%23CodeKu/lc-es-api/lc-es-api/target/test-classes/simpleWriteFromLC1590543907502.xlsx

        String fileName = "D:/" + "LC" + System.currentTimeMillis() + ".xlsx";

        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class).sheet("LC模板").doWrite(data());
        log.info("===============EasyExcel simpleWrite 写 成功===============");
    }

    /**
     * 最简单的写 写法2
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>
     * 2. 直接写即可
     */
    @Test
    public void simpleWrite2() {
        // 写法2
        // fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        String fileName = "D:/" + "LC" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("LC模板").build();
        excelWriter.write(data(), writeSheet);
        /// 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();
        log.info("===============EasyExcel simpleWrite2 写 成功===============");
    }
}
