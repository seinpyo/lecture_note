package com.ezen.spg08;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ContentDto {
	
	@NotNull(message = "writer is null")
	@NotEmpty(message = "writer is Empty")
	@Size(min=4, max=20, message= "writer min 4, max 20.")
	
	private String writer;
	
	@NotNull(message = "content is null")
	@NotEmpty(message = "content is Empty")
	private String content;
	
}
