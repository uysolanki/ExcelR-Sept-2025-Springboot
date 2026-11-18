package com.excelr.ExcelrSeptSpringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("/savePlayer3")
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
}
