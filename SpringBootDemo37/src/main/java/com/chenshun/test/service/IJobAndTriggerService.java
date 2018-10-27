package com.chenshun.test.service;

import com.chenshun.test.entity.JobAndTrigger;
import com.github.pagehelper.PageInfo;

public interface IJobAndTriggerService {

    PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize);

}
