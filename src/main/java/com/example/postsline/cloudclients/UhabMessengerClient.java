package com.example.postsline.cloudclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-service")
public interface UhabMessengerClient {

    @GetMapping(value = "/authorization/test/string")
    String getAllPosts();

}
