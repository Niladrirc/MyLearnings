package creationalDesignPatterns.singleton.reflection;

import creationalDesignPatterns.singleton.eager.EagerInitializationSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionSingletonTest {
    public static void main(String[] args) {
        EagerInitializationSingleton instanceOne = EagerInitializationSingleton.getInstance();
        EagerInitializationSingleton instanceTwo = null;
        EagerInitializationSingleton instanceThree = EagerInitializationSingleton.getInstance();
        try {
            Constructor<?>[] constructors = EagerInitializationSingleton.class.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                constructor.setAccessible(true);
                instanceTwo = (EagerInitializationSingleton) constructor.newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
        System.out.println(instanceThree.hashCode());
    }
}
