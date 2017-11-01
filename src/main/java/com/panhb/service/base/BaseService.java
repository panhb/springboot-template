package com.panhb.service.base;


import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author panhb
 */
@Transactional(rollbackFor = Exception.class)
public class BaseService<T> {


}