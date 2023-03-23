package com.yukiii.sprphonebook.controller;

import com.yukiii.sprphonebook.dto.request.PhonebookCreate;
import com.yukiii.sprphonebook.dto.request.PhonebookUpdate;
import com.yukiii.sprphonebook.dto.response.PhonebookGet;
import com.yukiii.sprphonebook.service.PhonebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("phonebook")
public class PhonebookController {

	@Autowired
	private PhonebookService service;

	@PostMapping
	public void create(@RequestBody PhonebookCreate request) {
		service.create(request);
	}

	@GetMapping
	public List<PhonebookGet> getAll() {
		return service.getAll();
	}

	@GetMapping(value = "{id}")
	public PhonebookGet getById(@PathVariable("id") Long id) {
		return service.getById(id);
	}

	@PatchMapping(value = "{id}")
	public void updateById(
		@PathVariable("id") Long id,
		@RequestBody PhonebookUpdate request
	) {
		service.updateById(id, request);
	}

	@DeleteMapping(value = "{id}")
	public void deleteById(@PathVariable("id") Long id) {
		service.deleteById(id);
	}
}
