package com.mycompany.exception;

public class BusException extends Exception {
	   
    public BusException(String message)
    {
        super(message);
        
    }
    
    public BusException(String message, Throwable cause)
    {
        super(message, cause);
    }
}