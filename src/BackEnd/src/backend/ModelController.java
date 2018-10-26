package backend;

import backend.Commands.LeafNode;
import backend.Commands.Node;

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
    private Turtle myTurtle;
    //private Reflector myReflector;
    private TreeFactory myTreeFactory;

    private Map<String, LeafNode> variableMap = new HashMap<>();
    private Map<String, Node> instructionMap = new HashMap<>();
    private boolean hasNewVar;
    private Map<String, String> newVar;
    private boolean hasNewFunc;
    private Map<String, String> newFunc;

    public ModelController(Turtle turtle, List<Map.Entry<String, Pattern>> symbolList) {
        mySymbols = symbolList;
        interpreter = new Interpreter(symbolList);
        //commander = new Command(this, turtle);
        myTurtle = turtle;
       // myReflector = new Reflector(myTurtle);
        myTreeFactory = new TreeFactory(myTurtle);
    }

    /**
     * Parses the Command
     */
    public void parseCommand(String input) throws Exception {
        List<String> commands = interpreter.parse(input); //returns a list of root nodes
        //Turn our command arraylist into a tree structure of command nodes
        myCommands = myTreeFactory.getRoots(commands);
        for (Node node : myCommands) {
            System.out.println(node.getClass());

        }
            //We might not need tree factory anymore
            //for (BasicNode node : myCommands) {
            //    myReflector.execute(node);
            //}
            myTurtle.Changed();
            //myTurtle.notifyObservers(true);
            myTurtle.clear();

    }


    private boolean isNumeric(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+");
    }

    public Map<String, String> updateVar() {
        if (hasNewVar) {
            hasNewVar = !hasNewVar;
            return newVar;
        } else return new HashMap<>();
    }

    public Map<String, String> updateFunc() {
        if (hasNewFunc) {
            hasNewFunc = !hasNewFunc;
            return newFunc;
        } else return new HashMap<>();
    }

}

