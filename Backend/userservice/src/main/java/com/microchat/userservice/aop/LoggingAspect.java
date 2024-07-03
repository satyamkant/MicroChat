package com.microchat.userservice.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    public static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);
}
