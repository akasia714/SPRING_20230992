package com.example.demo.controller;

import java.util.List;
import com.example.demo.model.domain.Article;
import com.example.demo.model.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/article_list")
    public String article_list(Model model) {
        List<Article> list = blogService.findAll();
        model.addAttribute("articles", list);
        return "article_list";
    }
    
}