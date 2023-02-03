// generated with ast extension for cup
// version 0.8
// 3/1/2023 1:47:18


package rs.ac.bg.etf.pp1.ast;

public class NumberFactorClass extends Factor {

    private Integer NumValue;

    public NumberFactorClass (Integer NumValue) {
        this.NumValue=NumValue;
    }

    public Integer getNumValue() {
        return NumValue;
    }

    public void setNumValue(Integer NumValue) {
        this.NumValue=NumValue;
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
        buffer.append("NumberFactorClass(\n");

        buffer.append(" "+tab+NumValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NumberFactorClass]");
        return buffer.toString();
    }
}
