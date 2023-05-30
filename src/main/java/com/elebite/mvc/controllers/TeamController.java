package com.elebite.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeamController {
    @GetMapping("/teams_list")
    public String showDashboard(Model model) {
        return "teams_list";
    }
}