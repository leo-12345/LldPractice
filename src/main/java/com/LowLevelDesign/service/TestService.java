package com.LowLevelDesign.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {
  private static final Logger log = LoggerFactory.getLogger(TestService.class);
  public void test(){
    log.info("Testing test service");
  }
}
