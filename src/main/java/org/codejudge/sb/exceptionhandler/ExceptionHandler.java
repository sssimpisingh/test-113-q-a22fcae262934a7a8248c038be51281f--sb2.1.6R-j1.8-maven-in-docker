package org.codejudge.sb.exceptionhandler;

import org.codejudge.sb.model.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(javax.persistence.RollbackException.class)
	public ResponseEntity<?> getErrorHandling(javax.persistence.RollbackException e) {

		ResponseObject responseObject = new ResponseObject();
		responseObject.setReason(e.getMessage());
		responseObject.setStatus("failure");

		return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<?> handleNumberFormateException(NumberFormatException e) {

		ResponseObject responseObject = new ResponseObject();
		responseObject.setReason(e.getMessage());
		responseObject.setStatus("failure");

		return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
	}

}
