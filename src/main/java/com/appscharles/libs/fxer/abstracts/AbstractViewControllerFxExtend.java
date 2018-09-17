package com.appscharles.libs.fxer.abstracts;

import com.appscharles.apps.stocker.commons.sneakers.ExceptionDialogThrowSneaker;
import com.appscharles.libs.fxer.controllers.AbstractViewControllerFX;
import com.appscharles.libs.fxer.exceptions.ThrowingConsumer;
import com.appscharles.libs.fxer.exceptions.ThrowingOneConsumer;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;

/**
 * The type Abstract view controller fx extend.
 */
public class AbstractViewControllerFxExtend extends AbstractViewControllerFX {

    /**
     * The Resource bundle.
     */
    protected ResourceBundle resourceBundle;

    /**
     * The On initialize consumers.
     */
    protected List<Consumer<ResourceBundle>> onInitializeConsumers;

    /**
     * The On shown consumers.
     */
    protected List<Runnable> onShownConsumers;

    /**
     * The On close consumers.
     */
    protected List<Runnable> onCloseConsumers;

    /**
     * Instantiates a new Abstract view controller fx extend.
     */
    public AbstractViewControllerFxExtend() {
        this.onInitializeConsumers = new ArrayList<>();
        this.onShownConsumers = new ArrayList<>();
        this.onCloseConsumers = new ArrayList<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        for (Consumer<ResourceBundle> onInitializeConsumer : this.onInitializeConsumers) {
            onInitializeConsumer.accept(resourceBundle);
        }
    }

    @Override
    public void onShown() {
        for (Runnable onShownConsumer : this.onShownConsumers) {
            onShownConsumer.run();
        }
    }

    @Override
    public void onClose() {
        for (Runnable onCloseConsumer : this.onCloseConsumers) {
            onCloseConsumer.run();
        }
    }

    /**
     * Add on initialize.
     *
     * @param consumer the consumer
     */
    protected void addOnInitialize(Consumer<ResourceBundle> consumer) {
        this.onInitializeConsumers.add(consumer);
    }

    /**
     * Add on initialize with sneaky throw.
     *
     * @param consumer the consumer
     */
    protected void addOnInitializeWithSneakyThrow(ThrowingOneConsumer<ResourceBundle, Exception> consumer) {
        Consumer<ResourceBundle> cons = (resourceBundle)->{
            ExceptionDialogThrowSneaker.sneaky(()->{
                consumer.accept(this.resourceBundle);
            });
        };
        this.onInitializeConsumers.add(cons);
    }

    /**
     * Add on initialize with sneaky throw.
     *
     * @param consumer the consumer
     */
    protected void addOnInitializeWithSneakyThrow(ThrowingConsumer<Exception> consumer) {
        Consumer<ResourceBundle> cons = (resourceBundle)->{
            ExceptionDialogThrowSneaker.sneaky(()->{
                consumer.accept();
            });
        };
        this.onInitializeConsumers.add(cons);
    }

    /**
     * Add on close.
     *
     * @param runnable the runnable
     */
    protected void addOnClose(Runnable runnable) {
        this.onCloseConsumers.add(runnable);
    }

    /**
     * Add on close with sneaky throw.
     *
     * @param consumer the consumer
     */
    protected void addOnCloseWithSneakyThrow(ThrowingConsumer<Exception> consumer) {
        Runnable runnable = ()->{
            ExceptionDialogThrowSneaker.sneaky(()->{
                consumer.accept();
            });
        };
        this.onCloseConsumers.add(runnable);
    }

    /**
     * Add on shown.
     *
     * @param runnable the runnable
     */
    protected void addOnShown(Runnable runnable) {
       this.onShownConsumers.add(runnable);
    }

    /**
     * Add on shown with sneaky throw.
     *
     * @param consumer the consumer
     */
    protected void addOnShownWithSneakyThrow(ThrowingConsumer<Exception> consumer) {
       Runnable runnable = ()->{
           ExceptionDialogThrowSneaker.sneaky(()->{
               consumer.accept();
           });
        };
        this.onShownConsumers.add(runnable);
    }

    /**
     * Sneaky throw.
     *
     * @param consumer the consumer
     */
    protected void sneakyThrow(ThrowingConsumer<Exception> consumer) {
        ExceptionDialogThrowSneaker.sneaky(()->{
            consumer.accept();
        });
    }
}
