package com.lc;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lc.mapper.MBPUserMapper;
import com.lc.mapper.SysConfigMapper;
import com.lc.pojo.MBPUser;
import com.lc.pojo.SysConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class MybatisPlusBasicTests {
    // 继承了BaseMapper，所有的方法都来自己父类
    // 我们也可以编写自己的扩展方法！
    @Autowired
    private MBPUserMapper mbpUserMapper;

    //测试oracle数据库对象
    @Autowired
    private SysConfigMapper sysConfigMapper;

    @Test
    void contextLoadsOracleSelectList() {
        // 参数是一个 Wrapper ，条件构造器，这里我们先不用 null
        // 查询全部用户
        List<SysConfig> sysConfigList = sysConfigMapper.selectList(null);
        sysConfigList.forEach(System.out::println);
    }

    @Test
    void contextLoadsSelectList() {
        // 参数是一个 Wrapper ，条件构造器，这里我们先不用 null
        // 查询全部用户
        List<MBPUser> usersList = mbpUserMapper.selectList(null);
        usersList.forEach(System.out::println);
    }

    // 测试插入
    @Test
    public void testInsert() {
        for (int i = 1; i <= 100; i++) { // 一次生成100个
            MBPUser user = new MBPUser();
            user.setName("LC说Java_"+i);
            user.setAge(3);
            user.setEmail("110@qq.com");
            int result = mbpUserMapper.insert(user); // 帮我们自动生成id
            System.out.println(result); // 受影响的行数
            System.out.println(user); // 发现，id会自动回填
        }
    }

    // 测试更新
    @Test
    public void testUpdate() {
        MBPUser user = new MBPUser();
        // 通过条件自动拼接动态sql
        user.setId(1263667861894451201L);
        user.setName("关注公众号：ahviplc");
        user.setAge(21);
        // 注意：updateById 但是参数是一个 对象！
        int i = mbpUserMapper.updateById(user);
        System.out.println(i);
    }

    // 测试乐观锁成功！
    @Test
    public void testOptimisticLocker() {
        // 1、查询用户信息
        MBPUser user = mbpUserMapper.selectById(1263667861894451201L);
        // 2、修改用户信息
        user.setName("LC");
        user.setEmail("120@qq.com");
        // 3、执行更新操作
        mbpUserMapper.updateById(user);
    }


    // 测试乐观锁失败！多线程下
    @Test
    public void testOptimisticLocker2() {

        // 线程 1
        MBPUser user = mbpUserMapper.selectById(1L);
        user.setName("LC111");
        user.setEmail("120@qq.com");

        // 模拟另外一个线程执行了插队操作
        MBPUser user2 = mbpUserMapper.selectById(1L);
        user2.setName("LC222");
        user2.setEmail("120@qq.com");
        mbpUserMapper.updateById(user2);

        // 自旋锁来多次尝试提交！
        mbpUserMapper.updateById(user); // 如果没有乐观锁就会覆盖插队线程的值！
    }

    // 测试查询
    @Test
    public void testSelectById() {
        MBPUser user = mbpUserMapper.selectById(1L);
        System.out.println(user);
    }

    // 测试批量查询！
    @Test
    public void testSelectByBatchId() {
        List<MBPUser> users = mbpUserMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    // 按条件查询之一使用map操作
    @Test
    public void testSelectByBatchIds() {
        HashMap<String, Object> map = new HashMap<>();
        // 自定义要查询
        map.put("name", "LC说Java");
        map.put("age", 3);

        List<MBPUser> users = mbpUserMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    // 测试分页查询
    @Test
    public void testPage() {
        //  参数一：当前页
        //  参数二：页面大小
        //  使用了分页插件之后，所有的分页操作也变得简单的！
        Page<MBPUser> page = new Page<>(2, 5);
        mbpUserMapper.selectPage(page, null);

        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());

    }


    // 测试删除
    @Test
    public void testDeleteById() {
        mbpUserMapper.deleteById(1L);
    }

    // 通过id批量删除
    @Test
    public void testDeleteBatchId() {
        mbpUserMapper.deleteBatchIds(Arrays.asList(1240620674645544961L, 1240620674645544962L));
    }

    // 通过map删除
    @Test
    public void testDeleteMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "LC说Java");
        mbpUserMapper.deleteByMap(map);
    }
}
