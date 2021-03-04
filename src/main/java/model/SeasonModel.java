package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="season")
public class SeasonModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="SEASONNAME")
	private String seasonName;
	
	@Column(name="SEASONSTARTDATE")
	private LocalDate seasonStartDate;
	
	public SeasonModel() {
		super();
	}
	
	public SeasonModel(String seasonName, LocalDate seasonStartDate) {
		super();
		this.seasonName = seasonName;
		this.seasonStartDate = seasonStartDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeasonName() {
		return seasonName;
	}

	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}

	public LocalDate getSeasonStartDate() {
		return seasonStartDate;
	}

	public void setSeasonStartDate(LocalDate seasonStartDate) {
		this.seasonStartDate = seasonStartDate;
	}
}
