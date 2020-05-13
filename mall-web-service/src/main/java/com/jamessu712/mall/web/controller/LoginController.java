package com.jamessu712.mall.web.controller;

import com.jamessu712.mall.web.WebConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Slf4j
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam(value="username", required = false) String username,
                              HttpServletRequest request, HttpServletResponse response, HttpSession session) {


        String token = null;
        if (session.getAttribute(WebConstant.SESSION_KEY) == null) {
            token = UUID.randomUUID().toString();
            session.setAttribute(WebConstant.SESSION_KEY, token);
        }

        log.info("token ======================== " + token);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("token", token);

        log.info("sid =================== " + request.getSession().getId());

        return mv;
    }
}
