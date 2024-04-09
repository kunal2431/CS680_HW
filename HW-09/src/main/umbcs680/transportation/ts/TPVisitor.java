package umbcs680.transportation.ts;

public interface TPVisitor{
    void visit(Link link);
    void visit(Mode mode);
    void visit(Carrier carrier);
}
