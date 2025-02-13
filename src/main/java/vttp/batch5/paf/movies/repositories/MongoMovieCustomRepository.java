package vttp.batch5.paf.movies.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import vttp.batch5.paf.movies.models.MovieDocument;

@Repository
public interface MongoMovieCustomRepository extends MongoRepository<MovieDocument, String> {
}

