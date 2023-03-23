package com.tiendaonline.tiendabackend.repository;

import com.tiendaonline.tiendabackend.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
}
