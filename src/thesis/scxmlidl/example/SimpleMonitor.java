package thesis.scxmlidl.example;

import java.io.Serializable;

import org.apache.commons.scxml2.SCXMLListener;
import org.apache.commons.scxml2.env.SimpleSCXMLListener;
import org.apache.commons.scxml2.model.EnterableState;
import org.apache.commons.scxml2.model.Transition;
import org.apache.commons.scxml2.model.TransitionTarget;

public class SimpleMonitor implements SCXMLListener, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void onEntry(EnterableState arg0) {
		// TODO Auto-generated method stub
		//System.out.println("onEntry");
		System.out.println("onEntry " + arg0.getId());
	}

	@Override
	public void onExit(EnterableState arg0) {
		// TODO Auto-generated method stub
		//System.out.println("onExit");
		System.out.println("onExit " + arg0.getId());

	}

	@Override
	public void onTransition(TransitionTarget arg0, TransitionTarget arg1, Transition arg2, String arg3) {
		// TODO Auto-generated method stub
		//System.out.println("onTransition");
		System.out.println("onTransition From " + arg0.getId() + " To " + arg1.getId());

	}

}
