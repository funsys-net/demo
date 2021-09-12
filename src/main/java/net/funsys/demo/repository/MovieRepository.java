package net.funsys.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.funsys.demo.model.MovieEntity;

import java.util.List;

@Repository
public interface MovieRepository
        extends JpaRepository<MovieEntity, Integer> {
    List<MovieEntity> findByNameLike(String name);

    List<MovieEntity> findByDirector(String director);

    List<MovieEntity> findByCountry(String country);
}
