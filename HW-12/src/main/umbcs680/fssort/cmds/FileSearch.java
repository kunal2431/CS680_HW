package umbcs680.fssort.cmds;
import umbcs680.fssort.fs.*;
import umbcs680.fssort.util.*;

import java.util.LinkedList;

public class FileSearch implements FSCommand<File>{

    private FSElement fElement;
    private String fileName;

    public FileSearch(FSElement fElement, String fileName){
        this.fElement = fElement;
        this.fileName = fileName;
    }

    public void changeSearchDirectory(FSElement fElement){
        this.fElement = fElement;
    }

    @Override
    public LinkedList<File> execute() {
        FileSearchVisitor visitor = new FileSearchVisitor(fileName);
        fElement.accept(visitor);
        return visitor.getFoundFiles();
    }
}
