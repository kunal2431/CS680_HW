package umbcs680.fssort.fs;

import java.util.LinkedList;

public interface FSCommand<T>{

    LinkedList<T> execute();
}
