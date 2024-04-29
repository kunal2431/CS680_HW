package umbcs680.fssortlambda.fs;

import java.util.LinkedList;

public interface FSCommand<T>{

    LinkedList<T> execute();
}
