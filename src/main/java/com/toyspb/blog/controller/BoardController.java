package com.toyspb.blog.controller;

import com.toyspb.blog.config.auth.PrincipalDetail;
import com.toyspb.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 컨트롤러에서 세션을 어떻게 찾는지?
    // @AuthenticationPrincipal PrincipalDetail principal
    @GetMapping({"", "/"})
    public String index(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){ // 스프링에서 데이터를 가져갈때 쓰는 오브젝트
        // /WEB-INF/views/index.jsp
        // System.out.println("로그인 사용자 아이디 : " + principal.getUsername());
        model.addAttribute("boards", boardService.글목록(pageable));
        return "index"; // @controller로 날리면 viewResolver가 작동!!
    }

    @GetMapping("/board/{id}")
    public String findById(@PathVariable int id, Model model){
        model.addAttribute("board", boardService.글상세보기(id));
        return "board/detail";
    }

    @GetMapping("/board/{id}/updateForm")
    public String updateFrom(@PathVariable int id, Model model){
        model.addAttribute("board", boardService.글상세보기(id));
        return "board/updateForm";
    }

    // USER 권한이 필요
    @GetMapping("/board/saveForm")
    public String saveForm(){
        return "board/saveForm";
    }
}
