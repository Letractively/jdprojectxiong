package com.ejd.web.vo.richfaces.header;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;


public class HeaderTabChangeListener implements ValueChangeListener {

	public void processValueChange(ValueChangeEvent event)
			throws AbortProcessingException {

		System.out.println("TabChangeListener.processValueChange()");
		System.out.println("Old value: " + event.getOldValue());
		System.out.println("New value: " + event.getNewValue());
	}

}
