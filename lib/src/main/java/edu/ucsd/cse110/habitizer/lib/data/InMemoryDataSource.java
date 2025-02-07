package edu.ucsd.cse110.habitizer.lib.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.ucsd.cse110.habitizer.lib.domain.Routine;
import edu.ucsd.cse110.habitizer.lib.domain.RoutineTask;

public class InMemoryDataSource {
    private final Map<String, Routine> routines = new HashMap<>();

    public InMemoryDataSource() {};

    public void initializeDefaultRoutine() {
        Routine DEFAULT_ROUTINE = new Routine("Test Routine",
                List.of(
                        new RoutineTask("Wake Up", 1, false),
                        new RoutineTask("Eat Breakfast", 2, false),
                        new RoutineTask("Brush Teeth", 3, false)
                ));

        routines.put(DEFAULT_ROUTINE.title(), DEFAULT_ROUTINE);
    }

    public static InMemoryDataSource fromDefault() {
        var data = new InMemoryDataSource();
        data.initializeDefaultRoutine();
        return data;
    }

    public Routine routine(String name) { return routines.get(name); }

}
