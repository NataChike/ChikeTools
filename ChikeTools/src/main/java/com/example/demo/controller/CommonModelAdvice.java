package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.service.CurrentUserService;

@ControllerAdvice
public class CommonModelAdvice {

    @Autowired
    CurrentUserService currentUserService;

    @ModelAttribute("displayName")
    public String displayName() {
        return currentUserService.getDisplayName();
    }
}
