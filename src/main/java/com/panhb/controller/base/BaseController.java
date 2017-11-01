package com.panhb.controller.base;

import org.springframework.stereotype.Controller;


/**
 * @author panhb
 */
@Controller
public class BaseController {

	public int initPageNumber(Integer pageNumber){
		if(pageNumber == null){
			return 1;
		}
		return pageNumber;
	}

	public int initPageSize(Integer pageSize){
		if(pageSize == null){
			return 10;
		}
		return pageSize;
	}
}
