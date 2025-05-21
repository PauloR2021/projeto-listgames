package com.softwarepr.listgames.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.softwarepr.listgames.dto.GameListDTO;
import com.softwarepr.listgames.services.GameListService;


/* Criando o Caminho da API*/ 
/*Aonde vai Trazer os dados da Classe Sevices */

@RestController
@RequestMapping(value= "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;

    }

}
