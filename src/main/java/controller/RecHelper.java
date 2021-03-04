package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Recreation;

public class RecHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("seasons");
	public void insertRecreation(Recreation s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Recreation> showAllRecreations() {
		EntityManager em = emfactory.createEntityManager();
		List<Recreation> allRecreations = em.createQuery("SELECT r FROM Recreation r").getResultList();
		return allRecreations;
	}
}