package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the recreation database table.
 * 
 */
@Entity
@Table(name="recreation")
@NamedQuery(name="Recreation.findAll", query="SELECT r FROM Recreation r")
public class Recreation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;

	@Column(name="RECNAME")
	private String recname;

	//bi-directional many-to-many association to Season
	@ManyToMany
	@JoinTable(
		name="recbyseason"
		, joinColumns={
			@JoinColumn(name="RECID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="SEASONID")
			}
		)
	private List<Season> seasons;

	public Recreation() {
	}
	
	public Recreation(String recname) {
		this.recname = recname;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRecname() {
		return this.recname;
	}

	public void setRecname(String recname) {
		this.recname = recname;
	}

	public List<Season> getSeasons() {
		return this.seasons;
	}

	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}

}