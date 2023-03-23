package com.yukiii.sprphonebook.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhonebookUpdate {

	private String name;
	private String phoneNumber;
}
