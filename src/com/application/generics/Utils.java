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

    public static void printOnlyUsersNotChildren(GenericList<User> users) {

        // this method will not accept GenericList<Instructor> object as an input
        // argument, because it is totally a different instantiated class and it is not
        // the same as GenericList<User>.

        // so this method will only accept GenericList<User>.
    }

    public static void printUsersWildCard(GenericList<?> users) {

        // without any restrictions
        Object x = users.get(0);

        // to add restrictions on the <?> and control the input.
        // for example we want to store users.get(0) in a User object. right now, we can
        // not do this because type of wildcard class CAP#1 is not derived from user
        // the following line will throw an error.
        // ! User x = users.get(0); // will throw an error

        // but we can downcast the object to User, but it is dangerous and we should
        // check it with if to check whether it is the instance of the given class or
        // not, unless, it will throw an unchecked error.
        User u = (User) users.get(0);

        System.out.println(u);

    }

    // ? --> wild card - unknown type
    // class CAP#1 extends User {} is type of wild card that we do not have access
    // to it and it is acting just like this : class Instructor extends User {}
    // Instructor is not CAP#1 and they are 2 different things
    // * if you want to read from the list, use "extends" keyword
    // in here, <?> or CAP#1 is the child of User so it will only accepts User as an
    // argument
    public static void printUsers(GenericList<? extends User> users) {

        // will throw an error - instructor is not the same as CAP#1
        // ! Instructor x = users.get(0); // will throw an error

        // you can read from it or store it in the User variable
        // the original type of <T> is converted to CAP#1 but because we specified that
        // it is a child of User, it has no problem to be stored in the User object
        // variable. So the following code will be allright.
        User x = users.get(0);

        // the following code will throw and error, because it is going to accept the
        // item in a type of <T>; <T> in here is now converted to CAP#1 which is a child
        // of User and it will accept this type of argument; Hence, because we don't
        // have access to CAP#1 class and objects, we can not perform this action.
        // ! users.add(x); // will throw an error

        // to see the solution see superPrintUsers
    }

    // * if you want to add to the list, you should use "super" keyword
    public static void superPrintUsers(GenericList<? super User> users) {
        // in here, <?> or CAP#1 is the parent of User
        // we are using "super" instead of "extends" to tell the java compiler that the
        // type of the (?) class which was CAP#1 before, is now changed to a parent
        // class to the User class, and that parent class is Object class.
        // so in this way we can also write to the users object.

        // java compiler is going to treat 'users' object just like the below:
        GenericList<Object> temp = new GenericList<>();

        // the following code will throw an error, because the type f the return item is
        // CAP#1, since this type is not accessible and also it will act like Object so
        // it will not get stored in User variable.
        // ! User x = users.get(0); // will throw an error

        User x = (User) users.get(0);

        Object y = users.get(0);

        users.add(new User(15));
        users.add(new Instructor(1));
    }

    public static <K, V> void print(K key, V value) {
        System.out.println(key + "=" + value);
    }
}
