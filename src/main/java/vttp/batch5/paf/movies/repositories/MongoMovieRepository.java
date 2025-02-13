package vttp.batch5.paf.movies.repositories;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

import vttp.batch5.paf.movies.models.Movie;
import vttp.batch5.paf.movies.models.MovieDocument;

@Repository
public class MongoMovieRepository {
    
    @Autowired
    private MongoTemplate mongoTemplate;

    // TODO: Task 2.3
    // You can add any number of parameters and return any type from the method
    // You can throw any checked exceptions from the method
    // Write the native Mongo query you implement in the method in the comments
    //
    //    native MongoDB query here
    //     db.imdb.insertMany([
    //   {
    //     "imdb_id": "tt1259521",
    //     "title": "The Cabin in the Woods",
    //     "director": "Drew Goddard",
    //     "overview": "A group of teens journey to a remote cabin in the woods where their fate is unknowingly controlled by technicians as part of a worldwide conspiracy where all horror movie clichés are revealed to be part of an elaborate sacrifice ritual.",
    //     "tagline": "You think you know the story.",
    //     "genres": "Horror, Mystery",
    //     "imdb_rating": 7,
    //     "imdb_votes": 465176
    //   },
    //   {
    //     "imdb_id": "tt1259522",
    //     "title": "The Cabin in the Seas",
    //     "director": "Drew Goddard",
    //     "overview": "A group of adults journey to a remote cabin in the seas where their fate is unknowingly controlled by technicians as part of a worldwide conspiracy where all horror movie clichés are revealed to be part of an elaborate sacrifice ritual.",
    //     "tagline": "You think you know the story.",
    //     "genres": "Horror, Mystery",
    //     "imdb_rating": 7,
    //     "imdb_votes": 465176
    //    }
    // ])

    //
     public void batchInsertMovies(List<Movie> movies) {
        if (movies.isEmpty()) {
            System.out.println("No movies to insert into MongoDB.");
            return;
        }

        // Convert Movie to MovieDocument for MongoDB
        List<MovieDocument> movieDocuments = movies.stream().map(movie -> {
            MovieDocument doc = new MovieDocument();
            doc.setImdbId(movie.getImdb_id());
            doc.setTitle(movie.getTitle());
            doc.setDirector(movie.getDirector());
            doc.setOverview(movie.getOverview());
            doc.setTagline(movie.getTagline());
            doc.setGenres(movie.getGenres());
            doc.setImdbRating(movie.getImdb_rating());
            doc.setImdbVotes(movie.getImdb_votes());
            return doc;
        }).collect(Collectors.toList());

        // Perform batch insert using insertAll()
        mongoTemplate.insert(movieDocuments);
        System.out.println("Movies batch inserted into MongoDB successfully.");
    }
 


 // TODO: Task 2.4
 // You can add any number of parameters and return any type from the method
 // You can throw any checked exceptions from the method
 // Write the native Mongo query you implement in the method in the comments
 //
 //    native MongoDB query here
 //
 public void logError() {

 }

 // TODO: Task 3
 // Write the native Mongo query you implement in the method in the comments
 //
 //    native MongoDB query here
 //


}
