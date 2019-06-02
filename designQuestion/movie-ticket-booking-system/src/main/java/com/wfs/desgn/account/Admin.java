package com.wfs.desgn.account;

import com.wfs.desgn.cinema.Cinema;
import com.wfs.desgn.constant.AccountStatus;
import com.wfs.desgn.movie.Movie;
import com.wfs.desgn.movie.Show;
import com.wfs.desgn.service.MovieService;
import com.wfs.desgn.service.ShowService;

import java.util.List;

public class Admin extends Person {

    private MovieService movieService;
    private ShowService showService;

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    public boolean addMovie(Movie movie , List<Cinema> cinema) {
        return movieService.addMovie(movie,cinema);
    }

    public boolean addShow(Cinema cinema ,Show show) {
        return showService.addShow(cinema, show);
    }

    public boolean blockUser(Customer customer) {
        customer.setStatus(AccountStatus.BLOCKED);
        return true;
    }

    @Override
    public boolean resetPassword() {
        return false;
    }

}