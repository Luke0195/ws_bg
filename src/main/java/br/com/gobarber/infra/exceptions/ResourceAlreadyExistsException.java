package br.com.gobarber.infra.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException {

 public ResourceAlreadyExistsException(String message){
     super(message);
 }
}
