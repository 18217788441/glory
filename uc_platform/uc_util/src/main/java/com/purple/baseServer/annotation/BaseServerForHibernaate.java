package com.purple.baseServer.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Transactional(value="hibernate_transactionManager", readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public @interface BaseServerForHibernaate {

}
