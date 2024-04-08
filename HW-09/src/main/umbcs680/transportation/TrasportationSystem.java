package umbcs680.transportation;

import java.util.LinkedList;
import java.util.Objects;

public class TrasportationSystem{

    protected LinkedList<Mode> Mode_root = new LinkedList<Mode>();

    private static TrasportationSystem instance = null;

    private TrasportationSystem(){
        }

    public static TrasportationSystem getTransportationSystem(){
        try{
            return Objects.requireNonNull(instance);
        }
        catch(NullPointerException ex){
            instance = new TrasportationSystem();
            return instance;
        }
    }

    public LinkedList<Mode> getRootMode(){return this.Mode_root;}

    public void appendRootMode(Mode root){
        this.Mode_root.add(root);
    }
}