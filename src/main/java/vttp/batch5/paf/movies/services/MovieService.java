package vttp.batch5.paf.movies.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.batch5.paf.movies.models.Movie;
import vttp.batch5.paf.movies.models.MovieDocument;
import vttp.batch5.paf.movies.models.MovieEntity;
import vttp.batch5.paf.movies.models.ProlificDirector;
import vttp.batch5.paf.movies.repositories.MongoMovieCustomRepositoryImpl;
import vttp.batch5.paf.movies.repositories.MongoMovieRepository;
import vttp.batch5.paf.movies.repositories.MovieRepository;
import vttp.batch5.paf.movies.repositories.MySQLMovieCustomRepositoryImpl;
import vttp.batch5.paf.movies.repositories.MySQLMovieRepository;

@Service
public class MovieService {

  // TODO: Task 2

    @Autowired
    private MySQLMovieRepository mysqlMovieRepository;

    @Autowired
    private MySQLMovieCustomRepositoryImpl mysqlMovieCustomRepositoryImpl;

    public void batchInsertMovies(List<Movie> movies) {
        if (movies.isEmpty()) {
            System.out.println("No movies to insert.");
            return;
        }

        // Use the batch insert method
        mysqlMovieRepository.batchInsertMovies(movies);
    }

    public void saveSingleMovie(Movie movie) {
        // Convert to JPA entity
        MovieEntity entity = new MovieEntity();
        entity.setImdbId(movie.getImdb_id());
        entity.setVoteAverage(movie.getVote_average());
        entity.setVoteCount(movie.getVote_count());
        entity.setReleaseDate(movie.getRelease_date());
        entity.setRevenue(movie.getRevenue());
        entity.setBudget(movie.getBudget());
        entity.setRuntime(movie.getRuntime());

        // Save using JPA
        mysqlMovieCustomRepositoryImpl.saveMovie(entity);
    }

    @Autowired
    private MongoMovieRepository mongoMovieRepository;

    @Autowired
    private MongoMovieCustomRepositoryImpl mongoMovieCustomRepositoryImpl;

    public void batchInsertMoviesIntoMongo(List<Movie> movies) {
        if (movies.isEmpty()) {
            System.out.println("No movies to insert.");
            return;
        }
        mongoMovieRepository.batchInsertMovies(movies);
    }

    public void saveSingleMovieToMongo(Movie movie) {
        // Convert to MongoDB entity
        MovieDocument doc = new MovieDocument();
        doc.setImdbId(movie.getImdb_id());
        doc.setTitle(movie.getTitle());
        doc.setDirector(movie.getDirector());
        doc.setOverview(movie.getOverview());
        doc.setTagline(movie.getTagline());
        doc.setGenres(movie.getGenres());
        doc.setImdbRating(movie.getImdb_rating());
        doc.setImdbVotes(movie.getImdb_votes());

        // Save using JPA-like MongoDB repository
        mongoMovieCustomRepositoryImpl.saveMovie(doc);
    }
  

  // TODO: Task 3
  // You may change the signature of this method by passing any number of parameters
  // and returning any type
    @Autowired
    private MovieRepository movieRepository;

    public List<ProlificDirector> getProlificDirectors(int n) {
        List<Object[]> results = movieRepository.findTopDirectors(n);
        
        return results.stream()
                .map(row -> new ProlificDirector(
                        (String) row[0],      // Director Name
                        ((Number) row[1]).intValue(),  // Movies Count
                        ((Number) row[2]).doubleValue(), // Total Revenue
                        ((Number) row[3]).doubleValue()  // Total Budget
                ))
                .collect(Collectors.toList());
    }




  // TODO: Task 4
  // You may change the signature of this method by passing any number of parameters
  // and returning any type
  public void generatePDFReport() {

  }

}
