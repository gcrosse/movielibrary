package com.humber.movielibrary.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class StatsPageController {

    private final RestTemplate restTemplate;

    public StatsPageController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
    }

    @GetMapping("/stats")
        public String statsPage(Model model) {
        String baseUrl = "http://host.docker.internal:8081/api/stats";

        Map total = restTemplate.getForObject(baseUrl + "/total", Map.class);
        Map avg = restTemplate.getForObject(baseUrl + "/average-rating", Map.class);
        Map year2025 = restTemplate.getForObject(baseUrl + "/year/2025", Map.class);

        model.addAttribute("total", total);
        model.addAttribute("avg", avg);
        model.addAttribute("year2025", year2025);

        return "stats";
    }
}