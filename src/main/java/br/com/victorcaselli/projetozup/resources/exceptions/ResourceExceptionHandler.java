package br.com.victorcaselli.projetozup.resources.exceptions;

import java.time.Instant;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.victorcaselli.projetozup.resources.exceptions.model.OAuthCustomError;
import br.com.victorcaselli.projetozup.resources.exceptions.model.StandardError;
import br.com.victorcaselli.projetozup.resources.exceptions.model.ValidationError;
import br.com.victorcaselli.projetozup.services.exceptions.ForbiddenException;
import br.com.victorcaselli.projetozup.services.exceptions.UnauthorizedException;
import br.com.victorcaselli.projetozup.services.exceptions.UserNotNullException;
import br.com.victorcaselli.projetozup.services.exceptions.UserRecordException;
import br.com.victorcaselli.projetozup.services.exceptions.VehicleParameterException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<OAuthCustomError> authorization(UnauthorizedException e, HttpServletRequest request) {
		
		OAuthCustomError error = new OAuthCustomError("Unauthorized", e.getMessage());
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
	}
	
	@ExceptionHandler(ForbiddenException.class)
	public ResponseEntity<OAuthCustomError> authorization(ForbiddenException e, HttpServletRequest request) {
		
		OAuthCustomError error = new OAuthCustomError("Forbidden", e.getMessage());
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
	}
	
	@ExceptionHandler(VehicleParameterException.class)
	public ResponseEntity<StandardError> authorization(VehicleParameterException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError error = new StandardError(Date.from(Instant.now()).getTime(), status.value() , "Invalid url parameter sequence", e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(UserRecordException.class)
	public ResponseEntity<StandardError> authorization(UserRecordException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError error = new StandardError(Date.from(Instant.now()).getTime(), status.value() , "Invalid Email or CPF", e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(UserNotNullException.class)
	public ResponseEntity<StandardError> authorization(UserNotNullException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError error = new StandardError(Date.from(Instant.now()).getTime(), status.value() , "User cannot be null", e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ValidationError err = new ValidationError();
		err.setTimestamp(Date.from(Instant.now()).getTime());
		err.setStatus(status.value());
		err.setError("Validation exception");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		for (FieldError f : e.getBindingResult().getFieldErrors()) {
			err.addError(f.getField(), f.getDefaultMessage());
		}
		
		return ResponseEntity.status(status).body(err);
	}	
	

}
