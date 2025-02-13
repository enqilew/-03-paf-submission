package vttp.batch5.paf.movies.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import vttp.batch5.paf.movies.models.MovieDocument;

@Repository
public class MongoMovieCustomRepositoryImpl {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoMovieCustomRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void saveMovie(MovieDocument movie) {
        mongoTemplate.save(movie);
    }
}

