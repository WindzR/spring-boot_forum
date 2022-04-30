package ru.bodins.forum.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.bodins.forum.model.Author;
import ru.bodins.forum.model.Comment;
import ru.bodins.forum.model.Post;
import ru.bodins.forum.service.PostService;
import java.util.Date;

@Controller
public class PostControl {

    private final PostService service;

    public PostControl(PostService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create() {
        return "post/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("post")Post post) {
        post.setCreated(new Date());
        System.out.println(post);
        service.savePost(post);
        return "redirect:/index";
    }

    @GetMapping("/update")
    public String edit(@RequestParam("id") int id, Model model) {
        System.out.println("****Working controller UPDATE****");
        Post post = service.findPostById(id);
        post.setCreated(new Date());
        model.addAttribute("post", post);
        return "post/update";
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") int id, Model model) {
        System.out.println("****Working controller VIEW****");
        Post post = service.findPostById(id);
        Author author = service.findAuthorById(2);
        model.addAttribute("post", post);
        model.addAttribute("author", author);
        model.addAttribute("user", SecurityContextHolder
                .getContext().getAuthentication().getPrincipal());
        return "post/post";
    }

    @PostMapping("/save/comment")
    public String saveComment(@RequestParam("post_id") int id,
                              @RequestParam("desc") String text,
                              @ModelAttribute("comment")Comment comment,
                              RedirectAttributes redirect) {
        System.out.println("****Working controller SAVE COMMENT****");
        comment.setCreated(new Date());
        comment.setComment(text);
        Author author = service.findAuthorById(2);
        comment.setAuthor(author);
        Post post = service.findPostById(id);
        post.addComment(comment);
        service.saveComment(comment);
        redirect.addAttribute("id", id);
        return "redirect:/view";
    }
}
