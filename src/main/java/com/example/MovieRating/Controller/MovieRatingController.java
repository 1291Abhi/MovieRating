package com.example.MovieRating.Controller;

import com.example.MovieRating.Model.Movies;
import com.example.MovieRating.Service.MovieRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class MovieRatingController {
    @Autowired
    MovieRatingService movieRatingService;
    @PostMapping("/api/v1/new-movie")
    public ResponseEntity addMovie(@RequestBody Movies movies){
        String result=movieRatingService.addMovie(movies);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }
    @GetMapping("/api/v1/longest-duration-movies")
    public ResponseEntity longestMovieDuration(){
        List<Object> moviesList=movieRatingService.longestMovieDuration();
        return new ResponseEntity(moviesList,HttpStatus.OK);
    }
    @GetMapping("/api/v1/top-rated-movies")
    public ResponseEntity topRatedMovie(){
        List<Object> moviesList=movieRatingService.topRatedMovie();
        return new ResponseEntity(moviesList,HttpStatus.OK);
    }
    @GetMapping("/api/v1/genre-movies-with-subtotals")
    public ResponseEntity genreMovieWithsubtotals(){
        List<Object> moviesList=movieRatingService.genreWithSubTotals();
        return new ResponseEntity(moviesList,HttpStatus.OK);
    }
    @PostMapping("/api/v1/update-runtime-minutes")
    public ResponseEntity updateRuntime(){
        movieRatingService.updateRuntime();
        return new ResponseEntity("Success",HttpStatus.OK);
    }


}
