package controller;

import java.util.List;

import model.Recreation;

public class RecTester {
	public static void main(String[] args) {
		Recreation rec = new Recreation("Ice Skating");
		RecreationHelper rh = new RecreationHelper();
		rh.insertRecreation(rec);
		List<Recreation> allRecreations = rh.showAllRecreations();
		for(Recreation a: allRecreations) {
			System.out.println(a.toString());
		}
	}
}