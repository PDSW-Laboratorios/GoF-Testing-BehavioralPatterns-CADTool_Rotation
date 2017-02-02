package eci.arsw.pattern.observer;

public interface Observable {
	
	public void addObserver(Observer o);

	public void deleteObserver(Observer o);

	public void notifyObservers();
	
}
