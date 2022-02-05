package ru.bodins.forum.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.bodins.forum.model.Post;
import ru.bodins.forum.service.PostService;

import java.util.List;

@Controller
public class IndexControl {

    private final PostService posts;

    public IndexControl(PostService posts) {
        this.posts = posts;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        System.out.println("****Working controller INDEX****");
        List<Post> postList = posts.getAll();
        model.addAttribute("posts", postList);
        model.addAttribute("user", SecurityContextHolder
                .getContext().getAuthentication().getPrincipal());
//        System.out.println("Все посты на форуме ---> " + postList);
        return "index";
    }
}
