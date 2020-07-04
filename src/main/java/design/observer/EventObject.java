package design.observer;

public class EventObject {
    private Source source;

    public EventObject(Source source, String eventName) {
        this.source = source;
        this.eventName = eventName;
    }

    private String eventName;
    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
