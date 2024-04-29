package umbcs680.fssortlambda.fs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Directory extends FSElement{

    protected LinkedList<FSElement> children = new LinkedList<FSElement>();
    protected LinkedList<Directory> directories = new LinkedList<Directory>();
    protected LinkedList<File> files = new LinkedList<File>();

    protected LinkedList<Link> links = new LinkedList<Link>();

    private Comparator<FSElement> AlphabeticalComparator = (FSElement fs1, FSElement fs2)->{return fs1.getName().compareTo(fs2.getName());};

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime){
        super(parent, name, 0, creationTime);
    }

    public LinkedList<FSElement> getChildren(){
        Collections.sort(this.children, AlphabeticalComparator);
        return this.children;
    }

    public LinkedList<FSElement> getChildren(Comparator<FSElement> policy){
        Collections.sort(this.children, policy);
        return this.children;
    }

    public void appendChild(FSElement child){
        this.children.add(child);
        child.setParent(this);
    }

    public int countChildren(){
        return this.children.size();
    }

    public LinkedList<Directory> getSubDirectories(){
        directories.clear();
        for(FSElement child: children){
            if(child.isDirectory() == true){
                this.directories.add((Directory) child);
                this.directories.addAll(((Directory) child).getSubDirectories());
            }
        }
        Collections.sort(this.directories, AlphabeticalComparator);
        return this.directories;
    }

    public LinkedList<Directory> getSubDirectories(Comparator<FSElement> policy){
        directories.clear();
        for(FSElement child: children ){
            if(child.isDirectory() == true){
                this.directories.add((Directory) child);
                this.directories.addAll(((Directory) child).getSubDirectories());
            }
        }
        Collections.sort(this.directories, policy);
        return this.directories;
    }

    public LinkedList<File> getFiles(){
        files.clear();
        for(FSElement child: children ){
            if(child.isDirectory() == false && child.isLink() == false){
                this.files.add((File) child);
            }
        }
        Collections.sort(this.files, AlphabeticalComparator);
        return this.files;
    }

    public LinkedList<File> getFiles(Comparator<FSElement> policy){
        files.clear();
        for(FSElement child: children ){
            if(child.isDirectory() == false && child.isLink() == false){
                this.files.add((File) child);
            }
        }
        Collections.sort(this.files, policy);
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

    public boolean isLink() {
        return false;
    }

    public LinkedList<Link> getLink(){
        links.clear();
        for(FSElement child: children){
            if(child.isLink() == true){
                this.links.add((Link) child);
            }
        }
        Collections.sort(this.links, AlphabeticalComparator);
        return this.links;
    }

    public LinkedList<Link> getLink(Comparator<FSElement> policy){
        links.clear();
        for(FSElement child: children){
            if(child.isLink() == true){
                this.links.add((Link) child);
            }
        }
        Collections.sort(this.files, policy);
        return this.links;
    }

    public void accept(FSVisitor v) {
        v.visit(this);
        for (FSElement e: children){
            e.accept(v);
        }
    }

}