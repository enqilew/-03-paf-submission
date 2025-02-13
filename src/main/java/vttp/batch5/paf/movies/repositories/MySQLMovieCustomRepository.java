package vttp.batch5.paf.movies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vttp.batch5.paf.movies.models.MovieEntity;

@Repository
public interface MySQLMovieCustomRepository extends JpaRepository<MovieEntity, String> {
}

