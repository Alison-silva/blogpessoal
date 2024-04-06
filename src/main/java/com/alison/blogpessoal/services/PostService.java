package com.alison.blogpessoal.services;

import com.alison.blogpessoal.model.Post;
import com.alison.blogpessoal.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post save(Post post){
        return postRepository.save(post);
    }

    public List<Post> list(){
        return postRepository.findAll();
    }

}
