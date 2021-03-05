package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.RecreationModel;

public class RecreationHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("seasons");
	
	public void insertRecreation(RecreationModel r) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();
	}
	
	public List <RecreationModel> showAllRecreations() {
		EntityManager em = emfactory.createEntityManager();
		List <RecreationModel> allRecreations = em.createQuery("SELECT r FROM RecreationModel r").getResultList();
		return allRecreations;
	}
	
	public void deleteItem(RecreationModel toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<RecreationModel> typedQuery = em.createQuery("SELECT r FROM RecreationModel r WHERE r.recName = :selectedRecName", RecreationModel.class);
		
		//substitute the parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedRecName", toDelete.getRecName());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		RecreationModel result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<RecreationModel> searchForRecreationByName(String recName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<RecreationModel> typedQuery = em.createQuery("SELECT r FROM RecreationModel r WHERE r.recName = :selectedRecName", RecreationModel.class);
		typedQuery.setParameter("selectedRecName", recName);
		
		List<RecreationModel> foundRecreations = typedQuery.getResultList();
		em.close();
		return foundRecreations;
	}
	
	public RecreationModel searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		RecreationModel found = em.find(RecreationModel.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(RecreationModel toEdit) {
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