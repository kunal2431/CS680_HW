package umbcs680.internalfs.cmds;
import umbcs680.internalfs.fs.*;
import umbcs680.internalfs.util.*;

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
