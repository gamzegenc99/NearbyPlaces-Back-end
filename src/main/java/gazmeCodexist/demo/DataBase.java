package gazmeCodexist.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class DataBase {
    private final Map<String,List<String>> database= new HashMap<>();

    public Map<String, List<String>> getDatabase() {
        return database;
    }
    



}