package controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.RecBySeasonModel;

public class RecBySeasonHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("seasons");
}
