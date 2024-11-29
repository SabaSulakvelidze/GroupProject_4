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
public class Support{

	@JsonProperty("text")
	private String text;

	@JsonProperty("url")
	private String url;
}