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
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<myErrorDetails> employeeExceptionHandler(EmployeeException ee,WebRequest req){
		
		myErrorDetails err = new myErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<myErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<myErrorDetails> exceptionHandler(Exception e,WebRequest req){
		myErrorDetails err = new myErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<myErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	//-------------- if the exception is in url or wrong method then this exception will work here
		@ExceptionHandler(NoHandlerFoundException.class)
		public ResponseEntity<myErrorDetails> no_Handler_Found_Exception(NoHandlerFoundException nhfe,WebRequest req){
			myErrorDetails err = new myErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(nhfe.getMessage());
			err.setDetails(req.getDescription(false));
			
			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		}
		//--------------------- Validation Exception ------------------------------------------------
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<myErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me)  {
		
			
			myErrorDetails err=new myErrorDetails(LocalDateTime.now(),"Validation Error",me.getBindingResult().getFieldError().getDefaultMessage());

			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
				
		}

}
