package ru.andr.javadaddy.advanced.streams.topic1;

@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);
}
