// generated with ast extension for cup
// version 0.8
// 7/1/2023 2:0:43


package rs.ac.bg.etf.pp1.ast;

public class ActualParsClass extends ActPars {

    private ActParsFlag ActParsFlag;
    private ListOfActPars ListOfActPars;

    public ActualParsClass (ActParsFlag ActParsFlag, ListOfActPars ListOfActPars) {
        this.ActParsFlag=ActParsFlag;
        if(ActParsFlag!=null) ActParsFlag.setParent(this);
        this.ListOfActPars=ListOfActPars;
        if(ListOfActPars!=null) ListOfActPars.setParent(this);
    }

    public ActParsFlag getActParsFlag() {
        return ActParsFlag;
    }

    public void setActParsFlag(ActParsFlag ActParsFlag) {
        this.ActParsFlag=ActParsFlag;
    }

    public ListOfActPars getListOfActPars() {
        return ListOfActPars;
    }

    public void setListOfActPars(ListOfActPars ListOfActPars) {
        this.ListOfActPars=ListOfActPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParsFlag!=null) ActParsFlag.accept(visitor);
        if(ListOfActPars!=null) ListOfActPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsFlag!=null) ActParsFlag.traverseTopDown(visitor);
        if(ListOfActPars!=null) ListOfActPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsFlag!=null) ActParsFlag.traverseBottomUp(visitor);
        if(ListOfActPars!=null) ListOfActPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActualParsClass(\n");

        if(ActParsFlag!=null)
            buffer.append(ActParsFlag.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListOfActPars!=null)
            buffer.append(ListOfActPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActualParsClass]");
        return buffer.toString();
    }
}
