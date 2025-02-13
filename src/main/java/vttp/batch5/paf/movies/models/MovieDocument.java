package vttp.batch5.paf.movies.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "imdb")
public class MovieDocument {

    @Id
    private String imdbId;
    private String title;
    private String director;
    private String overview;
    private String tagline;
    private String genres;
    private double imdbRating;
    private int imdbVotes;

    // Getters and Setters
    public String getImdbId() { return imdbId; }
    public void setImdbId(String imdbId) { this.imdbId = imdbId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public String getOverview() { return overview; }
    public void setOverview(String overview) { this.overview = overview; }

    public String getTagline() { return tagline; }
    public void setTagline(String tagline) { this.tagline = tagline; }

    public String getGenres() { return genres; }
    public void setGenres(String genres) { this.genres = genres; }

    public double getImdbRating() { return imdbRating; }
    public void setImdbRating(double imdbRating) { this.imdbRating = imdbRating; }

    public int getImdbVotes() { return imdbVotes; }
    public void setImdbVotes(int imdbVotes) { this.imdbVotes = imdbVotes; }
}

