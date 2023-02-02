// generated with ast extension for cup
// version 0.8
// 2/1/2023 20:40:20


package rs.ac.bg.etf.pp1.ast;

public class ConstDecListElementClass extends ConstDecList {

    private ConstDecElement ConstDecElement;
    private ConstDecList ConstDecList;

    public ConstDecListElementClass (ConstDecElement ConstDecElement, ConstDecList ConstDecList) {
        this.ConstDecElement=ConstDecElement;
        if(ConstDecElement!=null) ConstDecElement.setParent(this);
        this.ConstDecList=ConstDecList;
        if(ConstDecList!=null) ConstDecList.setParent(this);
    }

    public ConstDecElement getConstDecElement() {
        return ConstDecElement;
    }

    public void setConstDecElement(ConstDecElement ConstDecElement) {
        this.ConstDecElement=ConstDecElement;
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
        if(ConstDecElement!=null) ConstDecElement.accept(visitor);
        if(ConstDecList!=null) ConstDecList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDecElement!=null) ConstDecElement.traverseTopDown(visitor);
        if(ConstDecList!=null) ConstDecList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDecElement!=null) ConstDecElement.traverseBottomUp(visitor);
        if(ConstDecList!=null) ConstDecList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDecListElementClass(\n");

        if(ConstDecElement!=null)
            buffer.append(ConstDecElement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDecList!=null)
            buffer.append(ConstDecList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDecListElementClass]");
        return buffer.toString();
    }
}
