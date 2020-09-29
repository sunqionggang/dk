package dockerproj.dkject.module.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.*;

/**
 * @description: 定时任务
 * @author: sqg
 * @create: 2020-09-28 16:05
 */
@RestController
@Slf4j
@EnableScheduling
public class TimeTaskController {
    @GetMapping("/doTask")
    public void executeTimer(){
        //延迟0.1秒后启动，1秒1次
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("执行");
            }
        },100,1000);
    }

    @GetMapping("/doTask2")
    public void executeTimer2(){
        //调用后，一天执行一次
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("执行");
            }
        },new Date(),24*60*60*1000);
    }

    @GetMapping("/doSchedule")
    public void useScheduleExecutorService(){
        //延迟1秒后启动，1秒1次
        ScheduledExecutorService service=Executors.newScheduledThreadPool(10);
        service.scheduleAtFixedRate(()-> { log.info("schedule 定时"); },1,1,TimeUnit.SECONDS);
    }

    @GetMapping("/doSchedule2")
    public void useScheduleExecutorService2(){
        //延迟1秒后启动，1天1次
        ScheduledExecutorService service=Executors.newScheduledThreadPool(10);
        service.scheduleAtFixedRate(()-> { log.info("schedule 定时"); },1,1,TimeUnit.DAYS);
    }

}
