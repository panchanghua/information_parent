package com.pch.meeting.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/r/r1")
    @PreAuthorize("hasAnyAuthority('p2')")
    public String r1(){
        return SecurityContextHolder.getContext().getAuthentication().toString();
    }

    @PostMapping("/r/r2")
    public String r2(){
        return "r2";
    }
}
