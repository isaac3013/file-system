import java.util.ArrayList;
import java.util.List;

public class Journal {
    private List<String> log = new ArrayList<>();

    public void addEntry(String entry) {
        log.add(entry);
    }

    public List<String> getLog() {
        return log;
    }
}
