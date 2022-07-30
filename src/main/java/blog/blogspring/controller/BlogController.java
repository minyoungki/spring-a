package blog.blogspring.controller;

import blog.blogspring.dto.ContentDto;
import blog.blogspring.entity.Blog;
import blog.blogspring.repository.BlogMapping;
import blog.blogspring.repository.BlogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j //로깅을 위한 어노테이션
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("blog/post")
    public String getBlog() {
        return "contents/content";
    }

    @PostMapping("blog/post")
    public String postBlog(ContentDto form) {
        log.info(form.toString());

        Blog blog = form.toEntity();
        log.info(blog.toString());

        Blog saved = blogRepository.save(blog);
        log.info(saved.toString());

        return "redirect:get/" + saved.getId();
    }

    @GetMapping("blog/get/{id}")
    public String getBlogId(@PathVariable Long id, Model model) {
        //Optional<Blog> blogEntity = blogRepository.findById(id); 자바8 문법 아래랑 동일
        Blog blogEntity = blogRepository.findById(id).orElse(null); //id가 없으면 null을 반환
        model.addAttribute("blog", blogEntity);
        return "contents/show";
    }

    @GetMapping("")
    public String index(Model model) {
        List<Blog> blogEntityList = blogRepository.findAll(); //blogRepository 데이터 가져오기

        model.addAttribute("blogList", blogEntityList);  //가져온 리스트를 뷰로 전달

        return "blog";  // 뷰전달
    }



    @PostMapping("blog/get/{id}/edit")
    public String blogPassword(@PathVariable Long id ,@RequestBody ContentDto password) {
        //패스워드 확인 > 맞으면 다음 페이지
        return "contents/password";
    }

    @GetMapping("/blog/post/{id}")
    public String blogEdit(@PathVariable Long id, Model model) {
        Blog blogEntity = blogRepository.findById(id).orElse(null);

        model.addAttribute("blog", blogEntity);

        return "contents/edit";
    }


    @PostMapping("blog/update")
    public String blogUpdate(ContentDto form) {
        Blog blogEntity = form.toEntity();
        Blog updateTarget = blogRepository.findById(blogEntity.getId()).orElse(null);
        if (updateTarget != null) {
            blogRepository.save(blogEntity);
        }
            return "redirect:get/" + blogEntity.getId();
    }
}