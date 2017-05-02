package thesis.scxmlidl.example;

import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Api Interpreter = new Api();
	//	a.start();
		
		Interpreter.read("stopwatch.xml");
		Interpreter.start();
		Interpreter.addMonitor(new SimpleMonitor());
		
	}

}
