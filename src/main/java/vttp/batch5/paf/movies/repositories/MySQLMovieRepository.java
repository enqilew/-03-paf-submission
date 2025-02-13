package vttp.batch5.paf.movies.repositories;

import java.util.List;

import vttp.batch5.paf.movies.models.Movie;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


@Repository
public class MySQLMovieRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void batchInsertMovies(List<Movie> movies) {
        String sql = "INSERT INTO imdb (imdb_id, vote_average, vote_count, release_date, revenue, budget, runtime) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE " +
                     "vote_average=VALUES(vote_average), vote_count=VALUES(vote_count), " +
                     "release_date=VALUES(release_date), revenue=VALUES(revenue), " +
                     "budget=VALUES(budget), runtime=VALUES(runtime)";

        jdbcTemplate.batchUpdate(sql, movies, 25, (ps, movie) -> {
            ps.setString(1, movie.getImdb_id());
            ps.setFloat(2, movie.getVote_average());
            ps.setInt(3, movie.getVote_count());
            ps.setString(4, movie.getRelease_date());
            ps.setDouble(5, movie.getRevenue());
            ps.setDouble(6, movie.getBudget());
            ps.setInt(7, movie.getRuntime());
        });

        System.out.println("Movies batch inserted into MySQL successfully.");
    }


  
  // TODO: Task 3


}
