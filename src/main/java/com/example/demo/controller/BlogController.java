package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
//import com.example.demo.model.domain.Article;
import com.example.demo.model.domain.Board;
import com.example.demo.model.service.AddArticleRequest;
import com.example.demo.model.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    /*@GetMapping("/article_list")
    public String article_list(Model model) {
        List<Article> list = blogService.findAll();
        model.addAttribute("articles", list);
        return "article_list";
    }*/
    
    @GetMapping("/board_list")
    public String board_list(Model model) {
        List<Board> list = blogService.findAll();
        model.addAttribute("boards", list);
        return "board_list";
    }
    

    /*@GetMapping("/article_edit/{id}")
    public String article_edit(Model model, @PathVariable Long id){
        Optional<Article> list = blogService.findById(id);

        if (list.isPresent()){
            model.addAttribute("article", list.get());
        }
        else{
            return "error";
        }
        return "article_edit";
    }*/

    @GetMapping("/board_view/{id}")
    public String board_view(Model model, @PathVariable Long id) {
        Optional<Board> list = blogService.findById(id);

        if (list.isPresent()){
            model.addAttribute("boards", list.get());
        } else {
            return "/error_page/article_error";
        }
        return "board_view";
    }
    

    /*@PutMapping("/api/article_edit/{id}")
    public String updateArticle(@PathVariable Long id, @ModelAttribute AddArticleRequest request){
        blogService.update(id, request);
        return "redirect:/article_list";
    }*/

    @DeleteMapping("/api/article_delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        blogService.delete(id);
        return "redirect:/article_list";
    }
    
}