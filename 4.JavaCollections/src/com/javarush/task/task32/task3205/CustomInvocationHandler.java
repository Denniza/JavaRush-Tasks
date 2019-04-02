package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    SomeInterfaceWithMethods someInterfaceWithMethods;

    public CustomInvocationHandler(SomeInterfaceWithMethods a) {
        this.someInterfaceWithMethods = a;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println(method.getName() + " in");
        method.invoke(someInterfaceWithMethods,objects);
        System.out.println(method.getName() + " out");
        return method.invoke(someInterfaceWithMethods,objects);
    }
}
