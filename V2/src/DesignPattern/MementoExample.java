package DesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * This is usefull when we want to backup and restore object state .
 */

class CareTaker {

    List<Momento> history = new ArrayList<>();

    public void addMomento(Momento s) {
        this.history.add(s);
    }

    public Momento undo() {
        if (!history.isEmpty()) {
            Momento s = history.get(history.size() - 1);
            history.remove(s);
            return s;
        } else
            return null;
    }
}

// Momento
class Momento {
    int preX;
    int preY;

    public Momento(int preX, int preY) {
        this.preX = preX;
        this.preY = preY;
    }

}

class Originator {

    int x, y;

    public Originator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Momento createMomento() {
        return new Momento(x, y);
    }

    public void restorwMomento(Momento stateToRestore) {
        this.x = stateToRestore.preX;
        this.y = stateToRestore.preY;
    }

    @Override
    public String toString() {
        return "{" +
                " x='" + getX() + "'" +
                ", y='" + getY() + "'" +
                "}";
    }

}

public class MementoExample {

    public static void main(String[] args) {
        CareTaker c = new CareTaker();

        Originator or = new Originator(10, 20);

        Momento m = or.createMomento();
        c.addMomento(m);
        System.out.println(or.toString());

        or.setX(30);
        or.setY(40);
        System.out.println(or.toString());
        Momento restoreObj = c.undo();
        or.restorwMomento(restoreObj);
        System.out.println(or.toString());

    }

}
