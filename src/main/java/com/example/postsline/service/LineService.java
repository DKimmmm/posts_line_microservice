package com.example.postsline.service;

import com.example.postsline.cloudclients.UhabMessengerClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LineService {

    private final UhabMessengerClient messengerClient;

    public String test() {
        log.info("- -  @GetMapping(value = \"/authorization/test/string\") ");
        return messengerClient.getAllPosts();
    }

}
