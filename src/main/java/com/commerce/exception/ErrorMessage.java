package com.commerce.exception;

public class ErrorMessage {
    private String message;
    private String details;

    public ErrorMessage(String message, String details) {
                 super();
                 this.details = details;
                 this.message = message;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
    
    
}
