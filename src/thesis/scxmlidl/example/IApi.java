package thesis.scxmlidl.example;

public interface IApi {
public void start();
public void read(String path);
public void fireEvent(Event event);
public void addMonitor(SimpleMonitor monitor);
}
