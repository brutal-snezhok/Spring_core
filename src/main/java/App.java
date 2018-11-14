public class App {
    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public App() {

    }

    public static void main(String[] args) {
        Client client = new Client("1", "Dmitry Tsyrulik");
        EventLogger eventLogger = new ConsoleEventLogger();
        App app = new App(client, eventLogger);
        app.logEvent("Some event for user 1");
//        app.client = new Client("1", "Dmitry Tsyrulik");
//        app.eventLogger = new ConsoleEventLogger();
//
//        app.logEvent("Some event for user 1");

    }

    private void logEvent(String msg){
        String message = msg.replace(client.getId(), client.getFullName());
        eventLogger.logEvent(message);
    }
}