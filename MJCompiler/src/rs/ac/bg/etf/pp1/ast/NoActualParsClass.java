// generated with ast extension for cup
// version 0.8
// 7/1/2023 2:0:43


package rs.ac.bg.etf.pp1.ast;

public class NoActualParsClass extends ActPars {

    private ActParsFlag ActParsFlag;

    public NoActualParsClass (ActParsFlag ActParsFlag) {
        this.ActParsFlag=ActParsFlag;
        if(ActParsFlag!=null) ActParsFlag.setParent(this);
    }

    public ActParsFlag getActParsFlag() {
        return ActParsFlag;
    }

    public void setActParsFlag(ActParsFlag ActParsFlag) {
        this.ActParsFlag=ActParsFlag;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParsFlag!=null) ActParsFlag.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsFlag!=null) ActParsFlag.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsFlag!=null) ActParsFlag.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoActualParsClass(\n");

        if(ActParsFlag!=null)
            buffer.append(ActParsFlag.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NoActualParsClass]");
        return buffer.toString();
    }
}
