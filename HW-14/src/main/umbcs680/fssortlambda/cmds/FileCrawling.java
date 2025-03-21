package umbcs680.fssortlambda.cmds;
import umbcs680.fssortlambda.fs.*;
import umbcs680.fssortlambda.util.*;

import java.util.LinkedList;

public class FileCrawling implements FSCommand<File>{

    private FSElement fElement;

    public FileCrawling(FSElement fElement){
        this.fElement = fElement;
    }

    public void changeCrawlDirectory(FSElement fElement){
        this.fElement = fElement;
    }

    @Override
    public LinkedList<File> execute() {
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        fElement.accept(visitor);
        return visitor.getFiles();
    }
}
