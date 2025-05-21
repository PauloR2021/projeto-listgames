package com.softwarepr.listgames.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.softwarepr.listgames.dto.GameListDTO;
import com.softwarepr.listgames.dto.GameMinDto;
import com.softwarepr.listgames.services.GameListService;
import com.softwarepr.listgames.services.GameService;


/* Criando o Caminho da API*/ 
/*Aonde vai Trazer os dados da Classe Sevices */

@RestController
@RequestMapping(value= "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;

    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDto> findByList(@PathVariable Long listId){
        List<GameMinDto> result = gameService.findBylist(listId);
        return result;
    }

}
