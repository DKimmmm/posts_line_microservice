package com.example.postsline.controlleradvice;


import com.example.postsline.dto.controllerAdvice.BadRequestExceptionDto;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

@Slf4j
@RestControllerAdvice
public class PostLineRestControllerAdvice {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class, IllegalArgumentException.class,
            MissingServletRequestPartException.class, MissingPathVariableException.class, ConstraintViolationException.class})
    public ResponseEntity<BadRequestExceptionDto> handleNoValidDataException(Exception e) {

        e.printStackTrace();

        return new ResponseEntity<>(new BadRequestExceptionDto
                ("Получены данные некорректного формата, попробуйте снова.", e.getMessage(), HttpStatus.BAD_REQUEST.value()),
                HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<BadRequestExceptionDto> handleHttpClientException(HttpClientErrorException e) {

        e.printStackTrace();

        return new ResponseEntity<>(new BadRequestExceptionDto
                ("Доступ закрыт. Либо ограничен доступ, либо не предоставлены данные для аутентификации ", e.getMessage(), HttpStatus.valueOf(403).value()),
                HttpStatus.valueOf(403));

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BadRequestExceptionDto> handleAllException(Exception e) {

        e.printStackTrace();

        return new ResponseEntity<>(new BadRequestExceptionDto
                ("К сожалению, произошла серьезная ошибка. Обратитесь к администратору! ", e.getMessage(), HttpStatus.BAD_REQUEST.value()),
                HttpStatus.BAD_REQUEST);

    }

}
