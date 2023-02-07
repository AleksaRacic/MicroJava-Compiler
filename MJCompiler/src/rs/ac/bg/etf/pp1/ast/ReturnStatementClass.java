// generated with ast extension for cup
// version 0.8
// 7/1/2023 2:0:43


package rs.ac.bg.etf.pp1.ast;

public class ReturnStatementClass extends Statement {

    public ReturnStatementClass () {
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
        buffer.append("ReturnStatementClass(\n");

        buffer.append(tab);
        buffer.append(") [ReturnStatementClass]");
        return buffer.toString();
    }
}
