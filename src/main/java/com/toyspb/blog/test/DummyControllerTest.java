package com.toyspb.blog.test;

import com.toyspb.blog.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyControllerTest {

    // http://localhost:8000/blog/dummy/join (요청)
    // https의 body에 username, password, email 데이터를 가지고 (요청)
    @PostMapping("/dummy/join")
    public String join(User user){ // key=value (약속된 규칙)
        System.out.println("id : "+ user.getId());
        System.out.println("username : "+ user.getUsername());
        System.out.println("password : "+ user.getPassword());
        System.out.println("email : "+ user.getEmail());
        System.out.println("role : "+user.getRole());
        System.out.println("createDate : "+user.getCreateDate());
        return "회원가입이 완료되었습니다.";
    }
}
