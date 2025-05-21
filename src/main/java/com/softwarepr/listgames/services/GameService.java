package com.softwarepr.listgames.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softwarepr.listgames.dto.GameDTO;
import com.softwarepr.listgames.dto.GameMinDto;
import com.softwarepr.listgames.entities.Game;
import com.softwarepr.listgames.projections.GameMinProjection;
import com.softwarepr.listgames.repositories.GameRepository;




//Criando a Classe aonde vai retornar os valores do Banco de Dados através de Consultas
/* Utilizando o metodo Stream, estou mapeando meu construtor para o construtor menor,
Assim trazendo só os dados que preciso */
@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDto::new).toList();
    }

    
    @Transactional(readOnly = true)
    public List<GameMinDto> findBylist(Long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(GameMinDto::new).toList();
    }

}
