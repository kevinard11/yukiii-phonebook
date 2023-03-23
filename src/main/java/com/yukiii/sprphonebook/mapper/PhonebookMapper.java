package com.yukiii.sprphonebook.mapper;

import com.yukiii.sprphonebook.dto.request.PhonebookCreate;
import com.yukiii.sprphonebook.dto.response.PhonebookGet;
import com.yukiii.sprphonebook.entity.Phonebook;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PhonebookMapper {

	PhonebookGet entityToGetDto(Phonebook phonebook);
	Phonebook createDtoToEntity(PhonebookCreate request);
}
