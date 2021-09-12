package net.funsys.demo.repository;

import net.funsys.demo.model.FavoriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository
        extends JpaRepository<FavoriteEntity, Integer> {
}
