package ru.andr.javadaddy.advanced.collections.topic1.task3;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
