package com.ust.admin.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.admin.model.Menu;
import com.ust.admin.model.Restauranttry;
import com.ust.admin.repo.MRepo;
import com.ust.admin.repo.RestRepo;

@CrossOrigin
@RestController
@RequestMapping("/rest")
public class Rcontroller {

	
	@Autowired
	RestRepo repo;
	
	@Autowired
	MRepo meanurepo;
	
	@CrossOrigin
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Restauranttry rest){
		Restauranttry rest1=repo.save(rest);
		
		return ResponseEntity.ok().body(rest1);
	}
	
	@CrossOrigin
	@GetMapping("/all")
	public List<Restauranttry> getall(){
		
		
		return repo.findAll();
		}
	
	
	
	
	@GetMapping("/allm")
	public List<Menu> getallm(){
		
		
		return meanurepo.findAll();
		}
	
	@GetMapping("/allm/{rest_id}")
	public List<Menu> getbymeanid(@PathVariable Long rest_id){
		
//		Menu menulist=meanurepo.findById(rest_id).orElse(null);
		Restauranttry rest=repo.findById(rest_id).orElse(null);
		
		return rest.getMenu();
		}
	
	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		repo.deleteById(id);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update
	(@PathVariable Long id,@RequestBody Restauranttry rest ){
		
		Restauranttry temp=null;
			Optional<Restauranttry> op1=repo.findById(id);
			if(op1.isPresent()) {
			temp=op1.get();
			temp.setRestName(rest.getRestName());
			temp.setRestAddress(rest.getRestAddress());
			temp.setRestContact(rest.getRestContact());
			temp.setRestPic(rest.getRestPic());
			Restauranttry rest3=repo.save(temp);
			return ResponseEntity.ok().body(rest3);
			}
			else
			{
				return null;
			}
	}
	
	
	@GetMapping("/getbyid/{id}")
	public Restauranttry getbyid(@PathVariable Long id ){
		
		
		Optional<Restauranttry> op=repo.findById(id);
		if(op.isPresent()) {
		   
			return op.get();
		}
		else 
	     	return	null;	
	}
}
