package vttp.batch5.paf.movies.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp.batch5.paf.movies.models.ProlificDirector;
import vttp.batch5.paf.movies.services.MovieService;

@RestController
@RequestMapping("/api/directors")
public class MainController {

  // TODO: Task 3

    @Autowired
    private MovieService movieService;

    @GetMapping("/top/{n}")
    public List<ProlificDirector> getTopDirectors(@PathVariable int n) {
        return movieService.getProlificDirectors(n);
    }

   

  
  // TODO: Task 4


}
