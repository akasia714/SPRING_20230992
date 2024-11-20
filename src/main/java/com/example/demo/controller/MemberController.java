package com.example.demo.controller;

import com.example.demo.model.service.MemberService;
import com.example.demo.model.service.AddMemberRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/join_new")
    public String join_new() {
        return "join_new";
    } 
    @PostMapping("/api/members")
    public String addmembers(@ModelAttribute AddMemberRequest request) {
        memberService.saveMember(request);
        return "join_end";
    }
        
}
