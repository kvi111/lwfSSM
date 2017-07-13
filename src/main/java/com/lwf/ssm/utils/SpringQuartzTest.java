package com.lwf.ssm.utils;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * Created by lwf on 2017/3/6.
 */
public class SpringQuartzTest extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        this.work();
    }

    /*业务实现*/
    public void work() {
        System.out.println("执行调度任务："+new Date());
    }
}
