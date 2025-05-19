package com.softwarepr.listgames.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softwarepr.listgames.entities.Game;

public interface GameRepository extends JpaRepository<Game,Long>{

}
