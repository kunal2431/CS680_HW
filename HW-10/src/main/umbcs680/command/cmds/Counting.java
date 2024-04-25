package umbcs680.command.cmds;
import umbcs680.command.fs.*;
import umbcs680.command.util.*;

import java.util.LinkedList;

public class Counting implements FSCommand<Integer>{

    private FSElement fElement;
    public Counting(FSElement fElement){
        this.fElement = fElement;
    }

    @Override
    public LinkedList<Integer> execute(){
        CountingVisitor visitor = new CountingVisitor();
        fElement.accept(visitor);
        return visitor.getCounting();
    }
}
