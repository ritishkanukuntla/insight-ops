package com.example.hack24;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/status")
@Slf4j
public class Hack24Controller {

    @Resource
    private Hack24ConfigurationProperties hack24ConfigurationProperties;

    @GetMapping("/ok")
    public ResponseEntity<Response> getOk() throws InterruptedException {
        log.info("Received request to /ok endpoint");
        Thread.sleep(30);
        var response = new ResponseEntity<>(
                new Response(hack24ConfigurationProperties.getApplicationVersion(), "OK"),
                Utils.getResponseHeaders(hack24ConfigurationProperties),
                200);
        log.info("Sending response for /ok endpoint");
        return response;
    }

    @GetMapping("/no-content")
    public ResponseEntity<Void> getNoContent() throws InterruptedException {
        log.info("Received request to /no-content endpoint");
        Thread.sleep(30);
        var response = new ResponseEntity<Void>(
                null,
                Utils.getResponseHeaders(hack24ConfigurationProperties),
                HttpStatus.NO_CONTENT);
        log.info("Sending response for /no-content endpoint");
        return response;
    }
}