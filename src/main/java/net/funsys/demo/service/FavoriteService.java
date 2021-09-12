package net.funsys.demo.service;

import net.funsys.demo.exception.RecordNotFoundException;
import net.funsys.demo.model.FavoriteEntity;
import net.funsys.demo.model.MovieEntity;
import net.funsys.demo.repository.FavoriteRepository;
import net.funsys.demo.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {

    @Autowired
    FavoriteRepository favoriteRepository;

    @Autowired
    MovieRepository movieRepository;

    public List<MovieEntity> findAll() {
        List<FavoriteEntity> favorites = favoriteRepository.findAll();

        if (favorites.size() > 0) {
            List<MovieEntity> movies = new ArrayList<MovieEntity>(8);
            favorites.forEach(favorite->{
                Optional<MovieEntity> movie = movieRepository.findById(favorite.getId());

                if (movie.isPresent()) {
                    movies.add(movie.get());
                }

            });

            return movies;
        } else {
            return new ArrayList<MovieEntity>();
        }
    }

    public FavoriteEntity create(FavoriteEntity entity) throws RecordNotFoundException {

        Optional<FavoriteEntity> favorite = favoriteRepository.findById(entity.getId());

        if (favorite.isPresent()) {
            throw new RecordNotFoundException("This movie is already added to favorite");
        } else {
            entity = favoriteRepository.save(entity);

            return entity;
        }
    }

}