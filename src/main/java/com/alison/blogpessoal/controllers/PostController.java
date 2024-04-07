package com.alison.blogpessoal.controllers;

import com.alison.blogpessoal.model.Post;
import com.alison.blogpessoal.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        modelAndView.addObject("posts", postService.list());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "registerpost")
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

}
