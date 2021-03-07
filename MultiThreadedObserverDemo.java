package week3day5;

import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadedObserverDemo {

	public static void main(String[] args) {
		FireAlarm shakthi=new FireAlarm();
		Student student=new Student();
		Teacher teacher=new Teacher();
		
		shakthi.addObserver(student);
		shakthi.addObserver(teacher);
		
		shakthi.setAlarm();
	}

}


class MultiThreadedObservable extends Observable{

	Vector<Observer> vect = new Vector<>();
	
	@Override
	public synchronized void addObserver(Observer o) {
		// TODO Auto-generated method stub
		vect.add(o);
	}
	
	@Override
	public void notifyObservers(Object arg) {
		// TODO Auto-generated method stub
		ExecutorService es = Executors.newFixedThreadPool(vect.size());
		Enumeration<Observer> en = vect.elements();
		while(en.hasMoreElements()) {
			es.execute(()->{
				Observer obs = en.nextElement();
				obs.update(this,arg);
			});
		}
		es.shutdown();
	}

}


class FireAlarm extends MultiThreadedObservable{

public void setAlarm() {
	setChanged();
	notifyObservers("Fire !!! run.. run..");
}

}

class Student implements Observer{

@Override
public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	run((String)arg);
}

public void run(String msg) {
	System.out.println("Student is running...."+msg);
}

}

class Teacher implements Observer{

@Override
public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	run((String)arg);
}

public void run(String msg) {
	System.out.println("Grabing the belongings...");
	try {
		Thread.sleep(1000);
	}catch(Exception e){
		
	}
	System.out.println("Teacher is running...."+msg);
}

}