package edu.luc.comp473.observer;

public interface Observable {

    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}