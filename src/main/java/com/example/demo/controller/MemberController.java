package com.example.demo.controller;

import org.springframework.ui.Model;
import com.example.demo.model.domain.Member;
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
    @GetMapping("/member_login") 
    public String member_login() {
        return "login";
    }
    @PostMapping("/api/login_check")
    public String checkMembers(@ModelAttribute AddMemberRequest request, Model model) {
    try {
        Member member = memberService.loginCheck(request.getEmail(), request.getPassword());
        model.addAttribute("member", member); 
        return "redirect:/board_list"; 
    } catch (IllegalArgumentException e) {
        model.addAttribute("error", e.getMessage()); 
        return "login"; 
    }
    }    
}