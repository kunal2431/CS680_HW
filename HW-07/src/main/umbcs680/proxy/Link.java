package umbcs680.proxy;

import java.time.LocalDateTime;

public class Link extends FSElement{

    private FSElement target;

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target){
        super(parent, name, 0, creationTime);
        this.target = target;
    }

    public boolean isDirectory() {
        return false;
    }

    public boolean isLink() {
        return true;
    }

    public FSElement getLinkTarget(){
        return this.target;
    }

}