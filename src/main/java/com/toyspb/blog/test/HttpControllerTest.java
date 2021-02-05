package com.toyspb.blog.test;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

// 사용자가 요청 -> 응답(HTML 파일)
// @Controller


// 사용자가 요청 -> 응답(data)
@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpController Test : ";

    @GetMapping("/http/lombok")
    public String lombokTest(){
        Member m = new Member(1, "dk", "dk_pwd", "email");
        System.out.println(TAG + "getter : " + m.getId());
        m.setId(5000);
        System.out.println(TAG + "getter : " + m.getId());
        return "lombok Test 완료";
    }

    @GetMapping("/http/get")
    // public String getTest(@RequestParam int id, @RequestParam String username){
    public String getTest(Member m){
        return "get 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    @PostMapping("/http/post") // text/plain, application/json
    public String postTest(@RequestBody Member m){ // MessageConvertor (스프링부트)
        return "post 요청 : " +  m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m){
        return "put 요청" +  m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "delete 요청";
    }
}
