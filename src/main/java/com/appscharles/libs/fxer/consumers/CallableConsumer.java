package com.appscharles.libs.fxer.consumers;

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
public interface CallableConsumer<T, S,  R> {
    R accept(T t, S s);
}
