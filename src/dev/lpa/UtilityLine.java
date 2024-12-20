package dev.lpa;

enum UtilityType {ELECTRICAL, FIBRE_OPTIC, GAS, WATER}

public class UtilityLine implements Mappable {

    private String name;
    private UtilityType utility;

    public UtilityLine(String name, UtilityType utility) {
        this.name = name;
        this.utility = utility;
    }

    @Override
    public String getLabel() {
        return name + "(" + utility + ")";
    }

    @Override
    public String getMarker() {
        return switch (utility) {
            case ELECTRICAL -> Color.RED + " " + LineMarkers.DASHED;
            case FIBRE_OPTIC -> Color.GREEN + " " + LineMarkers.DOTTED;
            case GAS -> Color.ORANGE + " " + LineMarkers.SOLID;
            case WATER -> Color.BLUE + " " + LineMarkers.SOLID;
            default ->   Color.BLACK + " " + LineMarkers.SOLID;
        };
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                , "name": "%s", "utility": "%s" """.formatted(name, utility);
    }
}
