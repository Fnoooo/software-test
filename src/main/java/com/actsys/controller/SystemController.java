package com.actsys.controller;

import com.actsys.common.StringTools;
import com.actsys.entity.Permission;
import com.actsys.vo.ResponseResult;
import com.actsys.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @desc:
 * @author: Ping
 * @date: 2023/12/12 0:09
 */

@Controller
@Slf4j
public class SystemController {

    @GetMapping("/")
    public String login() {
        return "backend/login" ;
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseResult login(@RequestBody UserVO user, Model model, HttpSession session){
        log.info("userVO:{}", user);
        log.info("hello: {}", model.getAttribute("hello")) ;
        try {
            String password = StringTools.decodeByBase64(user.getPassword());
            log.info("password:{}", password);
            if ("1234".equals(password)) {
                session.setAttribute("user", user) ;
                return ResponseResult.success("登录成功");
            }
        }catch (Exception e) {
            return ResponseResult.serverError() ;
        }
        return ResponseResult.error("登陆失败");

    }

    @GetMapping("/backend/index")
    public String index(Model model) {
        List<Permission> menuTree = Permission.MenuTree() ;
        // add menuTree
        model.addAttribute("menuTree", menuTree);
        return "backend/main/index" ;
    }
    @GetMapping("/404")
    public String notFound(Model model) {
        log.info("hello: {}", model.getAttribute("hello")) ;
        return "backend/404" ;
    }

}
