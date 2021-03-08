package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Season;

public class SeasonHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("seasons");

	public void insertSeason(Season s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}


	public List<Season> getSeasons() {
		EntityManager em = emfactory.createEntityManager();
		List<Season> allDetails = em.createQuery("SELECT s FROM Season s").getResultList();
		return allDetails;
	}
	
	public List <Season> showAllSeasons() {
		EntityManager em = emfactory.createEntityManager();
		List <Season> allSeasons = em.createQuery("SELECT s FROM Season s").getResultList();
		return allSeasons;
	}

	
	public Season searchForSeasonById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Season found = em.find(Season.class, tempId);
		em.close();
		return found;
	}
	
	public void updateSeason(Season toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}


	public Object showAllRecreations() {
		// TODO Auto-generated method stub
		return null;
	}

}

