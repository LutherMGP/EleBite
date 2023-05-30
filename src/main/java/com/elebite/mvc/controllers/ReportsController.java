package com.elebite.mvc.controllers;

import com.elebite.mvc.dto.TaskDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ReportsController {

    @GetMapping("/reports")
    public String showReports(Model model) {
        return "reports";
    }
}
