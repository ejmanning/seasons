package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.SeasonModel;

public class SeasonHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("seasons");

	public void insertNewListDetails(SeasonModel s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}


	public List<SeasonModel> getSeasons() {
		EntityManager em = emfactory.createEntityManager();
		List<SeasonModel> allDetails = em.createQuery("SELECT s FROM SeasonModel s").getResultList();
		return allDetails;
	}

	
	public SeasonModel searchForSeasonsById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		SeasonModel found = em.find(SeasonModel.class, tempId);
		em.close();
		return found;
	}
	
	public void updateSeason(SeasonModel toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}

