// generated with ast extension for cup
// version 0.8
// 2/1/2023 20:40:20


package rs.ac.bg.etf.pp1.ast;

public class ClassBodyAllClass extends ClassBody {

    private ListOfVarDecl ListOfVarDecl;
    private ConstructorDecList ConstructorDecList;
    private MethodDecList MethodDecList;

    public ClassBodyAllClass (ListOfVarDecl ListOfVarDecl, ConstructorDecList ConstructorDecList, MethodDecList MethodDecList) {
        this.ListOfVarDecl=ListOfVarDecl;
        if(ListOfVarDecl!=null) ListOfVarDecl.setParent(this);
        this.ConstructorDecList=ConstructorDecList;
        if(ConstructorDecList!=null) ConstructorDecList.setParent(this);
        this.MethodDecList=MethodDecList;
        if(MethodDecList!=null) MethodDecList.setParent(this);
    }

    public ListOfVarDecl getListOfVarDecl() {
        return ListOfVarDecl;
    }

    public void setListOfVarDecl(ListOfVarDecl ListOfVarDecl) {
        this.ListOfVarDecl=ListOfVarDecl;
    }

    public ConstructorDecList getConstructorDecList() {
        return ConstructorDecList;
    }

    public void setConstructorDecList(ConstructorDecList ConstructorDecList) {
        this.ConstructorDecList=ConstructorDecList;
    }

    public MethodDecList getMethodDecList() {
        return MethodDecList;
    }

    public void setMethodDecList(MethodDecList MethodDecList) {
        this.MethodDecList=MethodDecList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListOfVarDecl!=null) ListOfVarDecl.accept(visitor);
        if(ConstructorDecList!=null) ConstructorDecList.accept(visitor);
        if(MethodDecList!=null) MethodDecList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListOfVarDecl!=null) ListOfVarDecl.traverseTopDown(visitor);
        if(ConstructorDecList!=null) ConstructorDecList.traverseTopDown(visitor);
        if(MethodDecList!=null) MethodDecList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListOfVarDecl!=null) ListOfVarDecl.traverseBottomUp(visitor);
        if(ConstructorDecList!=null) ConstructorDecList.traverseBottomUp(visitor);
        if(MethodDecList!=null) MethodDecList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassBodyAllClass(\n");

        if(ListOfVarDecl!=null)
            buffer.append(ListOfVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstructorDecList!=null)
            buffer.append(ConstructorDecList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDecList!=null)
            buffer.append(MethodDecList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassBodyAllClass]");
        return buffer.toString();
    }
}
