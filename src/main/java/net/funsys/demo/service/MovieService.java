package net.funsys.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import net.funsys.demo.exception.RecordNotFoundException;
import net.funsys.demo.model.MovieEntity;
import net.funsys.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository repository;

    public List<MovieEntity> findAll() {
        List<MovieEntity> movies = repository.findAll();

        if (movies.size() > 0) {
            return movies;
        } else {
            return new ArrayList<MovieEntity>();
        }
    }

    public MovieEntity findById(Integer id) throws RecordNotFoundException {
        Optional<MovieEntity> movie = repository.findById(id);

        if (movie.isPresent()) {
            return movie.get();
        } else {
            throw new RecordNotFoundException("No movie record is found by this id");
        }
    }

    public List<MovieEntity> findByNameLike(String name) throws RecordNotFoundException {
        List<MovieEntity> movies = repository.findByNameLike("%" + name + "%");

        if (movies.size() > 0) {
            return movies;
        } else {
            return new ArrayList<MovieEntity>();
        }
    }

    public List<MovieEntity> findByCountry(String country) throws RecordNotFoundException {
        List<MovieEntity> movies = repository.findByCountry(country);

        if (movies.size() > 0) {
            return movies;
        } else {
            return new ArrayList<MovieEntity>();
        }
    }

    public MovieEntity create(MovieEntity entity) throws RecordNotFoundException {
        entity = repository.save(entity);

        return entity;

    }

    public MovieEntity update(MovieEntity entity) throws RecordNotFoundException {
        Optional<MovieEntity> movie = repository.findById(entity.getId());

        if (movie.isPresent()) {
            MovieEntity newEntity = movie.get();
            newEntity.setName(entity.getName());
            newEntity.setDirector(entity.getDirector());
            newEntity.setLang(entity.getLang());
            newEntity.setCountry(entity.getCountry());
            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            throw new RecordNotFoundException("No movie record is found by this id");
        }
    }

    public void deleteById(Integer id) throws RecordNotFoundException {
        Optional<MovieEntity> movie = repository.findById(id);

        if (movie.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No movie record is found by this id");
        }
    }
}