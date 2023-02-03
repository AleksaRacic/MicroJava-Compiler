// generated with ast extension for cup
// version 0.8
// 3/1/2023 1:47:18


package rs.ac.bg.etf.pp1.ast;

public class ForEachStatementClass extends Statement {

    private Designator Designator;
    private String feIdent;
    private Statement Statement;

    public ForEachStatementClass (Designator Designator, String feIdent, Statement Statement) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.feIdent=feIdent;
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public String getFeIdent() {
        return feIdent;
    }

    public void setFeIdent(String feIdent) {
        this.feIdent=feIdent;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForEachStatementClass(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+feIdent);
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForEachStatementClass]");
        return buffer.toString();
    }
}
