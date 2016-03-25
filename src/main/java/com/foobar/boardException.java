package com.foobar;

/**
 * Created by jconstan on 3/21/16.
 */
public class boardException extends Exception {
    String message;

    boardException(String message) {
        super(message);
    }
}
