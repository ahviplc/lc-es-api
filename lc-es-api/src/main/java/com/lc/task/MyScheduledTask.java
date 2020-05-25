package com.lc.task;

import com.lc.utils.DateUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling // @EnableScheduling修饰范围:用在类上 作用：用来标识这个类是一个定时任务类 加@EnableScheduling来开启对计划任务的支持
public class MyScheduledTask {

    // cron = "1/10 * * * * *" 意思是每分钟的第1秒开始执行 间隔10秒轮循
    @Scheduled(cron = "1/59 * * * * *") // @Scheduled修饰范围:用在方法上 作用：用来标识这个方法是一个定时任务方法 加@Scheduled并配置（任务类型，包括cron,fixedRate,fixedDelay,initialDelay）参数 cron作用:用来决定当前任务方法的循环周期 springboot cron只支持6位写法
    public void task() {
        System.out.println(DateUtil.currentStr() + " " + Thread.currentThread().getName() + " 定时任务类:com.lc.task.MyScheduledTask task() ===============执行中===============");
    }

    // fixedDelay = 1000 * 10 固定间隔任务 10s
    @Scheduled(fixedDelay = 1000 * 10 * 6 * 30) // 这里设置30分钟
    public void task2() {
        System.out.println(DateUtil.currentStr() + " " + Thread.currentThread().getName() + " 定时任务类:com.lc.task.MyScheduledTask task2() ===============执行中===============");
    }

    // fixedRate = 1000 * 10 固定频率任务 10s
    @Scheduled(fixedRate = 1000 * 10 * 6 * 30) // 这里设置30分钟
    public void task3() {
        System.out.println(DateUtil.currentStr() + " " + Thread.currentThread().getName() + " 定时任务类:com.lc.task.MyScheduledTask task3() ===============执行中===============");
    }

    // @Scheduled(initialDelay =1000,fixedRated = 8000),任务第一次执行时延迟一秒，之后按照fixedRated的规则执行
    @Scheduled(initialDelay = 1000 * 3, fixedRate = 1000 * 10 * 6 * 30) // 任务第一次执行时延迟3秒 之后按照fixedRated的规则执行 这里设置30分钟
    public void task4() {
        System.out.println(DateUtil.currentStr() + " " + Thread.currentThread().getName() + " 定时任务类:com.lc.task.MyScheduledTask task4() ===============执行中===============");
    }

    // 输出效果:
    // 2020-05-25 11:48:09.642  INFO 9372 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8088 (http) with context path ''
    // 2020-05-25 11:48:09 scheduling-1 定时任务类:com.lc.task.MyScheduledTask task3() ===============执行中===============
    // 2020-05-25 11:48:09 scheduling-1 定时任务类:com.lc.task.MyScheduledTask task2() ===============执行中===============
    // 2020-05-25 11:48:09.653  INFO 9372 --- [  restartedMain] com.lc.LcEsApiApplication                : Started LcEsApiApplication in 4.168 seconds (JVM running for 5.412)
    // 2020-05-25 11:48:10 scheduling-1 定时任务类:com.lc.task.MyScheduledTask task() ===============执行中===============
    // 2020-05-25 11:48:19 scheduling-1 定时任务类:com.lc.task.MyScheduledTask task3() ===============执行中===============
    // 2020-05-25 11:48:19 scheduling-1 定时任务类:com.lc.task.MyScheduledTask task2() ===============执行中===============
    // 2020-05-25 11:48:20 scheduling-1 定时任务类:com.lc.task.MyScheduledTask task() ===============执行中===============
    // 2020-05-25 11:48:29 scheduling-1 定时任务类:com.lc.task.MyScheduledTask task3() ===============执行中===============
    // 2020-05-25 11:48:29 scheduling-1 定时任务类:com.lc.task.MyScheduledTask task2() ===============执行中===============
    // 2020-05-25 11:48:30 scheduling-1 定时任务类:com.lc.task.MyScheduledTask task() ===============执行中===============
    // 2020-05-25 11:48:39 scheduling-1 定时任务类:com.lc.task.MyScheduledTask task3() ===============执行中===============
    // 2020-05-25 11:48:39 scheduling-1 定时任务类:com.lc.task.MyScheduledTask task2() ===============执行中===============
    // 2020-05-25 11:48:40 scheduling-1 定时任务类:com.lc.task.MyScheduledTask task() ===============执行中===============
}
