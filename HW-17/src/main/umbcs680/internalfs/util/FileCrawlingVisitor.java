package umbcs680.internalfs.util;
import umbcs680.internalfs.fs.*;

import java.util.LinkedList;

public class FileCrawlingVisitor implements FSVisitor{

    protected LinkedList<File> files_visitor = new LinkedList<File>();

    public FileCrawlingVisitor(){}

    @Override
    public void visit(Link link) {
        return;
    }

    @Override
    public void visit(Directory dir) {
        return;
    }

    @Override
    public void visit(File file) {
        files_visitor.add(file);
    }

    public LinkedList<File> getFiles(){
        return files_visitor;
    }
}
