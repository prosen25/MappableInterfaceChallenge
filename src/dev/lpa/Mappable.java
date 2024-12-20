package dev.lpa;

enum Geometry {LINE, POINT, POLYGON}
enum Color {BLACK, BLUE, GREEN, ORANGE, RED}
enum PointMarkers {CIRCLE, PUSH_PIN, STAR, SQUARE, TRIANGLE}
enum LineMarkers {DASHED, DOTTED, SOLID}

public interface Mappable {

    String JSON_PROPERTY = """
            "properties": {%s}""";

    String getLabel();
    String getMarker();
    Geometry getShape();

    default String toJSON() {
        return """
                "type": "%s", "label": "%s", "marker": "%s" """.formatted(getShape(), getLabel(), getMarker());
    }

    static void mapIt(Mappable mappable) {
        System.out.printf(JSON_PROPERTY + "%n", mappable.toJSON());
    }
}
