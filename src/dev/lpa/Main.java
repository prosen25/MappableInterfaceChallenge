package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Mappable> mappables = new ArrayList<>();

        // Building
        mappables.add(new Building("Sydney Town Hall", UsageType.GOVERNMENT));
        mappables.add(new Building("Sydney Opera House", UsageType.ENTERTAINMENT));
        mappables.add(new Building("Stadium Australia", UsageType.SPORTS));

        // Utility Line
        mappables.add(new UtilityLine("College St", UtilityType.FIBRE_OPTIC));
        mappables.add(new UtilityLine("Olympic Blvd", UtilityType.WATER));

        for (var mappable : mappables) {
            Mappable.mapIt(mappable);
        }
    }
}