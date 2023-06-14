package com.example.MovieRating.Repository;

import com.example.MovieRating.Model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movies,String> {
    @Query(value = "Select tconst,primary_title,runtime_minutes,genres from movies order by runtime_minutes DESC limit 10",nativeQuery = true)
    List<Object> longestMovieDuration();
    @Query(value = "Select m.tconst, primary_title, genres, average_rating from movies m inner join ratings r on m.tconst=r.tconst  where average_rating>6.0 order by r.average_rating",nativeQuery = true)
    List<Object> topRatedMovie();
    @Query(value = "Select genres, primary_title,sum(r.num_votes) from movies m inner join ratings r on m.tconst=r.tconst group by genres",nativeQuery = true)
    List<Object> genreWithSubTotals();
}
