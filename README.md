[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.pacificwebconsulting.assertion/assertion-microservice/badge.svg?style=plastic)](https://maven-badges.herokuapp.com/maven-central/com.pacificwebconsulting.assertion/assertion-microservice)

Got a question?  [Email us](http://www.pacificwebconsulting.com/contact/) or reach out on [LinkedIn](https://www.linkedin.com/in/alombardo/) 

# Introduction

Welcome to a 100% Hamcrest and TestNG-based automated testing Assertion service.  This service should be used by projects 
that would like to leverage Hamcrest's sugar as well as TestNG's Assertion model in both a soft or hard assertion paradigm.  This service override the 
default TestNG Assert life cycle and controls the flow and execution of assertions in your test.

# Technology
All assertions follow [Hamcrest's](https://code.google.com/p/hamcrest/) Fluent API assertThat() structure.  See the API reference section for full
functionality with examples.

Also, this service automatically formats the assertions message string and its arguments by ultimately using the String.format() 
capabilities of the String object.  Many of the methods in this API use Java's variable arguments. 

# Prerequisites

1. Java 1.8
2. Maven 3.x

# Maven Dependency

```
<dependency>
    <groupId>com.pacificwebconsulting.assertion</groupId>
    <artifactId>assertion-microservice</artifactId>
    <version>1.0.0</version>
</dependency>
```

# Integration
By default the **AssertService() service** has the SOFT assertion capability enabled.  This means that when an assertion 
failure occurs the failure is stored in a Map of failures and will allow the test being executed to continue 
running until completion.  

However, you may switch AssertService to fail on the first assertion failure by instantiating the AssertService() 
object with a default boolean value of true or call setEnableHardAssertions().  Follow the examples below:

## Spring Bean Assertion Example
You are able to inject this service into your Java class if you use Spring.  The AssertService is annotated 
with the @Component annotation so you can simply do the following in your project:

* Add the following to your Spring context file:
```
<context:component-scan base-package="com.pwc.assert"/>
```

* Add the following to your class as a field:
```
@Autowired
protected AssertService assertService;
```

* Instantiate bean accordingly:
``` 
assertService = (AssertService) ctx.getBean("assertService");

// Optional to enable Hard Assertions
assertService.setEnableHardAssertions(true);
```

## Soft Assertion Example
```
AssertService softAssert = new AssertService();
```
## Hard Assertion via Constructor Example
```
AssertService hardAssert = new AssertService(true);
```

## Hard Assertion after Instantiation Example
```
AssertService assertService = new AssertService();
assertService.setEnableHardAssertions(true);
```

# API Reference

Base method that all assertions utilize:

```
assertThat(String message, Object actual, Matcher actualMatcher);
```

## General Assertions:
* assertThat();
* assertEquals();
* assertEqualsIgnoreCase();
* assertNotEquals();
* assertContains();
* assertContainsIgnoreCase();
* assertNotContains();
* assertNotNull();
* assertNull();
* assertFalse();
* assertTrue(); 
* assertBetween();
* assertBetweenOrEqual();
* assertGreaterThan();
* assertGreaterThanOrEqual();
* assertLessThan();
* assertLessThanOrEqual();
* assertContainsInOrder();
* assertPass();
* assertFail();

# Advanced Usage
The **Qssert Service** also enables users to extend its capabilities by bundling Hamcrest's [custom matcher](https://code.google.com/p/hamcrest/wiki/Tutorial) 
functionality. You'll probably find that you need to create your own Matcher from time to time to fit your testing needs. This commonly occurs when 
you find a fragment of code that tests the same set of properties over and over again (and in different tests), and you'd like 
to bundle the fragment into a single custom assertion. By writing your own matcher you'll eliminate code duplication and make your 
tests more readable! 

## Custom Assertions:
* assertCollectionContains();
* assertCollectionNotContains();
* assertCollectionInOrder();
* assertCollectionNotInOrder();
* assertRegexTrue();
* assertRegexFalse();
* assertContainsNotInOrder()
* assertJsonFieldEquals()
* assertJsonFieldNotEquals()
* assertJsonContainsField()
* assertJsonNotContainsField()
