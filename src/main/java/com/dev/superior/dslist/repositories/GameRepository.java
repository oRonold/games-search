package com.dev.superior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.superior.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
