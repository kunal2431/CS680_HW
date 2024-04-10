package umbcs680.command.cmds;
import umbcs680.command.fs.*;
import umbcs680.command.util.*;

import java.util.LinkedList;

public class FileCrawling implements FSCommand{

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
