package com.chenshun.test.service;

import com.chenshun.test.base.RefactService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * User: mew <p />
 * Time: 18/5/16 15:22  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@FeignClient(value = "HELLO-SERVICE-GROUP")
public interface RefactorRefactService extends RefactService {

}
