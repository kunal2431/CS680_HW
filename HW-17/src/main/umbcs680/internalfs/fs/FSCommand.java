package umbcs680.internalfs.fs;

import java.util.LinkedList;

public interface FSCommand<T>{

    LinkedList<T> execute();
}
