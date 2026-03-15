package com.humber.movielibrary.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.humber.movielibrary.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByGenre(String genre, Sort sort);

    List<Movie> findByYear(int year, Sort sort);

    List<Movie> findByGenreAndYear(String genre, int year, Sort sort);
}
