package backend;

import backend.Commands.LeafNode;
import backend.Commands.Node;
import backend.Storage.Storage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author Jose San Martin, Henry Xie
 * A controller class that performs reflection on a list of trees to move the turtle.
 */
public class ModelController {
    private Interpreter interpreter;
    private List<Node> myCommands;
    private List<Map.Entry<String, Pattern>> mySymbols;
    private TurtleGroup myTurtle;
    private TreeFactory myTreeFactory;
    private boolean hasNewVar;
    private boolean hasNewFunc;
    private Storage myStorage;

    public ModelController(TurtleGroup turtle, List<Map.Entry<String, Pattern>> symbolList) {
        mySymbols = symbolList;
        interpreter = new Interpreter(symbolList);
        //commander = new Command(this, turtle);
        myTurtle = turtle;
//        myReflector = new Reflector(myTurtle);
        myTreeFactory = new TreeFactory(myTurtle);
        this.myStorage = new Storage();
    }

    /**
     * Parses the Command
     */
    public void parseCommand(String input) throws Exception {
        //returns a list of root nodes. e.g. [Forward, 50]
        List<String> commands = interpreter.parse(input);
        //Turn our command arraylist into a tree structure of command nodes
        myCommands = myTreeFactory.getRoots(commands);
        System.out.println("My turtle before running command: " + myTurtle.getTurtleLeaf(0));
        for (Node node : myCommands) {
            node.run();
        }
        myTurtle.Changed();
        myTurtle.notifyObservers();
        myTurtle.clear();
    }


    private boolean isNumeric(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+");
    }

    public Map<String, String> updateVar() {
        return myStorage.getVarMap();
    }

    public Map<String, String> updateFunc() {
//        return myStorage.getInsList();
        return new HashMap<String, String>();
    }

}

