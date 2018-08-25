package com.appscharles.libs.fxer.factories;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.exceptions.ThrowingOneConsumer;
import com.appscharles.libs.fxer.stages.FXStage;

/**
 * The interface On create stage consumable.
 */
public interface IOnCreateStageConsumable {

    /**
     * Sets on create consumer.
     *
     * @param <T>              the type parameter
     * @param onCreateConsumer the on create consumer
     * @return the on create consumer
     */
    <T> T setOnCreateConsumer(ThrowingOneConsumer<FXStage, FxerException> onCreateConsumer) ;
}
