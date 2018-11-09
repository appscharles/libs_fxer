package com.appscharles.libs.fxer.exceptions;

/**
 * The interface Callable two consumer.
 *
 * @param <T> the type parameter
 * @param <R> the type parameter
 */
@FunctionalInterface
public interface CallableOneConsumer<T, R> {
    /**
     * Accept r.
     *
     * @param t the t
     * @return the r
     */
    R accept(T t);
}
