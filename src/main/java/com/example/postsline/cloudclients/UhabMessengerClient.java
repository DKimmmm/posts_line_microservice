package com.example.postsline.cloudclients;

import com.example.postsline.dto.PostWithLikesInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "user-service", url = "${feign.client.config.user-service.url}")//)
public interface UhabMessengerClient {

    @GetMapping(value = "/post-line/post-info/all")
    List<PostWithLikesInfoDto> getAllPosts();

    @GetMapping(value = "/post-line/post-info/by/specification")
    List<PostWithLikesInfoDto> getAllPostsByParams(@RequestParam Integer pageSize,
                                                   @RequestParam Boolean isSortedByLikes,
                                                   @RequestParam Boolean isSortedByComments,
                                                   @RequestParam String searchedBy);

    @DeleteMapping(value = "/post/old-scheduler")
    void schedulePostRemove(@RequestParam Integer markThresholdDays,
                            @RequestParam Integer alreadyDelThresholdDays);

}
