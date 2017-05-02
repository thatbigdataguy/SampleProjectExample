package thesis.scxmlidl.example;

import java.io.IOException;
import java.net.URL;

import javax.xml.stream.XMLStreamException;

import org.apache.commons.scxml2.Context;
import org.apache.commons.scxml2.Evaluator;
import org.apache.commons.scxml2.SCXMLExecutor;
import org.apache.commons.scxml2.TriggerEvent;
import org.apache.commons.scxml2.env.SimpleErrorReporter;
import org.apache.commons.scxml2.env.SimpleSCXMLListener;
import org.apache.commons.scxml2.env.jexl.JexlEvaluator;
import org.apache.commons.scxml2.io.SCXMLReader;
import org.apache.commons.scxml2.model.ModelException;
import org.apache.commons.scxml2.model.SCXML;

public class Api implements IApi {
	Evaluator evaluator = new JexlEvaluator();

	SCXMLExecutor executor = new SCXMLExecutor(evaluator, null, new SimpleErrorReporter());

	SCXML scxml = null;
	@Override
	public void read(String path) {
		// TODO Auto-generated method stub
		final URL SCXML = Main.class.getResource(path);

		// engine to execute the scxml instance

		// parse SCXML URL into SCXML model
	
		try {
			scxml = SCXMLReader.read(SCXML);
		} catch (IOException | ModelException | XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// set state machine (scxml instance) to execute
		try {
			executor.setStateMachine(scxml);
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// create root context storing variables and being used by evaluator
		Context rootContext = evaluator.newContext(null);

		// create stopWatch object and add it to rootContext
		// to be able to script with that in SCXML.

		StopWatch stopWatch = new StopWatch();
		rootContext.set("stopWatch", stopWatch);

		// set the root context for the engine
		executor.setRootContext(rootContext);

		// initiate the execution of the state machine

	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Start Interpreter");
		try {
			executor.go();
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		new StopWatchFrame(executor);
		//new StopWatchFrame2(this,new StopWatch());
	}

	@Override
	public void fireEvent(Event event) {
		// TODO Auto-generated method stub
		   try {
			executor.triggerEvent(new TriggerEvent(event.name, TriggerEvent.SIGNAL_EVENT));
			//executor.addListener(scxml, new SimpleSCXMLListener());
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void addMonitor(SimpleMonitor monitor) {
		// TODO Auto-generated method stub
		executor.addListener(scxml, new SimpleMonitor());
	}
}
