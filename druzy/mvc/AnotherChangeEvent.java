package druzy.mvc;

import java.util.EventObject;

public class AnotherChangeEvent extends EventObject {

	private static final long serialVersionUID = 4367945504583062387L;
	private EventObject event=null;
	
	public AnotherChangeEvent(EventObject event){
		super(event.getSource());
		this.event=event;
	}

	public EventObject getEvent() {
		return event;
	}

	public void setEvent(EventObject event) {
		this.event = event;
	}

}
