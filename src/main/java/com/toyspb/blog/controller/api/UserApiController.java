package com.toyspb.blog.controller.api;

import com.toyspb.blog.dto.ResponseDto;
import com.toyspb.blog.model.RoleType;
import com.toyspb.blog.model.User;
import com.toyspb.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    // @Autowired
    // private HttpSession session;

    /*
    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user){ // username, password, email
        System.out.println("UserApiController : save 호출됨." );
        // 실제로 DB에 insert를 하고 아래에서 return이 되면 되요.
        user.setRole(RoleType.USER);
        int result = userService.회원가입(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), result); // 자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
    }*/

    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user){ // username, password, email
        System.out.println("UserApiController : save 호출됨." );
        // 실제로 DB에 insert를 하고 아래에서 return이 되면 되요.
        user.setRole(RoleType.USER);
        userService.회원가입(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
    }

}


    /*
    // 전통적인 스프링 방식으로 로그인.
    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
        System.out.println("UserApiController : login 호출됨.");
        User principal = userService.로그인(user); // principal (접근주체)

        if(principal != null){
            session.setAttribute("principal", principal);
        }

        return new ResponseDto<>(HttpStatus.OK.value(), 1);
    }

     */