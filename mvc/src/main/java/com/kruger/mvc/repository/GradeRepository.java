package com.kruger.mvc.repository;

import java.util.ArrayList;
import java.util.List;

import com.kruger.mvc.model.Grade;

public class GradeRepository {
	
	private List<Grade> studentGrade = new ArrayList<>();
	
	public Grade getGrade(int index){
		return studentGrade.get(index);
		
	}
	
	public void addGrade(Grade grade) {
		studentGrade.add(grade);
	}
	
	public void updateGrade(Grade grade, int index) {
		studentGrade.set(index, grade);
	}
	

	public List<Grade> getGrades(){
		return studentGrade;
	}
}
