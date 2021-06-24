package br.com.victorcaselli.projetozup.resources.exceptions;

import java.time.Instant;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.victorcaselli.projetozup.services.exceptions.ForbiddenException;
import br.com.victorcaselli.projetozup.services.exceptions.UnauthorizedException;
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
	

}
