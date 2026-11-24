package com.excelr.ExcelrSeptSpringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.excelr.ExcelrSeptSpringboot.dto.PlayerDTO;
import com.excelr.ExcelrSeptSpringboot.service.PlayerService;

@Controller
public class PlayerControllerFE {
	
	
	@Autowired
	PlayerService playerService;
	
	@RequestMapping("/rcb")
	public String rcb()
	{
		return "virat";
	}
	
	
	@GetMapping("/showAllPlayers")
	public String showAllPlayers(Model model)
	{
		List<PlayerDTO> players=playerService.getAllPlayersFE();
		model.addAttribute("players",players);
		return "show-all-players";
	}
	
	@RequestMapping("/deletePlayerFE/{pid}")
	public String deletePlayerFE(@PathVariable int pid)
	{
		playerService.deleteSinglePlayer(pid);
		return "redirect:/showAllPlayers";
	}
	
	
	@RequestMapping("/addPlayerForm")
	public String addPlayerForm(Model model)
	{
		PlayerDTO player=new PlayerDTO();
		model.addAttribute("player",player);
		return "add-player-form";
	}
	
	@PostMapping("/addSinglePlayerFE")
	public String addSinglePlayerFE(@ModelAttribute PlayerDTO playerDto)
	{
		playerService.savePlayerUsingDTO(playerDto);
		return "redirect:/showAllPlayers";
	}
	
	
	@RequestMapping("/updatePlayerFormFE/{pid}")
	public String updatePlayerFormFE(@PathVariable int pid,Model model)
	{
		PlayerDTO player= playerService.getSinglePlayerDTO(pid);
		model.addAttribute("player",player);
		return "update-player-form";
	}
	
	@PostMapping("/updatePlayerFE/{pid}")
	public String updatePlayerFE(@PathVariable int pid,@ModelAttribute PlayerDTO player)
	{
		playerService.updatePlayerDTO(pid,player);
		return "redirect:/showAllPlayers";
	}

}
