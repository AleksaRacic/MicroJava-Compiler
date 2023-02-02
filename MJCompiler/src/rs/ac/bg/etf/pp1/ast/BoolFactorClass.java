// generated with ast extension for cup
// version 0.8
// 2/1/2023 20:40:20


package rs.ac.bg.etf.pp1.ast;

public class BoolFactorClass extends Factor {

    private Boolean BoolValue;

    public BoolFactorClass (Boolean BoolValue) {
        this.BoolValue=BoolValue;
    }

    public Boolean getBoolValue() {
        return BoolValue;
    }

    public void setBoolValue(Boolean BoolValue) {
        this.BoolValue=BoolValue;
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
        buffer.append("BoolFactorClass(\n");

        buffer.append(" "+tab+BoolValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BoolFactorClass]");
        return buffer.toString();
    }
}
