package com.panhb.controller;

import com.panhb.controller.base.BaseController;
import com.panhb.model.entity.User;
import com.panhb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author panhb
 */
@RestController
public class UserController extends BaseController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public List<User> findAll() {
        log.info("============findAll============");
        return userService.findAll();
    }

}
