import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import com.application.Page;
import com.application.classes.Clock;
import com.application.classes.Workspace;
import com.application.collections.CollectionsDemo;
import com.application.collections.IterableGenericList;
import com.application.collections.ListsDemo;
import com.application.exceptions.CustomException;
import com.application.exceptions.GeneralException;
import com.application.generics.GenericList;
import com.application.generics.Instructor;
import com.application.generics.NumericalGenericList;
import com.application.generics.User;
import com.application.generics.Utils;
import com.browser.CheckBox;
import com.browser.Element;
import com.browser.TextBox;
import com.coordinate.EnhancedPoint;
import com.coordinate.Point;

// java.lang does not need to be imported. It is available by default globally

public class App {

    // default access modifier for classes, properties and methods is
    // package-private which acts like public inside a certain package
    public static int variable = 123;

    // main method is always static so the java runtime environment can call it
    // without creating a new object or instance as you see.
    public static void main(String[] args) throws Exception {
        // fundamentals();
        // exceptionHandling();
        // useGenerics();
        // useIterables();
        // useCollections();
        useLists();
    }

    public static void useLists() {
        ListsDemo.show();
    }

    public static void useCollections() {
        CollectionsDemo.show();
    }

    public static void useIterables() {
        var list = new IterableGenericList<String>();
        var iterator = list.iterator();

        // [a, b, c]
        // ^

        list.add("item 0");

        while (iterator.hasNext()) {
            var current = iterator.next();
            System.out.println(current);
        }

        list.add("item 1");
        list.add("item 2");
        list.add("item 3");
        list.add("item 4");

        // just a syntactical sugar for iterators
        // better and more handy approach
        for (var item : list) {
            System.out.println(item);
        }

    }

    public static void useGenerics() {

        // we should specify the type of objects that we want to instantiate and store
        // when creating an instance of a generic type, we can only use a reference type
        // as a generic type argument, which is <T>. If you want to use primitive types
        // in <T>, you could use Wrapper Class. e.g. if you want to use <int> you can
        // use its wrapper class which is Integer.
        var list1 = new GenericList<String>();
        list1.add("First Item");

        list1.get(0);

        var list2 = new GenericList<Element>();

        // another way of creating generics
        GenericList<Integer> numbers = new GenericList<>();

        // this primitive value (1) is going to get automatically wrapped inside an
        // instance of the Integer wrapper class by Java Compiler.
        // Integer.valueOf(1) --> wrapping the integer value to store the value
        // correctly
        numbers.add(1); // Boxing
        int number = numbers.get(0); // Unboxing

        System.out.println(number);

        // throws an error
        // only supports Number and its children as generic type argument
        // var numbers2 = new NumericalGenericList<String>();
        var user1 = new User(10);
        var user2 = new User(20);

        // using generic interfaces
        System.out.println(user1.compareTo(user2));

        // using generic methods
        System.out.println(Utils.max(1, 3));
        System.out.println(Utils.max(user1, user2));

        Utils.print(1, "value");

        Instructor user3 = new Instructor(99);
        Utils.printUser(user3);

        var instructors = new GenericList<Instructor>();
        var users = new GenericList<User>();

        users.add(user1);
        instructors.add(user3);

        Utils.printUsers(instructors);

        Utils.printUsersWildCard(list1);

    }

    public static void fundamentals() {
        // static properties and methods are bound to class not object.
        // we can not have access to "this" in static methods becuase this refers to the
        // current object and it is not available in the static context
        // we only have access to static methods, the class itself (App) and static
        // variables. we can access to other methods when they are static methods

        App.useObjectOriented();

        // or in simpler syntax just call them.

        // useObjectOriented();
        // compareObjects();
        // polymorphism();
        // useInterface();

        // we can also access static variables

        System.out.println(variable);
    }

