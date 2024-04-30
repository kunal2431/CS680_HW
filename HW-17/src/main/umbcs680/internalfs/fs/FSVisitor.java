package umbcs680.internalfs.fs;

public interface FSVisitor{
    void visit(Link link);
    void visit(Directory dir);
    void visit(File file);
}
