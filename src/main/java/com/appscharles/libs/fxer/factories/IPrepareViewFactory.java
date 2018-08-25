package com.appscharles.libs.fxer.factories;

import com.appscharles.libs.fxer.controllers.IStagableFX;
import com.appscharles.libs.fxer.exceptions.FxerException;
import javafx.scene.Parent;

/**
 * The interface View factory.
 */
public interface IPrepareViewFactory extends IStagableFX {

    /**
     * Create parent.
     *
     * @return the parent
     * @throws FxerException the fxer exception
     */
    Parent create() throws FxerException;
}
