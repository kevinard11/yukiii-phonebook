package com.yukiii.sprphonebook.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhonebookGet {

	private Long id;
	private String name;
	private String phoneNumber;
}
