# design-patterns

## Description
This my attempt at learning and sharing my findings of design patterns(LLD/OOPS).

## Goal
Design patterns aim is to reduce code complexity, improve code readability, and make code easily extensible.
We follow SOLID principles to achieve our goals.
There might be some patterns for problems that are still lurking undiscovered. Let's see if we can find them in our this journey.

## Types
- Creational
- Structural
- Behavioral

We will understand this later why they are named so.

## Let's understand SOLID principles
- Single Responsibility Principle
- Open/Closed Principle
- Liskov Substitution Principle
- Interface Segregation Principle
- Dependency Inversion Principle

These definitions are taken from the [Wikipedia](https://en.wikipedia.org/wiki/SOLID) page.



### Single Responsibility Principle

The single-responsibility principle (SRP) states that there should never be more than one reason for a class to change. In other words, every class should have only one responsibility.

Importance:
Maintainability: When classes have a single, well-defined responsibility, they're easier to understand and modify.
Testability: It's easier to write unit tests for classes with a single focus.
Flexibility: Changes to one responsibility don't affect unrelated parts of the system.

### Open/Closed Principle

The open/closed principle (OCP) states that software entities (classes, modules, functions) should be open for extension but closed for modification. In other words, you should be able to add new functionality without changing existing code.

Importance:
Extensibility: New features can be added without modifying existing code.
Stability: Reduces the risk of introducing bugs when making changes.
Flexibility: Adapts to changing requirements more easily.

### Liskov Substitution Principle

The Liskov substitution principle (LSP) states that objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program. In other words, a subclass should be able to extend the behavior of a superclass without modifying it.

This is a tricky one to understand. 

Layman's Explanation: If class B is a subtype of class A, then anywhere you use A, you should be able to use B without breaking the program.




E.g., 

Importance:
Substitutability: Allows for polymorphism and code reuse.

### Interface Segregation Principle


### Dependency Inversion Principle


I have realized over time that these priciples somewhat resembles to UNIX philosophy. Like, Do one thing well: Each program should focus on doing a single, specific job without bloating itself with unrelated features. However, SOLID principles are more generic and while the later one being more concrete.
