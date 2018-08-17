package com.panhb.controller;

import com.panhb.annotation.DemoAnnotation;
import com.panhb.controller.base.BaseController;
import com.panhb.model.Result;
import com.panhb.model.entity.User;
import com.panhb.service.TaskService;
import com.panhb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author panhb
 */
@RestController
@Slf4j
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @RequestMapping("/")
    public Result<List<User>> findAll() {
        log.info("============findAll============");
        return Result.succData(userService.findAll());
    }

    @DemoAnnotation
    @RequestMapping("/task")
    public Result task() {
        log.info("============task============");
        taskService.doTaskOne();
        taskService.doTaskTwo();
        taskService.doTaskThree();
        return Result.succ();
    }

}
