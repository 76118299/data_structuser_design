package design.observer;

import java.util.ArrayList;
import java.util.List;

public class Source {
    List<Observer> observerList = new ArrayList<Observer>();

    public void  trigger(){
        EventObject event = new EventObject(this,"事件对象");
        for(Observer observer : observerList){
            observer.handler(event);
        }
    }
}
