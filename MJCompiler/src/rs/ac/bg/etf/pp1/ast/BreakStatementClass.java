// generated with ast extension for cup
// version 0.8
// 3/1/2023 1:47:18


package rs.ac.bg.etf.pp1.ast;

public class BreakStatementClass extends Statement {

    public BreakStatementClass () {
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
        buffer.append("BreakStatementClass(\n");

        buffer.append(tab);
        buffer.append(") [BreakStatementClass]");
        return buffer.toString();
    }
}
