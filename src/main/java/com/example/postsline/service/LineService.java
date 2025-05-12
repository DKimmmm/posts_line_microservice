package com.example.postsline.service;

import com.example.postsline.cloudclients.UhabMessengerClient;
import com.example.postsline.dto.PostInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LineService {

    private final UhabMessengerClient messengerClient;

    public List<PostInfoDto> getAllPostInfoList() {

        log.info("- -  @GetMapping(value = \"/post-line/post-info/all\") ");
        return messengerClient.getAllPosts();

    }

}
