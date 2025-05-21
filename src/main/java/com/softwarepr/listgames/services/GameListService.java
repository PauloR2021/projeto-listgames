package com.softwarepr.listgames.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softwarepr.listgames.dto.GameListDTO;
import com.softwarepr.listgames.entities.GameList;
import com.softwarepr.listgames.repositories.GameListRepository;



//Criando a Classe aonde vai retornar os valores do Banco de Dados através de Consultas
/* Utilizando o metodo Stream, estou mapeando meu construtor para o construtor menor,
Assim trazendo só os dados que preciso */
@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;

   

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

}
