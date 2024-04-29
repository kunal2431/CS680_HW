package umbcs680.fssortlambda.fs;

public interface FSVisitor{
    void visit(Link link);
    void visit(Directory dir);
    void visit(File file);
}
