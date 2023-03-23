package com.yukiii.sprphonebook.service.impl;

import com.yukiii.sprphonebook.dto.request.PhonebookCreate;
import com.yukiii.sprphonebook.dto.request.PhonebookUpdate;
import com.yukiii.sprphonebook.dto.response.PhonebookGet;
import com.yukiii.sprphonebook.exception.InvalidParameterRequestException;
import com.yukiii.sprphonebook.exception.PhoneNumberAlreadyExistException;
import com.yukiii.sprphonebook.exception.PhonebookNotFoundException;
import com.yukiii.sprphonebook.mapper.PhonebookMapper;
import com.yukiii.sprphonebook.repo.PhonebookRepository;
import com.yukiii.sprphonebook.service.PhonebookService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PhonebookServiceImpl implements PhonebookService {

	@Autowired
	private PhonebookRepository repository;

	@Autowired
	private PhonebookMapper mapper;

	@Override
	public void create(PhonebookCreate request) {
		if (request == null) throw new InvalidParameterRequestException("Request can't be empty");
		if (StringUtils.isEmpty(request.getName())) throw new InvalidParameterRequestException("Name can't be empty");
		if (StringUtils.isEmpty(request.getPhoneNumber())) throw new InvalidParameterRequestException("Phone number can't be empty");

		repository.findByPhoneNumber(request.getPhoneNumber()).ifPresent(pb -> {throw new PhoneNumberAlreadyExistException();});

		var phoneBook = mapper.createDtoToEntity(request);
		phoneBook.setDeleted(false);

		repository.save(phoneBook);
	}

	@Override
	public List<PhonebookGet> getAll() {
		var phoneBooks = repository.findAll();

		return phoneBooks
			.stream()
			.map(mapper::entityToGetDto)
			.collect(Collectors.toList());
	}

	@Override
	public PhonebookGet getById(Long id) {
		var phoneBook = repository.findById(id).orElseThrow(PhonebookNotFoundException::new);
		return mapper.entityToGetDto(phoneBook);
	}

	@Override
	public void updateById(Long id, PhonebookUpdate request) {
		var phoneBook = repository.findById(id).orElseThrow(PhonebookNotFoundException::new);

		if (request == null) throw new InvalidParameterRequestException("Request can't be empty");

		if (StringUtils.isNotEmpty(request.getName())) phoneBook.setName(request.getName());
		if (StringUtils.isNotEmpty(request.getPhoneNumber())) phoneBook.setPhoneNumber(request.getPhoneNumber());

		repository.save(phoneBook);
	}

	@Override
	public void deleteById(Long id) {
		var phoneBook = repository.findById(id).orElseThrow(PhonebookNotFoundException::new);
		repository.delete(phoneBook);
	}
}
