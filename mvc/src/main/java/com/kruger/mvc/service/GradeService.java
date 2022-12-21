package com.kruger.mvc.service;

import java.util.List;

import com.kruger.mvc.Constants;
import com.kruger.mvc.model.Grade;
import com.kruger.mvc.repository.GradeRepository;

public class GradeService {
	
	GradeRepository gradeRepository = new GradeRepository();
	
	public Grade getGrade(int index) {
		return gradeRepository.getGrade(index);
	}
	
	public void addGrade(Grade grade) {
		gradeRepository.addGrade(grade);
	}
	
	public void updateGrade(Grade grade, int index) {
		gradeRepository.updateGrade(grade, index);
	}

	public List<Grade> getGrades(){
		return gradeRepository.getGrades();
	}
	
	
	// obtener el index
	public int getGradeIndex(String id) {
		for(int i = 0; i<getGrades().size(); i++){
			if (getGrade(i).getId().equals(id)) return i;
		}
		return Constants.NOT_FOUND;
	}
	
	// buscar id
	
	public Grade getGradeById(String id) {
		
		int index = getGradeIndex(id);
		
		return index == Constants.NOT_FOUND ? new Grade() : getGrade(index);
	}
	
	//enviar todo el objeto
	public void submitGrade(Grade grade) {
		int index = getGradeIndex(grade.getId());
		if (index == Constants.NOT_FOUND) {
			addGrade(grade);
		}else {
			updateGrade(grade, index);
		}
			
	}
	
}
