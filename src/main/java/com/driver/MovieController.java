package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MovieController {
  @Autowired
    MovieService movieService;
  @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addmovie(@RequestBody Movie movie){
       movieService.addmovie(movie);
      return new ResponseEntity<>("movie added successfully", HttpStatus.CREATED);
  }
  @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector (@RequestBody Director director){
      movieService.addDirector(director);
      return new ResponseEntity<>("Director added Successfully", HttpStatus.CREATED);
  }
  @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String>addMovieDirectorPair(@RequestParam  String director, @RequestParam  String movie){
      movieService.addMovieDirectorPair(director, movie);
      return new ResponseEntity<>("Movie and Director Added Successfully", HttpStatus.ACCEPTED);
  }
  @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName (@PathVariable String name){
    Movie movie = movieService.findmovie(name);
      return new ResponseEntity<>(movie,HttpStatus.FOUND);
  }
  @GetMapping("/movies/get-director-by-name/{name}")
  public ResponseEntity<Director> getDirectorByName (@PathVariable String name){
    Director director = movieService.finddirector(name);
    return new ResponseEntity<>(director,HttpStatus.FOUND);
  }
  @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName (@PathVariable String director){
      List<String> list = movieService.getmoviesbydirector(director);
      return new ResponseEntity<>(list, HttpStatus.FOUND);
    }
  @GetMapping("/movies/get-all-movies")
  public ResponseEntity<List<String>> findAllMovies (){
    List<String> list = movieService.findall();
    return new ResponseEntity<>(list, HttpStatus.FOUND);
  }
  @DeleteMapping("/movies/delete-director-by-name")
  public ResponseEntity<String>deleteDirectorByName(@RequestParam String  director){
    movieService.deletebydirector(director);
    return new ResponseEntity<>(director + " removed successfully", HttpStatus.CREATED);
  }
  @DeleteMapping("/delete-all-directors")
  public ResponseEntity<String> deleteAllDirectors(){
    movieService.deleteAllDirectors();
    return new ResponseEntity<>("All directors deleted successfully", HttpStatus.CREATED);
  }


}
