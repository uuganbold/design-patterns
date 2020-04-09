package edu.luc.comp473.observer.observers;

import java.util.HashMap;
import java.util.Map;

import edu.luc.comp473.observer.Observable;
import edu.luc.comp473.observer.Observer;

public class RenderCounter implements Observer {

    private Map<Observable,Integer> count=new HashMap<>();

    @Override
    public void update(Observable observable) {
        int c=count.getOrDefault(observable, 0);
        count.put(observable, c+1);

    }

    public int getCount(Observable observable){
        return count.getOrDefault(observable, 0);
    };

}