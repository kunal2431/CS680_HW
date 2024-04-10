package umbcs680.command.util;
import umbcs680.command.fs.*;

import java.util.LinkedList;

public class CountingVisitor implements FSVisitor{

    private int dirNum = 0;
    private int fileNum = 0;
    private int linkNum = 0;

    private LinkedList<File> num = new LinkedList<File>();

    public CountingVisitor(){}

    @Override
    public void visit(Link link) {
        linkNum++;
    }

    @Override
    public void visit(Directory dir) {
        dirNum++;
    }

    @Override
    public void visit(File file) {
        fileNum++;
    }

    public int getDirNum(){
        return dirNum;
    }

    public int getFileNum(){
        return fileNum;
    }

    public int getLinkNum(){
        return linkNum;
    }

    public LinkedList<File> getCounting(){
        num.add(new File(null, "null", dirNum, null));
        num.add(new File(null, "null", fileNum, null));
        num.add(new File(null, "null", linkNum, null));
        return num;
    }
}
