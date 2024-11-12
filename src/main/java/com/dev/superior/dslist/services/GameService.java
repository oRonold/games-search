package com.dev.superior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.superior.dslist.dto.GameDTO;
import com.dev.superior.dslist.dto.GameMinDTO;
import com.dev.superior.dslist.entities.Game;
import com.dev.superior.dslist.exception.ValidationException;
import com.dev.superior.dslist.projections.GameMinProjection;
import com.dev.superior.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		if(!gameRepository.existsById(id)) {
			throw new ValidationException("ID informed does not exists");
		}
		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long id){
		if(gameRepository.searchByList(id) == null) {
			throw new ValidationException("List ID does not exists");
		}
		List<GameMinProjection> result = gameRepository.searchByList(id);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
}
