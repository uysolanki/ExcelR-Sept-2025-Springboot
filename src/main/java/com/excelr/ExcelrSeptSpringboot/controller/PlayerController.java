package com.excelr.ExcelrSeptSpringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.ExcelrSeptSpringboot.entity.Player;
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
}
