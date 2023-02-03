// generated with ast extension for cup
// version 0.8
// 3/1/2023 1:47:18


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclClass extends ConstDecl {

    private Type Type;
    private ConstDecList ConstDecList;

    public ConstDeclClass (Type Type, ConstDecList ConstDecList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ConstDecList=ConstDecList;
        if(ConstDecList!=null) ConstDecList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ConstDecList getConstDecList() {
        return ConstDecList;
    }

    public void setConstDecList(ConstDecList ConstDecList) {
        this.ConstDecList=ConstDecList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ConstDecList!=null) ConstDecList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstDecList!=null) ConstDecList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstDecList!=null) ConstDecList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclClass(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDecList!=null)
            buffer.append(ConstDecList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclClass]");
        return buffer.toString();
    }
}
