package com.example.postsline.controller;

import com.example.postsline.service.LineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post-line")
@RequiredArgsConstructor
public class LineController {

    private final LineService lineService;

    @GetMapping("test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok(lineService.test());
    }
}
