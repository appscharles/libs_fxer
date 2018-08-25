package com.appscharles.libs.fxer.factories;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.exceptions.ThrowingOneConsumer;
import javafx.scene.Parent;

/**
 * The interface Stage parent consumable.
 */
public interface IStageParentConsumable {

    /**
     * Sets parent consumer.
     *
     * @param <T>            the type parameter
     * @param parentConsumer the parent consumer
     * @return the parent consumer
     */
    <T> T setParentConsumer(ThrowingOneConsumer<Parent, FxerException> parentConsumer) ;
}
