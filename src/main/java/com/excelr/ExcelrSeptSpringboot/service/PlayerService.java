package com.excelr.ExcelrSeptSpringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.ExcelrSeptSpringboot.entity.Player;
import com.excelr.ExcelrSeptSpringboot.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepository;
	
	public void savePlayer(Player p1)throws RuntimeException {
		if(playerRepository.existsById(p1.getJerseyNumber()))
			throw new RuntimeException("Player Allready exists by Jersey No "+p1.getJerseyNumber());
		playerRepository.save(p1);
		
	}

	public Player savePlayer1(Player p1) 
	{

		return playerRepository.save(p1);
	}

}
