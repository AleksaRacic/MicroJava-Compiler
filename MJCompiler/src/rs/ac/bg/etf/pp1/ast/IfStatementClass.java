// generated with ast extension for cup
// version 0.8
// 7/1/2023 2:0:43


package rs.ac.bg.etf.pp1.ast;

public class IfStatementClass extends Statement {

    private StartIf StartIf;
    private IfCond IfCond;
    private StartIfStatement StartIfStatement;
    private Statement Statement;
    private EndIf EndIf;

    public IfStatementClass (StartIf StartIf, IfCond IfCond, StartIfStatement StartIfStatement, Statement Statement, EndIf EndIf) {
        this.StartIf=StartIf;
        if(StartIf!=null) StartIf.setParent(this);
        this.IfCond=IfCond;
        if(IfCond!=null) IfCond.setParent(this);
        this.StartIfStatement=StartIfStatement;
        if(StartIfStatement!=null) StartIfStatement.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.EndIf=EndIf;
        if(EndIf!=null) EndIf.setParent(this);
    }

    public StartIf getStartIf() {
        return StartIf;
    }

    public void setStartIf(StartIf StartIf) {
        this.StartIf=StartIf;
    }

    public IfCond getIfCond() {
        return IfCond;
    }

    public void setIfCond(IfCond IfCond) {
        this.IfCond=IfCond;
    }

    public StartIfStatement getStartIfStatement() {
        return StartIfStatement;
    }

    public void setStartIfStatement(StartIfStatement StartIfStatement) {
        this.StartIfStatement=StartIfStatement;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public EndIf getEndIf() {
        return EndIf;
    }

    public void setEndIf(EndIf EndIf) {
        this.EndIf=EndIf;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StartIf!=null) StartIf.accept(visitor);
        if(IfCond!=null) IfCond.accept(visitor);
        if(StartIfStatement!=null) StartIfStatement.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(EndIf!=null) EndIf.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StartIf!=null) StartIf.traverseTopDown(visitor);
        if(IfCond!=null) IfCond.traverseTopDown(visitor);
        if(StartIfStatement!=null) StartIfStatement.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(EndIf!=null) EndIf.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StartIf!=null) StartIf.traverseBottomUp(visitor);
        if(IfCond!=null) IfCond.traverseBottomUp(visitor);
        if(StartIfStatement!=null) StartIfStatement.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(EndIf!=null) EndIf.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfStatementClass(\n");

        if(StartIf!=null)
            buffer.append(StartIf.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IfCond!=null)
            buffer.append(IfCond.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StartIfStatement!=null)
            buffer.append(StartIfStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(EndIf!=null)
            buffer.append(EndIf.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfStatementClass]");
        return buffer.toString();
    }
}