    public static void exceptionHandling() {
        // useExceptionHandler();
        // useResourceExceptionHandler();
        try {
            useThrowException(50);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            useCustomException();
        } catch (CustomException e) {
            e.printStackTrace();
        }

        try {
            useExceptionChaining1();
        } catch (GeneralException e) {
            e.printStackTrace();
        }

        try {
            useExceptionChaining2();
        } catch (GeneralException e) {
            e.printStackTrace();
        }
    }

    public static void useExceptionChaining1() throws GeneralException {

        // first way
        // throwing "general exception" that is caused by "custom exception"
        // the overall problem is defined by general exception but it is due to the
        // custom exception and it is called exception chaining.
        var customException = new CustomException();
        var generalException = new GeneralException();
        generalException.initCause(customException);
        throw generalException;

    }

    public static void useExceptionChaining2() throws GeneralException {

        // second way
        // throwing "general exception" that is caused by "custom exception"
        throw new GeneralException(new CustomException());

    }

    public static void useCustomException() throws CustomException {
        throw new CustomException();
    }

    // the "throws Exception" is going to tell the java compiler that this method
    // may throw and exception so it is implicitly catch the exceptions
    // then when ever we want to use this method, we should wrap this method with
    // try-catch block to make it work.
    // this pattern makes the caller of this function responsible for handling this
    // exception and it should be handled wherever is get called.
    public static void useThrowException(int value) throws Exception {

        // defensive programming - prevent the rest of our code from getting executed
        // this style of coding is used when you are getting inputs from the user or
        // external systems. for example you are developing a library or framework.
        // using a lot of this validation logic of defensive programming may pollute
        // your code so be careful about using it.
        if (value <= 100) {
            throw new IllegalArgumentException();
        }

    }

    public static void useResourceExceptionHandler() {
        // this is called try with resources
        // really helpful for the problem that we faced when we want to access reader in
        // finally and other blocks due to scope problem
        // with this syntax, we do not need to close the reader by ourselves. java
        // compiler will do it for us and it is very easier way to use.

        // the resource in try(...) should be an object which implements AutoClosable
        // interface and it should have the close() method in itself.
        try (var reader = new FileReader("file.txt")) {
            var value = reader.read();
        } catch (Exception e) {
            System.out.println("FAILED");
        }

        // another usage of resources in try
        try (var reader = new FileReader("file.txt"); var writer = new FileWriter("file.txt");) {
            var value = reader.read();
        } catch (Exception e) {
            System.out.println("FAILED");
        }

    }

