package com.excelr.ExcelrSeptSpringboot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class PlayerDTO {

	@NotBlank
	@Size(min = 5, max = 100, message = "Player name must be between 5 and 100 characters")
	private String playerName;
	
	@Min(value = 1, message = "Matches Played must be at least 1")
	private int matchesPlayed;
	
	@Min(value = 1, message = "Matches Played must be at least 1")
	private int runsScored;
	
	@NotBlank
	@Size(min = 2, max = 30, message = "Country name must be between 5 and 30 characters")
	private String country;

}
