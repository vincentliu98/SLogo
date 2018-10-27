package backend.Commands;

import backend.Turtle;
import backend.Storage.Storage;

import java.util.List;

public class Difference extends RootNode {

    public Difference(Storage storage, Turtle turtle, List<Node> children) {
        super(storage, turtle, children);
    }

    @Override
    public Object run() {
        List<Double> l = parseDoubles(runChildren());
        return l.get(0) - l.get(1);
    }
}
