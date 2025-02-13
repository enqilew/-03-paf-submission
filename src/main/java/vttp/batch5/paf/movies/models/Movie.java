package vttp.batch5.paf.movies.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    private String title;
    private float vote_average;
    private int vote_count;
    private String status;
    private String release_date;
    private Double revenue;
    private int runtime;
    private Double budget;
    private String imdb_id;
    private String original_language;
    private String overview;
    private double popularity;
    private String tagline;
    private String genres;
    private String spoken_languages;
    private String casts;
    private String director;
    private double imdb_rating;
    private int imdb_votes;
    private String poster_path;

    // Default constructor required for Jackson
    public Movie() {}

    // Getters and Setters with Default Values

    public String getTitle() { return title != null ? title : ""; }
    public void setTitle(String title) { this.title = title; }

    public float getVote_average() { return vote_average; }
    public void setVote_average(float vote_average) { this.vote_average = vote_average; }

    public int getVote_count() { return vote_count; }
    public void setVote_count(int vote_count) { this.vote_count = vote_count; }

    public String getStatus() { return status != null ? status : ""; }
    public void setStatus(String status) { this.status = status; }

    public String getRelease_date() { return release_date != null ? release_date : ""; }
    public void setRelease_date(String release_date) { this.release_date = release_date; }

    public Double getRevenue() { return revenue != null ? revenue : 0.0; }
    public void setRevenue(Double revenue) { this.revenue = revenue; }

    public int getRuntime() { return runtime; }
    public void setRuntime(int runtime) { this.runtime = runtime; }

    public Double getBudget() { return budget != null ? budget : 0.0; }
    public void setBudget(Double budget) { this.budget = budget; }

    public String getImdb_id() { return imdb_id != null ? imdb_id : ""; }
    public void setImdb_id(String imdb_id) { this.imdb_id = imdb_id; }

    public String getOriginal_language() { return original_language != null ? original_language : ""; }
    public void setOriginal_language(String original_language) { this.original_language = original_language; }

    public String getOverview() { return overview != null ? overview : ""; }
    public void setOverview(String overview) { this.overview = overview; }

    public double getPopularity() { return popularity; }
    public void setPopularity(double popularity) { this.popularity = popularity; }

    public String getTagline() { return tagline != null ? tagline : ""; }
    public void setTagline(String tagline) { this.tagline = tagline; }

    public String getGenres() { return genres != null ? genres : ""; }
    public void setGenres(String genres) { this.genres = genres; }

    public String getSpoken_languages() { return spoken_languages != null ? spoken_languages : ""; }
    public void setSpoken_languages(String spoken_languages) { this.spoken_languages = spoken_languages; }

    public String getCasts() { return casts != null ? casts : ""; }
    public void setCasts(String casts) { this.casts = casts; }

    public String getDirector() { return director != null ? director : ""; }
    public void setDirector(String director) { this.director = director; }

    public double getImdb_rating() { return imdb_rating; }
    public void setImdb_rating(double imdb_rating) { this.imdb_rating = imdb_rating; }

    public int getImdb_votes() { return imdb_votes; }
    public void setImdb_votes(int imdb_votes) { this.imdb_votes = imdb_votes; }

    public String getPoster_path() { return poster_path != null ? poster_path : ""; }
    public void setPoster_path(String poster_path) { this.poster_path = poster_path; }
}


