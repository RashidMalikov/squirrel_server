package mobi.model.events;

public class ObjectEvent {

    private Events events;

    public ObjectEvent(Events events) {
        this.events = events;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }
}
