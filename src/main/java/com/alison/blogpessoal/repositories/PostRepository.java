package com.alison.blogpessoal.repositories;

import com.alison.blogpessoal.model.Post;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "select * from posts order by timestamp desc", nativeQuery = true)
    Page<Post> findPost(Pageable pageable);

    @Query(value = "select * from posts order by timestamp desc", nativeQuery = true)
    Page<Post> findPostPage(Pageable pageable);

    default Page<Post> findPostByTitlePage(String title, Pageable pageable) {

        if (title == null || title.trim().isEmpty()) {

            return findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                    Sort.by("timestamp").descending()));
        } else {

            Post post = new Post();
            post.setTitle(title);

            ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
                    .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

            Example<Post> example = Example.of(post, exampleMatcher);
            Page<Post> posts = findAll(example, pageable);
            return posts;
        }
    }

}
