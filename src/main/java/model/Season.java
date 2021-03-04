package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the season database table.
 * 
 */
@Entity
@Table(name="season")
@NamedQuery(name="Season.findAll", query="SELECT s FROM Season s")
public class Season implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;

	@Column(name="SEASONNAME")
	private String seasonname;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="SEASONSTARTDATE")
	private Date seasonstartdate;

	//bi-directional many-to-many association to Recreation
	@ManyToMany(mappedBy="seasons")
	private List<Recreation> recreations;

	public Season() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeasonname() {
		return this.seasonname;
	}

	public void setSeasonname(String seasonname) {
		this.seasonname = seasonname;
	}

	public Date getSeasonstartdate() {
		return this.seasonstartdate;
	}

	public void setSeasonstartdate(Date seasonstartdate) {
		this.seasonstartdate = seasonstartdate;
	}

	public List<Recreation> getRecreations() {
		return this.recreations;
	}

	public void setRecreations(List<Recreation> recreations) {
		this.recreations = recreations;
	}

}