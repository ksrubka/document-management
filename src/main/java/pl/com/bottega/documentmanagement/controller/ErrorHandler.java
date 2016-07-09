package pl.com.bottega.documentmanagement.controller;

import com.google.common.collect.Lists;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.com.bottega.documentmanagement.api.AuthRequiredException;

/**
 * Created by Beata Iłowiecka on 09.07.2016.
 */

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(AuthRequiredException.class)
    public ResponseEntity<String> handlerAuthRequiredException() {
        /*
        MultiValueMap<String, String> m = new LinkedMultiValueMap<>();
        m.put("Content-type", Lists.asList("application/json", new String[]{}));*/
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, "application/json");
        return new ResponseEntity<>(
                "{'error': 'authentication_required'}",
                httpHeaders,
                HttpStatus.UNAUTHORIZED
        );
    }
}
