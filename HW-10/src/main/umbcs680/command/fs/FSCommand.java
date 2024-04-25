package umbcs680.command.fs;

import java.util.LinkedList;

public interface FSCommand<T>{

    LinkedList<T> execute();
}
