package umbcs680.transportation.util;
import umbcs680.transportation.ts.*;

public class CountingVisitor implements TPVisitor{

    private int modNum = 0;
    private int carrNum = 0;
    private int linkNum = 0;

    public CountingVisitor(){}

    @Override
    public void visit(Link link) {
        linkNum++;
    }

    @Override
    public void visit(Mode dir) {
        modNum++;
    }

    @Override
    public void visit(Carrier file) {
        carrNum++;
    }

    public int getModNum(){
        return modNum;
    }

    public int getCarrNum(){
        return carrNum;
    }

    public int getLinkNum(){
        return linkNum;
    }
}
