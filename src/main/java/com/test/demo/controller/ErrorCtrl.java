package com.test.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice 
public class ErrorCtrl {

	    
	    @ExceptionHandler(IOException.class)
	    @ResponseStatus(value=HttpStatus.NOT_FOUND)	    
	    public void handleIOException(){  
	        //returning 404 error code  
	    }
	    
	    @ExceptionHandler(NoHandlerFoundException.class)
	    @ResponseStatus(value=HttpStatus.NOT_FOUND)	    
	    public Object handleHanlderException(){  
	        //returning 404 error code
	    	return "not found ";
	    }  
	      	      	    
	    @ExceptionHandler(value = Exception.class)	    
	    public Object defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
	        
	        return "exception "+e.getMessage();
	    }
}
