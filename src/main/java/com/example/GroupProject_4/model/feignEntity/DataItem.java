package com.example.GroupProject_4.model.feignEntity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataItem{

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("avatar")
	private String avatar;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("email")
	private String email;
}