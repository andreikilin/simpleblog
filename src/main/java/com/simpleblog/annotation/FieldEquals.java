package com.simpleblog.annotation;


import com.simpleblog.validator.FieldEqualsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
 
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = FieldEqualsValidator.class)
@Documented
public @interface FieldEquals {

	    String message();
	 
	    Class<?>[] groups() default {};
	 
	    Class<? extends Payload>[] payload() default {};
	 
	    @Target(TYPE)
	    @Retention(RUNTIME)
	    @Documented
	    @interface List {
	        FieldEquals[] value();
	    }
	 
	    String field();
	 
	    String equalsTo();
}
