package umbcs680.composite;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement{

    protected LinkedList<FSElement> children = new LinkedList<FSElement>();
    protected LinkedList<Directory> directories = new LinkedList<Directory>();
    protected LinkedList<File> files = new LinkedList<File>();
    public Directory(Directory parent, String name, int size, LocalDateTime creationTime){
        super(parent, name, 0, creationTime);
    }

    public LinkedList<FSElement> getChildren(){return this.children;}

    public void appendChild(FSElement child){
        this.children.add(child);
        child.setParent(this);
    }

    public int countChildren(){
        return this.children.size();
    }

    public LinkedList<Directory> getSubDirectories(){
        directories.clear();
        for(FSElement child: children ){
            if(child.isDirectory() == true){
                this.directories.add((Directory) child);
                this.directories.addAll(((Directory) child).getSubDirectories());
            }
        }
        return this.directories;
    }

    public LinkedList<File> getFiles(){
        files.clear();
        for(FSElement child: children ){
            if(child.isDirectory() == false){
                this.files.add((File) child);
            }
        }
        return this.files;
    }

    public int getTotalSize(){
        int size=0;
        for (FSElement child : children) {
            if (child.isDirectory() == true) {
                size = size + ((Directory) child).getTotalSize();
            } else {
                size = size + child.getSize();
            }
        }
        return size;
    }

    public boolean isDirectory() {
        return true;
    }

}
