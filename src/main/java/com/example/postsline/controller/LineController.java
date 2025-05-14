package com.example.postsline.controller;

import com.example.postsline.dto.PostWithLikesInfoDto;
import com.example.postsline.service.LineService;
import com.example.postsline.valid.ValidParamsForPostList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/post-line")
@RequiredArgsConstructor
@Validated
public class LineController {

    private final LineService lineService;

    @GetMapping("/all")
    public ResponseEntity<List<PostWithLikesInfoDto>> getAllPostInfo() {

        return ResponseEntity.ok(
                lineService.getAllPostInfoList()
        );

    }

    @GetMapping("/by-params")
    @ValidParamsForPostList
    public ResponseEntity<List<PostWithLikesInfoDto>> getPostInfoListByParams(
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) Boolean isSortedByLikesAndComments,
            @RequestParam(required = false) String searchedBy
    ) {
        log.info("{} {} {}", pageSize, isSortedByLikesAndComments, searchedBy);
        return ResponseEntity.ok(
                lineService.getAllByParams(
                        pageSize, isSortedByLikesAndComments, searchedBy
                )
        );

    }
}
