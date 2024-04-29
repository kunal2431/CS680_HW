package umbcs680.fssort.sort;

import umbcs680.fssort.cmds.*;
import umbcs680.fssort.fs.*;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<FSElement>{
    public int compare(FSElement fs1, FSElement fs2){
        return fs1.getcreationTime().compareTo(fs2.getcreationTime());
    }
}