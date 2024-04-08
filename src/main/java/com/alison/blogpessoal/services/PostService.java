package com.alison.blogpessoal.services;

import com.alison.blogpessoal.model.Post;
import com.alison.blogpessoal.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post save(Post post){
        return postRepository.save(post);
    }

    public Page<Post> list(PageRequest pageRequest){
        return postRepository.findPostPage(PageRequest.of(0,5));
    }

    public Page<Post> listPostPage(Pageable pageable) {
        return postRepository.findPost(pageable);
    }

    public Page<Post> findListPostPage(String title, Pageable pageable){
        return postRepository.findPostByTitlePage(title, pageable);
    }

    public Optional<Post> findPostById(Long id) {
        return postRepository.findById(id);
    }


}
