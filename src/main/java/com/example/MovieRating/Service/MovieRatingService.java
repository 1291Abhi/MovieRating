package com.example.MovieRating.Service;

import com.example.MovieRating.Model.Movies;
import com.example.MovieRating.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MovieRatingService {
    @Autowired
    MovieRepository movieRepository;
    public String addMovie(Movies movies) {
        Movies saveMovie=movieRepository.save(movies);
        if(saveMovie==null)
            return "Unable to save";
        return "Success";
    }

    public List<Object> longestMovieDuration() {
        return movieRepository.longestMovieDuration();
    }

    public List<Object> topRatedMovie() {
        return movieRepository.topRatedMovie();
    }

    public List<Object> genreWithSubTotals() {
        return movieRepository.genreWithSubTotals();
    }

    public void updateRuntime() {
        List<Movies> movieList=movieRepository.findAll();
        for(Movies movies:movieList){
            if(movies.getGenres().equals("Documentary"))
                movies.setRuntimeMinutes(movies.getRuntimeMinutes()+15);
            else if(movies.getGenres().equals("Animation"))
                movies.setRuntimeMinutes(movies.getRuntimeMinutes()+30);
            else
                movies.setRuntimeMinutes(movies.getRuntimeMinutes()+45);
            movieRepository.save(movies);
        }
    }
}
