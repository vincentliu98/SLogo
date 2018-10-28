package backend.Commands;

import backend.Turtle;
import backend.Storage.Storage;

import java.util.ArrayList;
import java.util.List;

abstract public class RootNode implements Node{

    protected List<Node> myChildren;
    protected Turtle myTurtle;
    protected Storage myStorage;

    public RootNode(Storage storage, Turtle turtle, List<Node> children){
        this.myChildren = children;
        this.myTurtle = turtle;
        this.myStorage = storage;
    }

    @Override
    public void addChild(Node child) {
        myChildren.add(child);
    }

    @Override
    public int getNumChildren() {
        return myChildren.size();
    }

    @Override
    public abstract Object run();

    protected List<Object> runChildren(){
        List<Object> oList = new ArrayList<>();
        for(Node c: myChildren){
            oList.add(c.run());
        }
        return oList;
    }

    protected List<Double> parseDoubles(List<Object> l){
        List<Double> res = new ArrayList<>();
        for(Object o: l){
            res.add((double) o);
        }
        return res;
    }

    protected List<Integer> parseIntegers(List<Double> doubles){
        List<Integer> res = new ArrayList<>();
        for(Double d: doubles){
            res.add(d.intValue());
        }
        return res;
    }

}
