package DesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject
 * The object that has some interesting state is often called subject,
 * but since it’s also going to notify other objects about the changes to its
 * state, we’ll call it publisher.
 * All other objects that want to track changes to the publisher’s state are
 * called subscribers (observer).
 */
interface Subject {

    public void register(Observer ob);

    public void unregister(Observer ob);

    public void notifyObservers();

    public Object getUpdate(Observer ob);
}


class MyTopic implements Subject {
    String msg;
    List<Observer> subscribers = null;

    MyTopic() {
        subscribers = new ArrayList<>();
    }

    @Override
    public void register(Observer ob) {
        subscribers.add(ob);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : subscribers) {
            observer.Update();
        }
    }

    @Override
    public void unregister(Observer ob) {
        if (subscribers.contains(ob))
            subscribers.remove(ob);
    }

    @Override
    public Object getUpdate(Observer ob) {
        return this.msg;

    }

    void postMessage(String msg){
        this.msg=msg;
        notifyObservers();
    }

}

/**
 * Observer
 */

interface Observer {

    public void Update();

    public void setSubject(Subject subject);
}

class MySubscriber implements Observer {

    String name;

    Subject topic;

    public MySubscriber(String name, Subject topic){
        this.name=name;
        this.topic=topic;
    }

    @Override
    public void Update() {
        String msg = (String) topic.getUpdate(this);
        if(msg!=null)
        System.out.println(msg);
    }

    @Override
    public void setSubject(Subject subject) {
        this.topic = subject;
    }

}



public class ObserverPattern {

    public static void main(String[] args) {

          MyTopic topic=new MyTopic();
          
          Observer ob1=new MySubscriber("s1", topic);
          Observer ob2=new MySubscriber("s2", topic);

          topic.register(ob1);
          topic.register(ob2);

        //   ob1.setSubject(topic);
        //   ob2.setSubject(topic);

          
          ob1.Update();
          ob2.Update();

          topic.postMessage("Welcome");

    }

}
