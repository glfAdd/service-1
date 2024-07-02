package com.glf.service1.controller.user;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author glfadd
 */
@RestController
@RequestMapping("/user")
@Tag(name = "User")
public class UserController {

    @GetMapping("/detail")
    public String getUserDetail() {
        return "123";
    }
}
