package umbcs680.proxy;

import java.time.LocalDateTime;

public class File extends FSElement{

    public File(Directory parent, String name, int size, LocalDateTime creationTime){
        super(parent, name, size, creationTime);
    }

    public boolean isDirectory() {
        return false;
    }

    public boolean isLink() {
        return false;
    }

}