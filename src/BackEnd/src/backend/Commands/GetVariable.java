package backend.Commands;

import backend.Turtle;
import backend.Storage.Storage;

import java.util.List;

public class GetVariable extends RootNode {

    public GetVariable(Storage storage, Turtle turtle, List<Node> children) {
        super(storage, turtle, children);
    }

    @Override
    public Object run() {
        List<Object> l = runChildren();
        return myStorage.getVar((String) l.get(0));
    }
}