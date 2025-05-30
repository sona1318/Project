package com.ivanfranchin.moviesapi.service;

import com.ivanfranchin.moviesapi.exception.MovieNotFoundException;
import com.ivanfranchin.moviesapi.model.Movie;
import com.ivanfranchin.moviesapi.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Movie validateAndGetMovie(String imdb) {
        return movieRepository.findById(imdb).orElseThrow(() -> new MovieNotFoundException(imdb));
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        movieRepository.delete(movie);
    }
}
