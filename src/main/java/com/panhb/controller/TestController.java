package com.panhb.controller;

import com.panhb.annotation.ArgToFiled;
import com.panhb.controller.base.BaseController;
import com.panhb.model.Result;
import com.panhb.model.TestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongbo.pan
 * @date 2018/10/19
 */
@RestController
@Slf4j
public class TestController extends BaseController {

    @RequestMapping("/test")
    public Result<TestVO> test() {
        TestVO testVO =
                ((TestController)AopContext.currentProxy()).testArgToFiled("teststatus");
        return Result.succData(testVO);
    }

    @ArgToFiled
    public TestVO testArgToFiled(String status) {
        return new TestVO();
    }

}
