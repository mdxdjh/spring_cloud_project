//package com.ellis.web.task;//package com.com.ellis.web.controller.task;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
///**
// * @author ellis.luo
// * @date 16/11/16 下午9:49
// * @description 定时任务管理器
// */
//@Component
//public class TaskManager
//{
//    private Logger logger = LoggerFactory.getLogger(TaskManager.class);
//
//    @Scheduled(cron = "0/2 * * * * ?")
//    public void executeTestTask()
//    {
//        // 间隔2秒钟,执行test
//        Thread current = Thread.currentThread();
//        logger.info("定时任务1:" + current.getId());
//    }
//}
