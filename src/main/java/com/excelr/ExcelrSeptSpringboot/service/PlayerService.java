package com.excelr.ExcelrSeptSpringboot.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.ExcelrSeptSpringboot.dto.PlayerDTO;
import com.excelr.ExcelrSeptSpringboot.entity.Player;
import com.excelr.ExcelrSeptSpringboot.exception.PlayerNotFoundException;
import com.excelr.ExcelrSeptSpringboot.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public void savePlayer(Player p1)throws RuntimeException {
		if(playerRepository.existsById(p1.getJerseyNumber()))
			throw new RuntimeException("Player Allready exists by Jersey No "+p1.getJerseyNumber());
		playerRepository.save(p1);
		
	}

	public Player savePlayer1(Player p1) 
	{
		return playerRepository.save(p1);
	}

	public void savePlayer2(Player p1)throws PlayerNotFoundException {
		playerRepository.save(p1);
		
	}

	

	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}

	public Player getSinglePlayer(int pid) throws PlayerNotFoundException {
		if(!playerRepository.existsById(pid))
			throw new PlayerNotFoundException("Player with Jersey No "+pid+ " does not exist");
		return playerRepository.findById(pid).get();
		
		
	}

	public void deleteSinglePlayer(int pid) {
		if(!playerRepository.existsById(pid))
			throw new PlayerNotFoundException("Player with Jersey No "+pid+ " does not exist");
		playerRepository.deleteById(pid);
		
	}

	public List<Player> saveMultiplePlayer(List<Player> players) {
		
		return playerRepository.saveAll(players);
	}

	public List<Player> getPlayersByCountryName(String country) {
		return playerRepository.findByCountry(country);
	}

	public List<Player> getPlayersByMatchesPlayed(int matches) {
		return playerRepository.findByMatchesPlayedGreaterThan(matches);
	}

	public Player updatePlayer(int playerId, Player newPlayerValues) {
		if(!playerRepository.existsById(playerId))
			throw new PlayerNotFoundException("Player with Jersey No "+playerId+ " does not exist");
		Player playerFromDB=getSinglePlayer(playerId);
		playerFromDB.setCountry(newPlayerValues.getCountry());
		playerFromDB.setMatchesPlayed(newPlayerValues.getMatchesPlayed());
		playerFromDB.setPlayerName(newPlayerValues.getPlayerName());
		playerFromDB.setRunsScored(newPlayerValues.getRunsScored());
		return playerRepository.save(playerFromDB);
	}

	public PlayerDTO savePlayerUsingDTO(PlayerDTO playerDto) {
		Player player=modelMapper.map(playerDto, Player.class);
		Player playerStoredInDB=playerRepository.save(player);
		PlayerDTO pDto=modelMapper.map(playerStoredInDB, PlayerDTO.class);
		return pDto;
	}

	public  List<PlayerDTO> saveMultiplePlayerUsingDTO(List<PlayerDTO> listPlayersDTO) {
		
		List<Player> listPlayers=listPlayersDTO.stream()
		.map(dto->modelMapper.map(dto, Player.class)).toList();
		
		List<Player> listSavedPlayers= saveMultiplePlayer(listPlayers);
		
		List<PlayerDTO> listPDTOs=listSavedPlayers.stream()
				.map(entity->modelMapper.map(entity, PlayerDTO.class)).toList();
		
		return  listPDTOs;
	}
}
