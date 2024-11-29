package com.example.GroupProject_4.model.feignEntity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReqresUsersResponse {

	@JsonProperty("per_page")
	private Integer perPage;

	@JsonProperty("total")
	private Integer total;

	@JsonProperty("data")
	private List<DataItem> data;

	@JsonProperty("page")
	private Integer page;

	@JsonProperty("total_pages")
	private Integer totalPages;

	@JsonProperty("support")
	private Support support;
}