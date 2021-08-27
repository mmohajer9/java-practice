package com.application.generics;

public class Utils {

    // generic method - we did not apply the generic type argument to the whole
    // Utils class. we only needed that in this method.
    public static <T extends Comparable<T>> T max(T first, T second) {
        return (first.compareTo(second) < 0) ? first : second;
    }

    public static void printUser(User user) {
        System.out.println(user);
    }

    // ? --> wild card - unknown type
    // class CAP#1 extends User {} is type of wild card that we do not have access
    // to it and it is acting just like this : class Instructor extends User {}
    // Instructor is not CAP#1 and they are 2 different things
    // * if you want to read from the list, use "extends" keyword
    public static void printUsers(GenericList<? extends User> users) {

        // will throw an error - instructor is not the same as CAP#1
        // Instructor x = users.get(0);

        // you can read from it or store it in the User variable
        User x = users.get(0);

        // still you can not add x because the original type of x is CAP#1
        // and it is due to that we don't have access to CAP#1 class
        // users.add(x);

        // to see the solution see superPrintUsers
    }

    // * if you want to add to the list, you should use "super" keyword
    public static void superPrintUsers(GenericList<? super User> users) {
        // we are using "super" instead of "extends" to tell the java compiler that the
        // type of the (?) class which was CAP#1 before, is now changed to a parent
        // class to the User class, and that parent class is Object class.
        // so in this way we can also write to the users object.
        GenericList<Object> temp = new GenericList<>();

        users.add(new User(15));
        users.add(new Instructor(1));
    }

    public static <K, V> void print(K key, V value) {
        System.out.println(key + "=" + value);
    }
}
