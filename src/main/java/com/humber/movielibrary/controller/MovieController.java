package com.humber.movielibrary.controller;

import com.humber.movielibrary.entity.Movie;
import com.humber.movielibrary.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addMovie(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam int year) {

        Movie movie = new Movie(title, genre, year);
        movieRepository.save(movie);

        return "redirect:/";
    }
}