package vttp.batch5.paf.movies.models;

import jakarta.persistence.*;

@Entity
@Table(name = "imdb", uniqueConstraints = { @UniqueConstraint(columnNames = "imdb_id") })
public class MovieEntity {

    @Id
    @Column(name = "imdb_id", nullable = false)
    private String imdbId; // Primary key

    @Column(name = "vote_average", nullable = false)
    private float voteAverage;

    @Column(name = "vote_count", nullable = false)
    private int voteCount;

    @Column(name = "release_date", nullable = false)
    private String releaseDate;

    @Column(name = "revenue", nullable = false)
    private Double revenue = 0.0;

    @Column(name = "budget", nullable = false)
    private Double budget = 0.0;

    @Column(name = "runtime", nullable = false)
    private int runtime;

    // Getters and Setters
    public String getImdbId() { return imdbId; }
    public void setImdbId(String imdbId) { this.imdbId = imdbId; }

    public float getVoteAverage() { return voteAverage; }
    public void setVoteAverage(float voteAverage) { this.voteAverage = voteAverage; }

    public int getVoteCount() { return voteCount; }
    public void setVoteCount(int voteCount) { this.voteCount = voteCount; }

    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    public Double getRevenue() { return revenue; }
    public void setRevenue(Double revenue) { this.revenue = revenue; }

    public Double getBudget() { return budget; }
    public void setBudget(Double budget) { this.budget = budget; }

    public int getRuntime() { return runtime; }
    public void setRuntime(int runtime) { this.runtime = runtime; }
}





