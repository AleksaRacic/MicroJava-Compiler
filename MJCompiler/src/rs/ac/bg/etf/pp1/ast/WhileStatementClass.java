// generated with ast extension for cup
// version 0.8
// 7/1/2023 2:0:43


package rs.ac.bg.etf.pp1.ast;

public class WhileStatementClass extends Statement {

    private WhileFlag WhileFlag;
    private Condition Condition;
    private Statement Statement;

    public WhileStatementClass (WhileFlag WhileFlag, Condition Condition, Statement Statement) {
        this.WhileFlag=WhileFlag;
        if(WhileFlag!=null) WhileFlag.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public WhileFlag getWhileFlag() {
        return WhileFlag;
    }

    public void setWhileFlag(WhileFlag WhileFlag) {
        this.WhileFlag=WhileFlag;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
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
        if(WhileFlag!=null) WhileFlag.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(WhileFlag!=null) WhileFlag.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(WhileFlag!=null) WhileFlag.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("WhileStatementClass(\n");

        if(WhileFlag!=null)
            buffer.append(WhileFlag.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [WhileStatementClass]");
        return buffer.toString();
    }
}
