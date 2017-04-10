# JRho
Java library for Refinement Operator.

## Usage

Create a Java class for the operator.

```java
class MyJRho extends JRho {
    public MyJRho(Set<JRhoObject> objects) {
        super(objects);
    }
```

Implement the method to be called at each refinement step. 

```java
    @Override
    protected boolean process(Node node) {
        // ...
        return keepRefining;
    }
```

Create the node components (`JRhoObject`s), which will define the nodes in the refinement tree.

```java
    // node components
    Set<JRhoObject> comp = new HashSet<>();
    for (int i = 0; i < 5; i++) {
        // a JRhoObject is a reference to a node component
        comp.add(new JRhoObject("obj" + String.valueOf(i)));
    }
```

Create operator object and start refining.

```java
    MyJRho jrho = new MyJRho(comp);
    jrho.refine();
```

## Features

* Custom termination criteria.
* Multi-thread support (Java 1.8).

