package umbcs680.visitor;

import java.util.LinkedList;

interface FSVisitor{
    void visit(Link link);
    void visit(Directory dir);
    void visit(File file);
}

class CountingVisitor implements FSVisitor{

    private int dirNum = 0;
    private int fileNum = 0;
    private int linkNum = 0;

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
}

class FileCrawlingVisitor implements FSVisitor{

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

class FileSearchVisitor implements FSVisitor{

    private String fileName;

    protected LinkedList<File> foundFiles = new LinkedList<File>();

    public FileSearchVisitor(String fileName){
        this.fileName = fileName;
    }

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
        if(file.getName().equals(fileName)){
            foundFiles.add(file); }
    }

    public LinkedList<File> getFoundFiles(){
        return foundFiles;
    }
}