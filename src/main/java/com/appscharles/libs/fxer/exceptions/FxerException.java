package com.appscharles.libs.fxer.exceptions;

/**
 * The type Updater exception.
 */
public class FxerException extends Exception {
    /**
     * The Serial version uid.
     */
    static final long serialVersionUID = 7813455828146020432L;

    /**
     * Instantiates a new Updater exception.
     */
    public FxerException() {
        super();
    }

    /**
     * Instantiates a new Updater exception.
     *
     * @param message the message
     */
    public FxerException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Updater exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public FxerException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Updater exception.
     *
     * @param cause the cause
     */
    public FxerException(Throwable cause) {
        super(cause);
    }
}

