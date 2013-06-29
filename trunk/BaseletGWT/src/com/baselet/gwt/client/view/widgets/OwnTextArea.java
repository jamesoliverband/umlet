package com.baselet.gwt.client.view.widgets;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.TextArea;

public class OwnTextArea extends TextArea {

	private List<InstantValueChangeHandler> handlers = new ArrayList<InstantValueChangeHandler>();

	public OwnTextArea() {
		super();
		sinkEvents(Event.ONPASTE);
		this.addKeyUpHandler(new KeyUpHandler() {
			@Override
			public void onKeyUp(KeyUpEvent event) {
				fireHandlers();
			}
		});
	}

	@Override
	public void onBrowserEvent(Event event) {
		super.onBrowserEvent(event);
		if (DOM.eventGetType(event) == Event.ONPASTE) {
			Scheduler.get().scheduleDeferred(new ScheduledCommand() {
				@Override
				public void execute() {
					fireHandlers();
					}
			});
		}
	}

	public void fireHandlers() {
		for (InstantValueChangeHandler handler : handlers) {
			handler.onValueChange(getText());
		}
	}

	public static interface InstantValueChangeHandler {
		void onValueChange(String value);
	}

	public void addInstantValueChangeHandler(InstantValueChangeHandler handler) {
		handlers.add(handler);
	}

}
