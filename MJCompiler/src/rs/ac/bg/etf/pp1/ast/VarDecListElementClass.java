// generated with ast extension for cup
// version 0.8
// 2/1/2023 20:40:20


package rs.ac.bg.etf.pp1.ast;

public class VarDecListElementClass extends VarDecList {

    private VarDecElement VarDecElement;
    private VarDecList VarDecList;

    public VarDecListElementClass (VarDecElement VarDecElement, VarDecList VarDecList) {
        this.VarDecElement=VarDecElement;
        if(VarDecElement!=null) VarDecElement.setParent(this);
        this.VarDecList=VarDecList;
        if(VarDecList!=null) VarDecList.setParent(this);
    }

    public VarDecElement getVarDecElement() {
        return VarDecElement;
    }

    public void setVarDecElement(VarDecElement VarDecElement) {
        this.VarDecElement=VarDecElement;
    }

    public VarDecList getVarDecList() {
        return VarDecList;
    }

    public void setVarDecList(VarDecList VarDecList) {
        this.VarDecList=VarDecList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDecElement!=null) VarDecElement.accept(visitor);
        if(VarDecList!=null) VarDecList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDecElement!=null) VarDecElement.traverseTopDown(visitor);
        if(VarDecList!=null) VarDecList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDecElement!=null) VarDecElement.traverseBottomUp(visitor);
        if(VarDecList!=null) VarDecList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDecListElementClass(\n");

        if(VarDecElement!=null)
            buffer.append(VarDecElement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecList!=null)
            buffer.append(VarDecList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDecListElementClass]");
        return buffer.toString();
    }
}
