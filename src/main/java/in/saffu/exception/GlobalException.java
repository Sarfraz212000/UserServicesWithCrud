
package in.saffu.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.saffu.exceptionresponse.ApiResponse;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ApiResponse> handleUserNotFoundException(UserNotFoundException ex) {
		String message = ex.getMessage();
		ApiResponse response = new ApiResponse(message, false, LocalDate.now(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	}

}
