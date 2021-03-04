package controller;

import java.util.List;

import model.Recreation;

public class RecTester {
	public static void main(String[] args) {
		Recreation rec = new Recreation("Ice Skating");
		RecHelper rh = new RecHelper();
		rh.insertRecreation(rec);
		List<Recreation> allRecreations = rh.showAllRecreations();
		for(Recreation a: allRecreations) {
			System.out.println(a.toString());
		}
	}
}