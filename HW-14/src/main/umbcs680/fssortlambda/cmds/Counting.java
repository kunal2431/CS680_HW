package umbcs680.fssortlambda.cmds;
import umbcs680.fssortlambda.fs.*;
import umbcs680.fssortlambda.util.*;

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
