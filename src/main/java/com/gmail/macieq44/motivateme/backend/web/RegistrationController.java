package com.gmail.macieq44.motivateme.backend.web;

import com.gmail.macieq44.motivateme.backend.entity.User;
import com.gmail.macieq44.motivateme.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class RegistrationController {
    @Autowired
    private UserService userService;

    public RegistrationController() {
        super();
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    @ResponseBody
    public GenericResponse registerUserAccount(final UserDto accountDto, final HttpServletRequest request) {
        final User registered = userService.registerNewUserAccount(accountDto);
        return new GenericResponse("success");
    }
}
