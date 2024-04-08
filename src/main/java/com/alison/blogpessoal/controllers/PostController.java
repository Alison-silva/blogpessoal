package com.alison.blogpessoal.controllers;

import com.alison.blogpessoal.model.Post;
import com.alison.blogpessoal.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("posts", postService.list(PageRequest.of(0, 5)));
        return modelAndView;
    }

    @GetMapping("**/postpag")
    public ModelAndView loadPageNotes(@PageableDefault(size = 5) Pageable pageable, ModelAndView model) {
        Page<Post> pagePost = postService.listPostPage(pageable);
        model.addObject("posts", pagePost);
        model.setViewName("index");
        return model;
    }

    @PostMapping("**/findpost")
    public ModelAndView findpost(@RequestParam("titlesearch") String titlesearch,
                                 @PageableDefault(size = 5, sort = {"title"}) Pageable pageable) {

        Page<Post> posts = null;
        posts = postService.findListPostPage(titlesearch, pageable);

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("posts", posts);
        modelAndView.addObject("titlesearch", titlesearch);
        return modelAndView;
    }


    @RequestMapping(method = RequestMethod.GET, value = "**/registerpost")
    public ModelAndView registerpost() {
        ModelAndView modelAndView = new ModelAndView("registerpost");
        modelAndView.addObject("postobj", new Post());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "**/register")
    public ModelAndView register(@Valid Post post, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("registerpost");
            modelAndView.addObject("postobj", post);

            List<String> msg = new ArrayList<String>();
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                msg.add(objectError.getDefaultMessage());
            }
            modelAndView.addObject("msg", msg);
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("registerpost");
        modelAndView.addObject("postobj", post);

        String msgok = new String("Registrado com sucesso!");

        Date now = new Date();
        post.setTimestamp(now);

        postService.save(post);
        modelAndView.addObject("msgok", msgok);
        modelAndView.addObject("postobj", new Post());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "**/posts/{id}")
    public ModelAndView getPostDetail(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("detailpost");
        Post post = postService.findPostById(id).get();
        modelAndView.addObject("posts", post);
        return modelAndView;
    }

}
