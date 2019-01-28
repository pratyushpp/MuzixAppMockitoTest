package com.stackroute.MuzixApplication.exceptions;

public class TrackAlreadyExistsException  extends Exception
{
    public String message;
    public TrackAlreadyExistsException()
    {

    }

    public TrackAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
