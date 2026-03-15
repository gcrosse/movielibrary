package com.humber.movielibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.humber.movielibrary.entity.Movie;
import com.humber.movielibrary.repository.MovieRepository;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    // Home page
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Show add-movie form
    @GetMapping("/add-movie")
    public String showAddMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "add-movie";
    }

    // Handle form submission
    @PostMapping("/add")
    public String addMovie(@ModelAttribute Movie movie) {
        movieRepository.save(movie);
        return "redirect:/movies";
    }
    @GetMapping("/about")
        public String about() {
        return "about"; 
    }    

    // List movies with optional filtering and sorting
    @GetMapping("/movies")
    public String viewMovies(
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false, defaultValue = "id") String sort,
            Model model) {

        List<Movie> movies;

        if (genre != null && !genre.isEmpty() && year != null) {
            movies = movieRepository.findByGenreAndYear(genre, year, Sort.by(sort));
        } else if (genre != null && !genre.isEmpty()) {
            movies = movieRepository.findByGenre(genre, Sort.by(sort));
        } else if (year != null) {
            movies = movieRepository.findByYear(year, Sort.by(sort));
        } else {
            movies = movieRepository.findAll(Sort.by(sort));
        }

        model.addAttribute("movies", movies);
        return "movies";
    }
}