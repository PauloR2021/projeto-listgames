package com.softwarepr.listgames.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.softwarepr.listgames.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList,Long>{

   
}
