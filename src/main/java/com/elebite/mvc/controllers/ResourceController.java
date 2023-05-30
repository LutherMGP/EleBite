package com.elebite.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResourceController {

    @GetMapping("/resources")
    public String showResources(Model model) {
        return "members_list";
    }
}