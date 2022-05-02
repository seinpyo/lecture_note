package com.ezen.spg06;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	} // 잘 사용 안함 

	@Override
	public void validate(Object target, Errors errors) {
		//Object target : 검사할 객체를 받아주는 매개 변수 
		//Errors errors : 객체의 에러내용을 담아서 다시 보내줄 매개 변수  
		
		ContentDto dto = (ContentDto) target;
		String sWriter = dto.getWriter();
		String sContent = dto.getContent();
		
		if(sWriter == null || sWriter.trim().isEmpty()) {
			System.out.println("Writer is null or Empty");
			errors.rejectValue("writer", "trouble");
		} 
		
		if(sContent == null || sContent.trim().isEmpty()) {
			System.out.println("Content is null or Empty");
			errors.rejectValue("content", "trouble");
		}
	}

}
