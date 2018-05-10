package com.panhb.controller;

import com.panhb.controller.base.BaseController;
import com.panhb.model.Result;
import com.panhb.model.entity.User;
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
    UserService userService;

    @RequestMapping("/")
    public Result<List<User>> findAll() {
        log.info("============findAll============");
        return Result.succData(userService.findAll());
    }

}
