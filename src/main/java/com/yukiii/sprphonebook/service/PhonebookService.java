package com.yukiii.sprphonebook.service;

import com.yukiii.sprphonebook.dto.request.PhonebookCreate;
import com.yukiii.sprphonebook.dto.request.PhonebookUpdate;
import com.yukiii.sprphonebook.dto.response.PhonebookGet;

import java.util.List;

public interface PhonebookService {

	void create(PhonebookCreate request);
	List<PhonebookGet> getAll();
	PhonebookGet getById(Long id);
	void updateById(Long id, PhonebookUpdate request);
	void deleteById(Long id);
}
