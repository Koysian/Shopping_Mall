package com.example.final_exam.Post;

import com.example.final_exam.Domain.CreatePostReq;
import com.example.final_exam.Domain.DeletePostReq;
import com.example.final_exam.Domain.Post;
import com.example.final_exam.SHA256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.List;

import static java.lang.System.out;

@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    @Autowired
    public PostController (PostService postService){
        this.postService = postService;
    }

    @GetMapping("")
    public String loadPosts(Model model){
        try {
            List<Post> postList = postService.loadPosts();

            String temp_title;
            String temp_content;
            String temp_id;
            int temp_postIdx;

            for(int i = 0; i < postList.size(); ++i){
                temp_title = postList.get(i).getTitle();
                temp_content = postList.get(i).getContent();
                temp_id = postList.get(i).getId();
                temp_postIdx = postList.get(i).getPostIdx();

                model.addAttribute("title" + i, temp_title);
                model.addAttribute("postContent" + i, temp_content);
                model.addAttribute("postUserId" + i, temp_id);
                model.addAttribute("postIdx" + i, temp_postIdx);
            }

            model.addAttribute("postSize", postList.size());
            return "Post/posts";
        }
        catch (Exception e){
            return "Post/LoadFailed";
        }
    }

    @PostMapping("/create")
    public String createPost(CreatePostReq form){
        try {
            CreatePostReq createPostReq = form;
            postService.createPost(createPostReq);
            return "homePath";
        }
        catch (Exception e){
            return "Post/createPostError";
        }
    }

    @PostMapping("/delete")
    public String deletePost(DeletePostReq form){
        try {
            DeletePostReq deletePostReq = form;
            postService.deletePost(deletePostReq);

            return "homePath";
        }
        catch (Exception e){
            return "Post/deletePostError";
        }
    }
}
