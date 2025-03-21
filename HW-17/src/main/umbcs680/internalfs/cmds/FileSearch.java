package umbcs680.internalfs.cmds;
import umbcs680.internalfs.fs.*;
import umbcs680.internalfs.util.*;

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
