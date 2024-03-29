// generated with ast extension for cup
// version 0.8
// 7/1/2023 2:0:43


package rs.ac.bg.etf.pp1.ast;

public class ListOfMethodDeclClass extends ListOfMethodDecl {

    private ListOfMethodDecl ListOfMethodDecl;
    private MethodDecl MethodDecl;

    public ListOfMethodDeclClass (ListOfMethodDecl ListOfMethodDecl, MethodDecl MethodDecl) {
        this.ListOfMethodDecl=ListOfMethodDecl;
        if(ListOfMethodDecl!=null) ListOfMethodDecl.setParent(this);
        this.MethodDecl=MethodDecl;
        if(MethodDecl!=null) MethodDecl.setParent(this);
    }

    public ListOfMethodDecl getListOfMethodDecl() {
        return ListOfMethodDecl;
    }

    public void setListOfMethodDecl(ListOfMethodDecl ListOfMethodDecl) {
        this.ListOfMethodDecl=ListOfMethodDecl;
    }

    public MethodDecl getMethodDecl() {
        return MethodDecl;
    }

    public void setMethodDecl(MethodDecl MethodDecl) {
        this.MethodDecl=MethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListOfMethodDecl!=null) ListOfMethodDecl.accept(visitor);
        if(MethodDecl!=null) MethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListOfMethodDecl!=null) ListOfMethodDecl.traverseTopDown(visitor);
        if(MethodDecl!=null) MethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListOfMethodDecl!=null) ListOfMethodDecl.traverseBottomUp(visitor);
        if(MethodDecl!=null) MethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListOfMethodDeclClass(\n");

        if(ListOfMethodDecl!=null)
            buffer.append(ListOfMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDecl!=null)
            buffer.append(MethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListOfMethodDeclClass]");
        return buffer.toString();
    }
}