    public static void useExceptionHandler() {
        FileReader reader = null;
        try {
            // reading the file will be started at the location of Current Working Directory
            // or CWD, the location that you invoke the java compiler to run the program
            reader = new FileReader("file.txt");
            var value = reader.read();
            var dateFormat = new SimpleDateFormat().parse("");

            // first way to catch multiple exceptions
        } catch (FileNotFoundException | ParseException e) {
            System.out.println("File does not exist. " + e.getMessage());
            e.printStackTrace();

            // second way to catch multiple exceptions
        } catch (IOException e) {
            e.printStackTrace();

            // finally block will always get executed
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void useInterface() {
        var clock = new Clock();
        var workspace = new Workspace();
        var page = new Page(clock);

        page.display();

        page.setWidget(workspace);

        page.display();

        page.show(clock);
    }

    public static void polymorphism() {
        // we know that every textboxes and checkboxes are elements
        Element[] elements = { new TextBox(), new CheckBox() };

        // foreach in java
        for (var element : elements) {
            element.render();
        }

    }

    public static void compareObjects() {

        var point1 = new Point(1, 2);
        var point2 = new Point(1, 2);

        // returns false, this compares the reference addresses of these objects
        System.out.println(point1 == point2);
        System.out.println(point1.equals(point2));

        var point3 = new EnhancedPoint(1, 2);
        var point4 = new EnhancedPoint(1, 2);

        // returns true, because we overrided the behaviour of equals
        // notice that in java, we don't have operator overloading
        System.out.println(point3.equals(point4));
        System.out.println(point3.hashCode());
        System.out.println(point4.hashCode());

    }

    public static void downUpCasting(Element el) {

        // in upcasting, we can not have access to the child properties but the
        // overrided methods are going to get called like toString(). In order to have
        // access to child properties which is TextBox in here, we should perform a
        // downcasting, an explicit casting to the child class.
        // instanceof : an operator which checks an object whether is the instance of
        // another object or not
        if (el instanceof TextBox) {
            var textBox = (TextBox) el;
            System.out.println("using textbox downcasted : " + textBox);
        }

        System.out.println("using element upcasted : " + el);

    }

    public static void useObjectOriented() {
        // you can access directly to other classes which are inside of the currrent
        // package of your application
        // but if the target class in on another package and it is not private or
        // package-private, you can access
        // to it with importing the class using the notation : import
        // path.to.package.className

        var textBox1 = new TextBox();
        textBox1.setText();
        System.out.println(textBox1);

        // because TextBox is a child of Element, it means that "TextBox is an Element".
        // we can use every child of Element class wherever we have Element parameter
        // and we can give its child which is TextBox as an argument.
        // this is called upcasting. But in the method, you do not have access to the
        // child class fields and methods.
        downUpCasting(textBox1);

    }

    // java features
    public static void usingVar() {
        // how to automatically determine the type of the variable ?
        var number = 123;
        var array = new int[10];
        var string = "salam";

        // it is very shorter and cleaner way to define objects of a class
        // i mean instantiating an object from a class
        var textBox1 = new TextBox();

        System.out.println(string);

    }

    public static void primitiveTypes() {
        byte age = 30;
        short height = 123;
        int integerNum = 123456;
        long longNum = 123_456_7L;
        float awshari = 10.55F;
        double doubleNum = 100.123;
        char character = 'A';
        boolean isAuthenticated = true;
    }

    public static void referenceTypes() {

        // most of the reference types are needed to be imported
        // e.g. Date, with new operator, an instance of the Date class is created
        Date nowDate = new Date();

        // String is a reference type in the java.lang package
        // java.lang is automatically imported in every java application
        // you don't need to import it. btw it doesn't need to use new either;
        // there is a shorthand syntax which is double quotation
        String message = "this is a string";

        // it is also worth mentioning that Strings in java are immutable types.
        // every methods that modifies String Objects, actually return new Objects.
        System.out.println(message);
    }

    public static void constants() {

        final float pi = 3.14F;
        // throws an error
        // pi = 0;
    }

    public static void arrays() {

        // arrays are fixed in length
        // we can add or remove items with Collections

        // standard syntax
        int[] numbers = new int[10];
        numbers[0] = 4;
        numbers[1] = 5;
        System.out.println(Arrays.toString(numbers));

        // short syntax
        int[] newNumbers = { 9, 5, 3, 6, 2 };
        Arrays.sort(newNumbers);
        System.out.println(Arrays.toString(newNumbers));

        // multi-dimensional arrays standard syntax
        int[][] multiDimArray = new int[3][4];
        multiDimArray[0][1] = 99;
        System.out.println(Arrays.deepToString(multiDimArray));

        // multi-dimensional arrays short syntax
        int[][] newMultiDimArray = { { 0, 0 }, { 1, 1 } };
        System.out.println(Arrays.deepToString(newMultiDimArray));

    }

    public static void stringToNumber() {
        String x = "123";
        String y = "12.22";

        // convert x to integer using wrapper classes
        int number = Integer.parseInt(x);

        double doubleNum = Double.parseDouble(y);

        System.out.println(number);
        System.out.println(doubleNum);
    }

    public static void math() {
        int rounded = Math.round(12.11F);

        int random = (int) (Math.random() * 100);

        System.out.println(random);
    }

    public static void formatNumber() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(1234567.890);
        System.out.println(result);
    }

    public static void inputScanner() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println("You are " + input);
        scanner.close();
    }

}
