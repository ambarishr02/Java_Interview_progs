package DesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Compose objects into tree structures to represent part-whole hierarchies.
 * Clients can treat individual objects and compositions of objects uniformly.
 * 
 * Participants in the Composite Pattern:

    Component:
        Declares the interface for objects in the composition (both leaves and composites).
        Defines default behavior for all classes in the composition.

    Leaf:
        Represents individual objects in the composition.
        Implements the behavior defined in the Component interface.

    Composite:
        Represents a composition of objects (subcomponents).
        Implements the behavior defined in the Component interface.
        May have child components (leaves or other composites).
 * 
 */

 //component
interface Component{
    public void draw();
}


//Leaf
class Circle implements Component{

    @Override
    public void draw() {
       System.out.println("Circle Componet draw");
    }

}

//Composite
class Drawing implements Component{

    List<Component> componentList =new ArrayList<>();

    public void addComponent(Component c){
        componentList.add(c);
    }

    @Override
    public void draw() {
        for (Component component : componentList) {
            component.draw();
        }
    }

}

public class CompositePattern {
    


    public static void main(String[] args) {
           Component circle = new Circle();
        Component drawing = new Drawing();
        
        ((Drawing) drawing).addComponent(circle);
        drawing.draw();
    }
}
