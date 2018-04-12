package com.chenshun.test.util.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * User: mew <p />
 * Time: 18/4/11 15:40  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class MyJobListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        // Job开始前
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        // Job完成后
    }

}
