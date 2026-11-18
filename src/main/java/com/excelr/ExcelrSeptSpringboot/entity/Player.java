package com.excelr.ExcelrSeptSpringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Player {
	
	@Id
	private Integer jerseyNumber;
	private String playerName;
	private int matchesPlayed;
	private int runsScored;
}
