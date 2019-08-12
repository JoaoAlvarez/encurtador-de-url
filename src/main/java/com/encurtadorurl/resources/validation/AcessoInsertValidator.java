package com.encurtadorurl.resources.validation;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.encurtadorurl.domain.Acesso;
import com.encurtadorurl.resources.exceptions.FieldMessage;

public class AcessoInsertValidator implements ConstraintValidator<AcessoInsert, Acesso> {

	@Override
	public void initialize(AcessoInsert ann) {
	}

	@Override
	public boolean isValid(Acesso obj, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();
		
		if (obj.getUrl().trim().equalsIgnoreCase("")) {
			list.add(new FieldMessage("url", "URL não foi enviada"));
		}
		
		if (!obj.getUrl().contains("http") || !obj.getUrl().contains(".")) {
			list.add(new FieldMessage("url", "URL invalida"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
			
			
