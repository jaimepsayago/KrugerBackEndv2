package com.kruger.microservice.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.microservice.model.FootBallPlayer;
import com.kruger.microservice.model.service.FootballPlayerService;

@RestController
@RequestMapping("/footballplayer")
public class FootballPlayerController {
	
	@Autowired
	private FootballPlayerService service;
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json" )
	public Iterable<FootBallPlayer> findAll(){
		return service.findAll();
	}
	
	public FootBallPlayer save(@RequestBody FootBallPlayer entity) {
		return service.save(entity);
	}
	
	public FootBallPlayer edit(@PathVariable Integer id, @RequestBody FootBallPlayer entity) {
		return service.save(entity);
	}
	public void delete(@PathVariable Integer id) {
		service.deleteById(id);
	}
	
	public Optional<FootBallPlayer> findById(@PathVariable Integer id){
		return service.findById(id);
	}

}
