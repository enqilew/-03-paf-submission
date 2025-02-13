package vttp.batch5.paf.movies.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vttp.batch5.paf.movies.models.MovieEntity;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, String> {

    @Query("SELECT m.director, COUNT(m), SUM(m.revenue), SUM(m.budget) " +
           "FROM MovieEntity m " +
           "WHERE m.director IS NOT NULL " +
           "GROUP BY m.director " +
           "ORDER BY COUNT(m) DESC " +
           "LIMIT :n")
    List<Object[]> findTopDirectors(@Param("n") int n);
}

