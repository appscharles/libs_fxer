package com.appscharles.libs.fxer.exceptions;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 14.07.2018
 * Time: 11:38
 * Project name: databaser
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
@FunctionalInterface
public interface ThrowingConsumer<E extends Throwable> {
    void accept() throws E;
}
