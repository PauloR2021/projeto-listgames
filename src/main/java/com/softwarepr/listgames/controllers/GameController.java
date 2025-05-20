package com.softwarepr.listgames.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softwarepr.listgames.dto.GameMinDto;
import com.softwarepr.listgames.entities.Game;
import com.softwarepr.listgames.services.GameService;

/* Criando o Caminho da API*/ 
/*Aonde vai Trazer os dados da Classe Sevices */

@RestController
@RequestMapping(value= "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDto> findAll(){
        List<GameMinDto> result = gameService.findAll();
        return result;

    }

}
