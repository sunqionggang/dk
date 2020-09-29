package dockerproj.dkject.config;/**
 * @Author:sqg
 * @Description
 * @Date:${Time} ${Date}
 * @Modified By:
 **/

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @description: 定时器
 * @author: sqg
 * @create: 2020-09-28 16:34
 */
@Configuration
@Slf4j
public class ScheduleMonitor {

    /**
     * 自动扫描，启动时间点之后5秒执行一次
     * fixedRate：定义一个按一定频率执行的定时任务
     * fixedDelay：定义一个按一定频率执行的定时任务，与上面不同的是，改属性可以配合initialDelay， 定义该任务延迟执行时间。
     * cron：通过表达式来配置任务执行时间
     */
    @Scheduled(fixedRate=5000)
    public void doTask(){
        log.info(Thread.currentThread().getName()+"---5秒一次被调用了");
    }

    /**
     * 自动扫描，启动时间点之后5秒执行一次
     */
    @Scheduled(fixedRate=3000)
    public void doTask2(){
        log.info(Thread.currentThread().getName()+"---3秒一次被调用了");
    }
    /**
     * 自动扫描，启动时间点之后5秒执行一次
     */
    @Scheduled(fixedRate=10000)
    @Async("myAsyncThread")
    public void doTask3(){
        log.info(Thread.currentThread().getName()+"---10秒一次被调用了");
    }
}
