// generated with ast extension for cup
// version 0.8
// 7/1/2023 2:0:43


package rs.ac.bg.etf.pp1.ast;

public class VarDecLastListElementClass extends VarDecList {

    private VarDecLastElement VarDecLastElement;

    public VarDecLastListElementClass (VarDecLastElement VarDecLastElement) {
        this.VarDecLastElement=VarDecLastElement;
        if(VarDecLastElement!=null) VarDecLastElement.setParent(this);
    }

    public VarDecLastElement getVarDecLastElement() {
        return VarDecLastElement;
    }

    public void setVarDecLastElement(VarDecLastElement VarDecLastElement) {
        this.VarDecLastElement=VarDecLastElement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDecLastElement!=null) VarDecLastElement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDecLastElement!=null) VarDecLastElement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDecLastElement!=null) VarDecLastElement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDecLastListElementClass(\n");

        if(VarDecLastElement!=null)
            buffer.append(VarDecLastElement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDecLastListElementClass]");
        return buffer.toString();
    }
}
