package umbcs680.fssort.sort;

import umbcs680.fssort.fs.*;
import umbcs680.fssort.cmds.*;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<FSElement>{
    public int compare(FSElement fs1, FSElement fs2){
        return fs1.getName().compareTo(fs2.getName());
    }
}