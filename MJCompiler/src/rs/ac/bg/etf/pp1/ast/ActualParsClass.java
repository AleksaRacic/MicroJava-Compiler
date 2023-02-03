// generated with ast extension for cup
// version 0.8
// 3/1/2023 1:47:18


package rs.ac.bg.etf.pp1.ast;

public class ActualParsClass extends ActPars {

    private ListOfActPars ListOfActPars;

    public ActualParsClass (ListOfActPars ListOfActPars) {
        this.ListOfActPars=ListOfActPars;
        if(ListOfActPars!=null) ListOfActPars.setParent(this);
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
        if(ListOfActPars!=null) ListOfActPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListOfActPars!=null) ListOfActPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListOfActPars!=null) ListOfActPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActualParsClass(\n");

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
