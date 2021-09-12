package net.funsys.demo.controller;

import net.funsys.demo.exception.RecordNotFoundException;
import net.funsys.demo.model.FavoriteEntity;
import net.funsys.demo.model.MovieEntity;
import net.funsys.demo.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {
    @Autowired
    FavoriteService service;

    @GetMapping
    public ResponseEntity<List<MovieEntity>> findAll() {
        List<MovieEntity> movies = service.findAll();

        return new ResponseEntity<List<MovieEntity>>(movies, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FavoriteEntity> create(FavoriteEntity favorite)
            throws RecordNotFoundException {
        FavoriteEntity entity = service.create(favorite);
        return new ResponseEntity<FavoriteEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
}