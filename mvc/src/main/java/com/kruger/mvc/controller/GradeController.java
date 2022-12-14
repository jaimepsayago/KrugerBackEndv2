package com.kruger.mvc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kruger.mvc.model.Grade;
import com.kruger.mvc.service.GradeService;

@Controller
@RequestMapping("/api")
public class GradeController {
	
	//instanciar un objeto de tipo service
	GradeService gradeService = new GradeService();
	
	//form
	@GetMapping("/")
	public String getForm(Model model, @RequestParam(required = false) String id) {
		model.addAttribute("grade", gradeService.getGradeById(id));
		return "/form";
	}
	
	//manejar la informacion de form y presentarlo en otra vista
	@PostMapping("/handleSubmit")
	public String submitForm(@Valid Grade grade, BindingResult result) {
		if (result.hasErrors()) return "form";
		gradeService.submitGrade(grade);
		return "redirect:/api/grades";
	}
	
	//vista donde se muestra la informacion de form
	@GetMapping("/grades")
	public String getGrades(Model model) {
		model.addAttribute("grades", gradeService.getGrades());
		return "/grades";
	}
}
