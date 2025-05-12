package com.example.postsline.service;

import com.example.postsline.cloudclients.UhabMessengerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LineService {

    private final UhabMessengerClient messengerClient;

    public String test() {
        return messengerClient.getAllPosts();
    }

}
