package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class myGlobalExceptionHandler {
	
	@ExceptionHandler(CourseException.class)
	public ResponseEntity<myErrorDetails> productExceptionHandler(CourseException p, WebRequest req){
		myErrorDetails err = new myErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(p.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<myErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	
	}
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<myErrorDetails> productExceptionHandler(StudentException p, WebRequest req){
		myErrorDetails err = new myErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(p.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<myErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<myErrorDetails> exceptionHandler(Exception e, WebRequest req){
		myErrorDetails err = new myErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<myErrorDetails>(err,HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<myErrorDetails> noHandlerExceptionHandler(NoHandlerFoundException n, WebRequest req){
		myErrorDetails err = new myErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(n.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<myErrorDetails>(err,HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<myErrorDetails> validationHandler(MethodArgumentNotValidException me){
		myErrorDetails err =new myErrorDetails(LocalDateTime.now(),"Validation Error",me.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);

	}
}
