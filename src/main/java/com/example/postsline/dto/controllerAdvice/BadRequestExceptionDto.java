package com.example.postsline.dto.controllerAdvice;

public record BadRequestExceptionDto(

        String title,

        String detail,

        Integer status

) {
}
