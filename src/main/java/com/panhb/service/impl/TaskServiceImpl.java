package com.panhb.service.impl;

import com.panhb.service.TaskService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author hongbo.pan
 * @date 2018/8/17
 */
@Slf4j
@Service
public class TaskServiceImpl implements TaskService {

    private Random random = new Random();

    @Override
    @SneakyThrows
    @Async("taskExecutor")
    public void doTaskOne() {
        log.info("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务一，耗时：" + (end - start) + "毫秒");
    }

    @Override
    @SneakyThrows
    @Async
    public void doTaskTwo() {
        log.info("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务二，耗时：" + (end - start) + "毫秒");
    }

    @Override
    @SneakyThrows
    @Async
    public void doTaskThree() {
        log.info("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务三，耗时：" + (end - start) + "毫秒");
    }
}
