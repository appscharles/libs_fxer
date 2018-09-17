package com.appscharles.libs.fxer.abstracts;

import com.appscharles.libs.ioer.models.StatusProgress;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * The type Abstract async with status progress.
 */
public abstract class AbstractAsyncWithStatusProgress implements IStatusProgressAsynchable {

    /**
     * The Status progress.
     */
    protected StatusProgress statusProgress;

    /**
     * The Interrupt property.
     */
    protected  BooleanProperty interruptProperty;

    /**
     * Instantiates a new Abstract async with status progress.
     */
    protected AbstractAsyncWithStatusProgress(){
        this.statusProgress = new StatusProgress();
        this.interruptProperty = new SimpleBooleanProperty(false);
    }

    @Override
    public StatusProgress getStatusProgress() {
        return this.statusProgress;
    }

    @Override
    public BooleanProperty getInterruptProperty() {
        return this.interruptProperty;
    }
}
