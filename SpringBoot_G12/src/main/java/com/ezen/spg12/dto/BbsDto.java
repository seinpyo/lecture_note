package com.ezen.spg12.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class BbsDto {
	
	private int id;
	
	@NotNull(message="writer is null")
	@NotEmpty(message="writer is empty")
	private String writer;
	
	@NotNull(message="title is null")
	@NotEmpty(message="title is empty")
	private String title;
	
	@NotNull(message="content is null")
	@NotEmpty(message="content is empty")
	private String content;
}
