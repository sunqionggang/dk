package dockerproj.dkject.module.service.serviceImpl;/**
 * @Author:sqg
 * @Description
 * @Date:${Time} ${Date}
 * @Modified By:
 **/

import dockerproj.dkject.module.service.MyAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

/**
 * @description: 实现类
 * @author: sqg
 * @create: 2020-09-28 15:15
 */
@EnableAsync
@Service
@Slf4j
public class MyAsyncServiceImpl implements MyAsyncService {
    @Override
    @Async("myAsyncThread")
    public void asyncMyThreadPoolAdd() {
        log.info("当前执行线程->"+Thread.currentThread().getName());
    }

    @Override
    @Async
    public void asyncAdd() {
        log.info("当前执行线程->"+Thread.currentThread().getName());
    }

    @Override
    public void add() {
            log.info("当前执行线程->"+Thread.currentThread().getName());
    }
}
