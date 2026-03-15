package com.humber.movielibrary.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity  
@Table(name = "movie") 
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Genre is required")
    private String genre;

    @Min(value = 1900, message = "Release year must be after 1900")
    @Max(value = 2100, message = "Release year must be before 2100")
    @Column(name = "`year`")  // Escape the reserved keyword
    private int year;

    @Min(value = 1, message = "Rating must be between 1 and 10")
    @Max(value = 10, message = "Rating must be between 1 and 10")
    private int rating;

    private LocalDateTime createdAt;

    @PrePersist
    public void setTimestamp() {
        createdAt = LocalDateTime.now();
    }

    // Default constructor (needed by JPA)
    public Movie() {}

    // Convenience constructor
    public Movie(String title, String genre, int year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = 5; // default rating
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public int getRating() {
        return rating;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}