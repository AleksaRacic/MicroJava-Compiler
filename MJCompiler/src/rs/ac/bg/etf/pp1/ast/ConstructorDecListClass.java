// generated with ast extension for cup
// version 0.8
// 7/1/2023 2:0:43


package rs.ac.bg.etf.pp1.ast;

public class ConstructorDecListClass extends ConstructorDecList {

    private ConstructorDecList ConstructorDecList;
    private ConstructorDecl ConstructorDecl;

    public ConstructorDecListClass (ConstructorDecList ConstructorDecList, ConstructorDecl ConstructorDecl) {
        this.ConstructorDecList=ConstructorDecList;
        if(ConstructorDecList!=null) ConstructorDecList.setParent(this);
        this.ConstructorDecl=ConstructorDecl;
        if(ConstructorDecl!=null) ConstructorDecl.setParent(this);
    }

    public ConstructorDecList getConstructorDecList() {
        return ConstructorDecList;
    }

    public void setConstructorDecList(ConstructorDecList ConstructorDecList) {
        this.ConstructorDecList=ConstructorDecList;
    }

    public ConstructorDecl getConstructorDecl() {
        return ConstructorDecl;
    }

    public void setConstructorDecl(ConstructorDecl ConstructorDecl) {
        this.ConstructorDecl=ConstructorDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstructorDecList!=null) ConstructorDecList.accept(visitor);
        if(ConstructorDecl!=null) ConstructorDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstructorDecList!=null) ConstructorDecList.traverseTopDown(visitor);
        if(ConstructorDecl!=null) ConstructorDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstructorDecList!=null) ConstructorDecList.traverseBottomUp(visitor);
        if(ConstructorDecl!=null) ConstructorDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstructorDecListClass(\n");

        if(ConstructorDecList!=null)
            buffer.append(ConstructorDecList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstructorDecl!=null)
            buffer.append(ConstructorDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstructorDecListClass]");
        return buffer.toString();
    }
}
