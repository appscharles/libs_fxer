package com.appscharles.libs.fxer.factories;

import com.appscharles.libs.fxer.exceptions.FxerException;

/**
 * The interface Iconable.
 */
public interface IStageIconable {

    /**
     * Sets icon.
     *
     * @param <T>          the type parameter
     * @param resourceIcon the resource icon
     * @return the icon
     */
    <T> T setIcon(String resourceIcon) throws FxerException;
}
