package com.example.postsline.cloudclients;

import com.example.postsline.dto.PostInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "user-service", url = "http://localhost:8081/uhab")
public interface UhabMessengerClient {

    @GetMapping(value = "/post-line/post-info/all")
    List<PostInfoDto> getAllPosts();

}
