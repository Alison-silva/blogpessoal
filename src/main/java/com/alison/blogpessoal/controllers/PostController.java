package com.alison.blogpessoal.controllers;

import com.alison.blogpessoal.model.Post;
import com.alison.blogpessoal.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("posts", postService.list());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "registerpost")
    public ModelAndView registerpost() {
        ModelAndView modelAndView = new ModelAndView("registerpost");

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "register")
    public ModelAndView register(Post post){
        ModelAndView modelAndView = new ModelAndView("registerpost");

        Date now = new Date();
        post.setTimestamp(now);

        postService.save(post);
        return modelAndView;
    }

}
