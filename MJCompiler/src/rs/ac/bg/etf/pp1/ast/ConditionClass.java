// generated with ast extension for cup
// version 0.8
// 7/1/2023 2:0:43


package rs.ac.bg.etf.pp1.ast;

public class ConditionClass extends Condition {

    private Condition Condition;
    private OrJump OrJump;
    private CondTerm CondTerm;

    public ConditionClass (Condition Condition, OrJump OrJump, CondTerm CondTerm) {
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.OrJump=OrJump;
        if(OrJump!=null) OrJump.setParent(this);
        this.CondTerm=CondTerm;
        if(CondTerm!=null) CondTerm.setParent(this);
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public OrJump getOrJump() {
        return OrJump;
    }

    public void setOrJump(OrJump OrJump) {
        this.OrJump=OrJump;
    }

    public CondTerm getCondTerm() {
        return CondTerm;
    }

    public void setCondTerm(CondTerm CondTerm) {
        this.CondTerm=CondTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Condition!=null) Condition.accept(visitor);
        if(OrJump!=null) OrJump.accept(visitor);
        if(CondTerm!=null) CondTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(OrJump!=null) OrJump.traverseTopDown(visitor);
        if(CondTerm!=null) CondTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(OrJump!=null) OrJump.traverseBottomUp(visitor);
        if(CondTerm!=null) CondTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionClass(\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OrJump!=null)
            buffer.append(OrJump.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTerm!=null)
            buffer.append(CondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionClass]");
        return buffer.toString();
    }
}
