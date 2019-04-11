

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.JsonMappingException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleException(MethodArgumentNotValidException e){
		return new ResponseEntity<String>("Something Wrong111", HttpStatus.BAD_REQUEST);

     //e.getBindingResult().getAllErrors()

     }

     @ExceptionHandler(JsonMappingException.class)
     public  
     ResponseEntity<String>handleJsonMappingException(JsonMappingException e){
		return new ResponseEntity<String>("Something Wrong", HttpStatus.BAD_REQUEST);
     }
}