// generated with ast extension for cup
// version 0.8
// 7/1/2023 2:0:43


package rs.ac.bg.etf.pp1.ast;

public class IfElseStatementClass extends Statement {

    private StartIf StartIf;
    private IfCond IfCond;
    private StartIfStatement StartIfStatement;
    private Statement Statement;
    private EndIf EndIf;
    private Statement Statement1;

    public IfElseStatementClass (StartIf StartIf, IfCond IfCond, StartIfStatement StartIfStatement, Statement Statement, EndIf EndIf, Statement Statement1) {
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
        this.Statement1=Statement1;
        if(Statement1!=null) Statement1.setParent(this);
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

    public Statement getStatement1() {
        return Statement1;
    }

    public void setStatement1(Statement Statement1) {
        this.Statement1=Statement1;
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
        if(Statement1!=null) Statement1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StartIf!=null) StartIf.traverseTopDown(visitor);
        if(IfCond!=null) IfCond.traverseTopDown(visitor);
        if(StartIfStatement!=null) StartIfStatement.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(EndIf!=null) EndIf.traverseTopDown(visitor);
        if(Statement1!=null) Statement1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StartIf!=null) StartIf.traverseBottomUp(visitor);
        if(IfCond!=null) IfCond.traverseBottomUp(visitor);
        if(StartIfStatement!=null) StartIfStatement.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(EndIf!=null) EndIf.traverseBottomUp(visitor);
        if(Statement1!=null) Statement1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfElseStatementClass(\n");

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

        if(Statement1!=null)
            buffer.append(Statement1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfElseStatementClass]");
        return buffer.toString();
    }
}
