package vttp.batch5.paf.movies.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vttp.batch5.paf.movies.models.MovieEntity;

@Repository
public class MySQLMovieCustomRepositoryImpl {

    @Autowired
    private MySQLMovieCustomRepository repository;

    public void saveMovie(MovieEntity movie) {
        repository.save(movie);
    }
}

