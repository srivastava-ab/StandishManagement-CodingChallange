package com.example.abhinav.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Abhinav
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientException extends RuntimeException {

  public ClientException(String exception) {
    super(exception);
  }

}