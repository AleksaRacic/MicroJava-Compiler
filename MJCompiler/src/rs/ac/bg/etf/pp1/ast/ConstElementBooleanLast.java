// generated with ast extension for cup
// version 0.8
// 3/1/2023 1:47:18


package rs.ac.bg.etf.pp1.ast;

public class ConstElementBooleanLast extends ConstDecLastElement {

    private String constName;
    private Boolean value;

    public ConstElementBooleanLast (String constName, Boolean value) {
        this.constName=constName;
        this.value=value;
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName=constName;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value=value;
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
        buffer.append("ConstElementBooleanLast(\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        buffer.append(" "+tab+value);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstElementBooleanLast]");
        return buffer.toString();
    }
}
