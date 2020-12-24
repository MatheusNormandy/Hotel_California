package com.hotelCalifonication.hotelCalifornication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelCalifonication.hotelCalifornication.model.HotelCalifornication;
import com.hotelCalifonication.hotelCalifornication.repository.HotelCalifonicationRepository;

@RestController
@RequestMapping({ "/hotel" })
public class HotelCalifornicationController {

	@Autowired
	private HotelCalifornication repository;

	@GetMapping
	public List findAll() {
		return repository.findAll();
	}

	@GetMapping (value = "{id}")
	public ResponseEntity findById(@PathVariable long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build));
	}

	@PostMapping
	public HotelCalifonicationRepository create(@RequestBody HotelCalifornication hotel) {
		return repository.save(hotel);
	}

	@PutMapping(value = "{id}")
	public ResponseEntity update(@PathVariable long id, @RequestBody HotelCalifornication hotel) {
		return repository.findById(id).map(record -> {
			record.setname(hotel.getname());
			record.setlocal(hotel.getlocal());
			record.setcapacidade(hotel.capacidade());
			HotelCalifornication update = repository.save(record);
			return ResponseEntity.ok().body(update);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping (path = {"/{id}"})
	public ResponseEntity<?> delete (@PathVariable long id){
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			
		 return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
		}
}