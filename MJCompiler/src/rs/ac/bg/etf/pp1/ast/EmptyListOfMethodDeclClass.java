// generated with ast extension for cup
// version 0.8
// 2/1/2023 20:40:20


package rs.ac.bg.etf.pp1.ast;

public class EmptyListOfMethodDeclClass extends ListOfMethodDecl {

    public EmptyListOfMethodDeclClass () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EmptyListOfMethodDeclClass(\n");

        buffer.append(tab);
        buffer.append(") [EmptyListOfMethodDeclClass]");
        return buffer.toString();
    }
}
