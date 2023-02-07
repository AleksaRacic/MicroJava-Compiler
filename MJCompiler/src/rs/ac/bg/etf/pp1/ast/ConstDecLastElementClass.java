// generated with ast extension for cup
// version 0.8
// 7/1/2023 2:0:43


package rs.ac.bg.etf.pp1.ast;

public class ConstDecLastElementClass extends ConstDecList {

    private ConstDecLastElement ConstDecLastElement;

    public ConstDecLastElementClass (ConstDecLastElement ConstDecLastElement) {
        this.ConstDecLastElement=ConstDecLastElement;
        if(ConstDecLastElement!=null) ConstDecLastElement.setParent(this);
    }

    public ConstDecLastElement getConstDecLastElement() {
        return ConstDecLastElement;
    }

    public void setConstDecLastElement(ConstDecLastElement ConstDecLastElement) {
        this.ConstDecLastElement=ConstDecLastElement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDecLastElement!=null) ConstDecLastElement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDecLastElement!=null) ConstDecLastElement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDecLastElement!=null) ConstDecLastElement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDecLastElementClass(\n");

        if(ConstDecLastElement!=null)
            buffer.append(ConstDecLastElement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDecLastElementClass]");
        return buffer.toString();
    }
}
