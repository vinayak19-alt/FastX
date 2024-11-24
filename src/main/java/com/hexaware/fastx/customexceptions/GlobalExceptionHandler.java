package com.hexaware.fastx.customexceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hexaware.fastx.payload.ErrorDetails;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleEntityNotFoundException(EntityNotFoundException exception,
            WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
		webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ResourceNotAvailableException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotAvailableException(ResourceNotAvailableException exception,
			WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(true));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BadRequestMadeException.class)
	public ResponseEntity<ErrorDetails> handleBadRequestMadeException(BadRequestMadeException exception,
			WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(true));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest w) {
		Map<String, String> errors = new HashMap<>();
		
		List<ObjectError> errList = ex.getBindingResult().getAllErrors();
		
		errList.forEach((error) -> {
			String fieldName = ((FieldError)error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
		
	}
	
}
