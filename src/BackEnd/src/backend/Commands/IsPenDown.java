package backend.Commands;

import backend.Turtle;
import backend.Storage.Storage;

import java.util.List;

public class IsPenDown extends RootNode {
    public IsPenDown(Storage storage, Turtle turtle, List<Node> children) {
        super(storage, turtle, children);
    }

    @Override
    public Object run() {
        return myTurtle.getIsPenDown();
    }
}