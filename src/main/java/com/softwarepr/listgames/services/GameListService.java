package com.softwarepr.listgames.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softwarepr.listgames.dto.GameListDTO;
import com.softwarepr.listgames.entities.GameList;
import com.softwarepr.listgames.projections.GameMinProjection;
import com.softwarepr.listgames.repositories.GameListRepository;
import com.softwarepr.listgames.repositories.GameRepository;



//Criando a Classe aonde vai retornar os valores do Banco de Dados através de Consultas
/* Utilizando o metodo Stream, estou mapeando meu construtor para o construtor menor,
Assim trazendo só os dados que preciso */
@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;


    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional()
    public void move(Long listId, int sourceIndex, int destinationIndex){
        /*Metodo para mover os Jogos de Posição */
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex,obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i <= max; i++){
            gameListRepository.updateBeloningPosition(listId, list.get(i).getId(),i);
        }
        
    }

}
