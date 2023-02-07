// generated with ast extension for cup
// version 0.8
// 7/1/2023 2:0:43


package rs.ac.bg.etf.pp1.ast;

public class ForEachStatementClass extends Statement {

    private ForeachFlag ForeachFlag;
    private ForeachIdent ForeachIdent;
    private Statement Statement;
    private TestForEach TestForEach;

    public ForEachStatementClass (ForeachFlag ForeachFlag, ForeachIdent ForeachIdent, Statement Statement, TestForEach TestForEach) {
        this.ForeachFlag=ForeachFlag;
        if(ForeachFlag!=null) ForeachFlag.setParent(this);
        this.ForeachIdent=ForeachIdent;
        if(ForeachIdent!=null) ForeachIdent.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.TestForEach=TestForEach;
        if(TestForEach!=null) TestForEach.setParent(this);
    }

    public ForeachFlag getForeachFlag() {
        return ForeachFlag;
    }

    public void setForeachFlag(ForeachFlag ForeachFlag) {
        this.ForeachFlag=ForeachFlag;
    }

    public ForeachIdent getForeachIdent() {
        return ForeachIdent;
    }

    public void setForeachIdent(ForeachIdent ForeachIdent) {
        this.ForeachIdent=ForeachIdent;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public TestForEach getTestForEach() {
        return TestForEach;
    }

    public void setTestForEach(TestForEach TestForEach) {
        this.TestForEach=TestForEach;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ForeachFlag!=null) ForeachFlag.accept(visitor);
        if(ForeachIdent!=null) ForeachIdent.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(TestForEach!=null) TestForEach.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ForeachFlag!=null) ForeachFlag.traverseTopDown(visitor);
        if(ForeachIdent!=null) ForeachIdent.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(TestForEach!=null) TestForEach.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ForeachFlag!=null) ForeachFlag.traverseBottomUp(visitor);
        if(ForeachIdent!=null) ForeachIdent.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(TestForEach!=null) TestForEach.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForEachStatementClass(\n");

        if(ForeachFlag!=null)
            buffer.append(ForeachFlag.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForeachIdent!=null)
            buffer.append(ForeachIdent.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TestForEach!=null)
            buffer.append(TestForEach.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForEachStatementClass]");
        return buffer.toString();
    }
}
