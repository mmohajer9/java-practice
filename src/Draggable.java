// interface is a contract between classes which is used for making loosley-coupled design
// remove coupling between classes by defining a public interface as a contract
// just contains methods signatures, and all of them considered as public
// naming convention : --able like Draggable, Can-- like CanCalculate, --or --er like Calculator

// we will use the interface as a type indicator in dependant classes instead of other classes 
// and we create other classes based on that interface then we pass it in the run time
// we will use the concept of dependency injection and seperation of concerns to pass the dependency

// dependency injection: not instantiating objects and dependencies inside one class, instead, we can pass
// dependencies in other ways to the target class

// seperation of concerns: creating object instances and using them for some applications can be done in
// seperate classes and seperate locations. one class should try to only concern and be responsible 
// for one thing at the same time.

// so everytime we want a new class based on that interface, we could simply implement another class
// based on that interface, and we will not change the implementation of the target class because
// it depends on the interface, so we could only recompile the dependant class if we want to change it someday
public interface Draggable {

    void getLocation();
    void getX();
    void getY();

}
