package com.example.demo.model.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.example.demo.model.domain.Article;
import com.example.demo.model.repository.BoardRepository;
import com.example.demo.model.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {
    @Autowired
    private final BoardRepository blogRepository;

    /*public List<Article> findAll(){
        return blogRepository.findAll();
    }*/

    public List<Board> findAll(){
        return blogRepository.findAll();
    }

    /*public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }*/

    /*public Optional<Article> findById(Long id){
        return blogRepository.findById(id);
    }*/

    public Optional<Board> findById(Long id){
        return blogRepository.findById(id);
    }

    public Page<Board> findAll(Pageable pageable){
        return blogRepository.findAll(pageable);
    }

    public Page<Board> searchByKeyword(String keyword, Pageable pageable){
        return blogRepository.findByTitleContainingIgnoreCase(keyword, pageable);
    }

    /*public void update(Long id, AddArticleRequest request){
        Optional<Article> optionalArticle = blogRepository.findById(id);
        optionalArticle.ifPresent(article -> {
            article.update(request.getTitle(), request.getContent());
            blogRepository.save(article);
        });
    }*/

    public Board save(AddArticleRequest request){
        
        return blogRepository.save(request.toEntity());
    }

    public void delete(Long id){
        blogRepository.deleteById(id);
    }
}
