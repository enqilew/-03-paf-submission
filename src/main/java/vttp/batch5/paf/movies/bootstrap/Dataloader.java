package vttp.batch5.paf.movies.bootstrap;

import com.fasterxml.jackson.databind.ObjectMapper;

import vttp.batch5.paf.movies.models.Movie;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Dataloader {

    private static final String DEFAULT_ZIP_FILE = "data/movies_post_2010.zip";
    private static final int MIN_RELEASE_YEAR = 2018;

    public static void main(String[] args) {
        String zipFilePath = getZipFilePath(args);

        List<Movie> filteredMovies = processMoviesFromZip(zipFilePath);
        if (filteredMovies != null && !filteredMovies.isEmpty()) {
            System.out.println("Filtered Movies Released After 2018:");
            filteredMovies.forEach(movie -> System.out.println(" - " + movie.getTitle()));
        } else {
            System.out.println("No movies found matching the criteria.");
        }
    }

    private static String getZipFilePath(String[] args) {
        if (args.length > 0) {
            return args[0];
        } else {
            System.out.println("No file path provided. Using default: " + DEFAULT_ZIP_FILE);
            return DEFAULT_ZIP_FILE;
        }
    }

    public static List<Movie> processMoviesFromZip(String zipFilePath) {
        List<Movie> filteredMovies = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try (ZipFile zipFile = new ZipFile(zipFilePath)) {
            Enumeration<ZipArchiveEntry> entries = zipFile.getEntries();

            while (entries.hasMoreElements()) {
                ZipArchiveEntry entry = entries.nextElement();

                if (!entry.isDirectory() && entry.getName().endsWith(".json")) {
                    try (InputStream stream = zipFile.getInputStream(entry)) {
                        // Deserialize JSON into Movie object
                        Movie movie = objectMapper.readValue(stream, Movie.class);
                        if (isValidMovie(movie)) {
                            filteredMovies.add(movie);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error processing ZIP file: " + e.getMessage());
        }
        return filteredMovies;
    }

    private static boolean isValidMovie(Movie movie) {
        if (movie.getRelease_date() != null && movie.getRelease_date().length() >= 4) {
            try {
                int releaseYear = Integer.parseInt(movie.getRelease_date().substring(0, 4));
                return releaseYear >= MIN_RELEASE_YEAR;
            } catch (NumberFormatException e) {
                System.err.println("Invalid release date format for movie: " + movie.getTitle());
            }
        }
        return false;
    }
}

