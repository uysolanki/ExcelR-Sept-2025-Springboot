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
	private Integer jerseyNumber;
	
	@Column(nullable = false, length = 100)
	private String playerName;
	
	@Column(nullable = false)
	private int matchesPlayed;
	
	@Column(nullable = false)
	private int runsScored;
	
	@Column(nullable = false)
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
