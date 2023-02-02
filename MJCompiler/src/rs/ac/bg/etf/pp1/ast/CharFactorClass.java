// generated with ast extension for cup
// version 0.8
// 2/1/2023 20:40:20


package rs.ac.bg.etf.pp1.ast;

public class CharFactorClass extends Factor {

    private Character CharValue;

    public CharFactorClass (Character CharValue) {
        this.CharValue=CharValue;
    }

    public Character getCharValue() {
        return CharValue;
    }

    public void setCharValue(Character CharValue) {
        this.CharValue=CharValue;
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
        buffer.append("CharFactorClass(\n");

        buffer.append(" "+tab+CharValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CharFactorClass]");
        return buffer.toString();
    }
}
