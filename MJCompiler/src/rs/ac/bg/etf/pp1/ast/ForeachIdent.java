// generated with ast extension for cup
// version 0.8
// 7/1/2023 2:0:43


package rs.ac.bg.etf.pp1.ast;

public class ForeachIdent implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private String feIdent;

    public ForeachIdent (String feIdent) {
        this.feIdent=feIdent;
    }

    public String getFeIdent() {
        return feIdent;
    }

    public void setFeIdent(String feIdent) {
        this.feIdent=feIdent;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
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
        buffer.append("ForeachIdent(\n");

        buffer.append(" "+tab+feIdent);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForeachIdent]");
        return buffer.toString();
    }
}
