package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addmovie(Movie movie){
        movieRepository.saveMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.saveDirector(director);
    }
    public void addMovieDirectorPair(String  director,String  movie){
        movieRepository.saveMovieDirectorPair(movie, director);
    }
    public Movie findmovie(String name){
        return movieRepository.findMovie(name);
    }
    public Director finddirector(String name){
        return movieRepository.findDirector(name);
    }
    public List<String> getmoviesbydirector(String  director){
        return movieRepository.findMoviesFromDirector(director);
    }
    public List<String>findall(){
        return movieRepository.findAllMovies();
    }
    public void deletebydirector(String  director){
        movieRepository.deleteDirector(director);
    }
    public void deleteAllDirectors(){
        movieRepository.deleteAllDirector();
    }
}
