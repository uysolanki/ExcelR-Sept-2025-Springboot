package com.excelr.ExcelrSeptSpringboot.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
//@Table(name = "IPLPlayer")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "jno")
	private Integer jerseyNumber;
	private String playerName;
	private int matchesPlayed;
	private int runsScored;
	private String country;
	
	
	private LocalDateTime createdAt;
	
    private LocalDateTime modifiedAt;
	
    
	@PrePersist
	protected void atCreation()
	{
		LocalDateTime now=LocalDateTime.now();
		this.createdAt=now;
		this.modifiedAt=now;
	}
	
	@PreUpdate
	protected void atUpdation()
	{
		this.modifiedAt=LocalDateTime.now();
	}

	public Player(int pid,String playerName, int matchesPlayed, int runsScored, String country) {
		this.jerseyNumber=pid;
		this.playerName = playerName;
		this.matchesPlayed = matchesPlayed;
		this.runsScored = runsScored;
		this.country = country;
	}

}
