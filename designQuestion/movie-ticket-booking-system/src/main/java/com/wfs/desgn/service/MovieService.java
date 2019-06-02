package com.wfs.desgn.service;

import com.wfs.desgn.cinema.Cinema;
import com.wfs.desgn.movie.Movie;

import java.util.List;

public interface MovieService {

    public boolean addMovie(Movie movie , List<Cinema> cinema);



}
