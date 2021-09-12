package net.funsys.demo.controller;

import net.funsys.demo.exception.RecordNotFoundException;
import net.funsys.demo.model.MovieEntity;
import net.funsys.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService service;

    @GetMapping
    public ResponseEntity<List<MovieEntity>> findAll() {
        List<MovieEntity> list = service.findAll();

        return new ResponseEntity<List<MovieEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieEntity> findById(@PathVariable("id") Integer id)
            throws RecordNotFoundException {
        MovieEntity entity = service.findById(id);

        return new ResponseEntity<MovieEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(params = "search=by-name-like")
    public ResponseEntity<List<MovieEntity>> findByNameLike(@RequestParam("name") String name)
            throws RecordNotFoundException {
        List<MovieEntity> entities = service.findByNameLike(name);

        return new ResponseEntity<List<MovieEntity>>(entities, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(params = "search=by-country")
    public ResponseEntity<List<MovieEntity>> findByCountry(@RequestParam("country") String country)
            throws RecordNotFoundException {
        List<MovieEntity> entities = service.findByCountry(country);

        return new ResponseEntity<List<MovieEntity>>(entities, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MovieEntity> create(MovieEntity movie)
            throws RecordNotFoundException {
        MovieEntity entity = service.create(movie);
        return new ResponseEntity<MovieEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieEntity> update(MovieEntity movie)
            throws RecordNotFoundException {
        MovieEntity entity = service.update(movie);
        return new ResponseEntity<MovieEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id)
            throws RecordNotFoundException {
        service.deleteById(id);
    }
}