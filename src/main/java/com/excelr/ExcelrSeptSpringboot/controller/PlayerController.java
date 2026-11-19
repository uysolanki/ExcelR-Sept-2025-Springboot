package com.excelr.ExcelrSeptSpringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.ExcelrSeptSpringboot.entity.Player;
import com.excelr.ExcelrSeptSpringboot.exception.PlayerNotFoundException;
import com.excelr.ExcelrSeptSpringboot.service.PlayerService;

@RestController    //Component
public class PlayerController {

	@Autowired
	PlayerService playerService;
	
	@RequestMapping("/savePlayer")
	public String savePlayer()
	{
		Player p1=new Player(77,"Shubman", 20,800);
		try
		{
		playerService.savePlayer(p1);
		return "Player record inserted into DB";
		}
		catch(RuntimeException ex1)
		{
		return ex1.getMessage();	
		}
		
	}
	
	@RequestMapping("/savePlayer1")
	public Player savePlayer1()
	{
		Player p1=new Player(18,"Virat", 100,5000);
		return playerService.savePlayer1(p1);
		 
	}
	
	@RequestMapping("/savePlayer2")
	public String savePlayer2()
	{
		Player p1=new Player(33,"Hardik", 50,1200);
		try
		{
		playerService.savePlayer2(p1);
		return "Player record inserted into DB";
		}
		catch(PlayerNotFoundException ex1)
		{
		return ex1.getMessage();	
		}
		
	}
	
	@PostMapping("/savePlayer3")
	public String savePlayer3()
	{
		Player p1=new Player();
		p1.setMatchesPlayed(10);
		p1.setPlayerName("Vaibhav");
		p1.setRunsScored(500);
		try
		{
		playerService.savePlayer2(p1);
		return "Player record inserted into DB";
		}
		catch(PlayerNotFoundException ex1)
		{
		return ex1.getMessage();	
		}
		
	}
	
	@PostMapping("/savePlayerUsingRequestParam")
	public Player savePlayerUsingRequestParam(
			@RequestParam("a") int mp,
			@RequestParam("b") String pname,
			@RequestParam("c") int rs)
	{
		Player p1=new Player();
		p1.setMatchesPlayed(mp);
		p1.setPlayerName(pname);
		p1.setRunsScored(rs);
		Player player=playerService.savePlayer1(p1);
		return player;
	}
	
	@PostMapping("/savePlayerUsingRequestParamRE")
	public ResponseEntity<Player> savePlayerUsingRequestParamRE(
			@RequestParam("a") int mp,
			@RequestParam("b") String pname,
			@RequestParam("c") int rs)
	{
		Player p1=new Player();
		p1.setMatchesPlayed(mp);
		p1.setPlayerName(pname);
		p1.setRunsScored(rs);
		Player player=playerService.savePlayer1(p1);
		return new ResponseEntity<Player>( player, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/savePlayerUsingRequestParam1")
	public Player savePlayerUsingRequestParam1(
			@RequestParam("matchesPlayed") int matchesPlayed,
			@RequestParam("playerName") String playerName,
			@RequestParam("runsScored") int runsScored)
	{
		Player p1=new Player();
		p1.setMatchesPlayed(matchesPlayed);
		p1.setPlayerName(playerName);
		p1.setRunsScored(runsScored);
		Player player=playerService.savePlayer1(p1);
		return player;
	}
	
	@PostMapping("/savePlayerUsingRequestParam2")
	public Player savePlayerUsingRequestParam2(
			@RequestParam int matchesPlayed,
			@RequestParam String playerName,
			@RequestParam int runsScored)
	{
		Player p1=new Player();
		p1.setMatchesPlayed(matchesPlayed);
		p1.setPlayerName(playerName);
		p1.setRunsScored(runsScored);
		Player player=playerService.savePlayer1(p1);
		return player;
	}
	
	@PostMapping("/savePlayerUsingPathVariable/{a}/{b}/{c}")
	public Player savePlayerUsingPathVariable(
			@PathVariable("a") int matchesPlayed,
			@PathVariable("b") String playerName,
			@PathVariable("c") int runsScored)
	{
		Player p1=new Player();
		p1.setMatchesPlayed(matchesPlayed);
		p1.setPlayerName(playerName);
		p1.setRunsScored(runsScored);
		Player player=playerService.savePlayer1(p1);
		return player;
	}
	
	@PostMapping("/savePlayerUsingPathVariable1/{matchesPlayed}/{playerName}/{runsScored}")
	public Player savePlayerUsingPathVariable1(
			@PathVariable int matchesPlayed,
			@PathVariable String playerName,
			@PathVariable int runsScored)
	{
		Player p1=new Player();
		p1.setMatchesPlayed(matchesPlayed);
		p1.setPlayerName(playerName);
		p1.setRunsScored(runsScored);
		Player player=playerService.savePlayer1(p1);
		return player;
	}
	
	@PostMapping("/savePlayerUsingPathVariable1RE/{matchesPlayed}/{playerName}/{runsScored}")
	public ResponseEntity<Player> savePlayerUsingPathVariable1RE(
			@PathVariable int matchesPlayed,
			@PathVariable String playerName,
			@PathVariable int runsScored)
	{
		Player p1=new Player();
		p1.setMatchesPlayed(matchesPlayed);
		p1.setPlayerName(playerName);
		p1.setRunsScored(runsScored);
		Player player=playerService.savePlayer1(p1);
		return new ResponseEntity<Player>( player,HttpStatus.CREATED);
	}
	
	@PostMapping("/savePlayerUsingRequestBody")
	public Player savePlayerUsingRequestBody(@RequestBody Player p1)
	{
		Player player=playerService.savePlayer1(p1);
		return player;
	}
	
	
	@PostMapping("/savePlayerUsingRequestBodyRE")
	public ResponseEntity<Player> savePlayerUsingRequestBodyRE(@RequestBody Player p1)
	{
		//Player player=playerService.savePlayer1(p1);
		return new ResponseEntity<Player>(playerService.savePlayer1(p1),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllPlayers")
	public List<Player> getAllPlayers()
	{
		List<Player> players=playerService.getAllPlayers();
		return players;
	}
	
	@GetMapping("/getAllPlayersRE")
	public ResponseEntity<List<Player>> getAllPlayersRE()
	{
		List<Player> players=playerService.getAllPlayers();
		return new ResponseEntity<List<Player>>(players,HttpStatus.OK);
	}
	
	@GetMapping("/getSinglePlayer/{pid}")
	public ResponseEntity<?> getSinglePlayer(@PathVariable int pid)
	{
		try
		{
		Player player=playerService. getSinglePlayer(pid);
		return new ResponseEntity<Player>(player, HttpStatus.OK);
		}
		catch(PlayerNotFoundException ex)
		{
			return new ResponseEntity<String>( ex.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
}

//Operation      HttpMethod       Mapping           Postman
//Create         Post             @PostMapping
//Read           Get              @GetMapping
//Update         Put              @PutMapping
//Delete         Delete           @DeleteMapping

/*
{
    "playerName": "Frank",
    "matchesPlayed": 30,
    "runsScored": 500
} 
*/
