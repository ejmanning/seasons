package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Recreation;

public class RecreationHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("seasons");
	
	public void insertRecreation(Recreation r) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();
	}
	
	public List <Recreation> showAllRecreations() {
		EntityManager em = emfactory.createEntityManager();
		List <Recreation> allRecreations = em.createQuery("SELECT r FROM Recreation r").getResultList();
		return allRecreations;
	}
	
	public void deleteItem(Recreation toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Recreation> typedQuery = em.createQuery("SELECT r FROM Recreation r WHERE r.RECNAME = :selectedRecName", Recreation.class);
		
		//substitute the parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedRecName", toDelete.getRecname());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		Recreation result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Recreation> searchForRecreationByName(String recName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Recreation> typedQuery = em.createQuery("SELECT r FROM Recreation r WHERE r.RECNAME = :selectedRecName", Recreation.class);
		typedQuery.setParameter("selectedRecName", recName);
		
		List<Recreation> foundRecreations = typedQuery.getResultList();
		em.close();
		return foundRecreations;
	}
	
	public Recreation searchForRecreationById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Recreation found = em.find(Recreation.class, idToEdit);
		em.close();
		return found;
	}

	public void updateRecreation(Recreation toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
}