// generated with ast extension for cup
// version 0.8
// 7/1/2023 2:0:43


package rs.ac.bg.etf.pp1.ast;

public class ListOfActParExprClass extends ListOfActPars {

    private ListOfActPars ListOfActPars;
    private ActParsElement ActParsElement;

    public ListOfActParExprClass (ListOfActPars ListOfActPars, ActParsElement ActParsElement) {
        this.ListOfActPars=ListOfActPars;
        if(ListOfActPars!=null) ListOfActPars.setParent(this);
        this.ActParsElement=ActParsElement;
        if(ActParsElement!=null) ActParsElement.setParent(this);
    }

    public ListOfActPars getListOfActPars() {
        return ListOfActPars;
    }

    public void setListOfActPars(ListOfActPars ListOfActPars) {
        this.ListOfActPars=ListOfActPars;
    }

    public ActParsElement getActParsElement() {
        return ActParsElement;
    }

    public void setActParsElement(ActParsElement ActParsElement) {
        this.ActParsElement=ActParsElement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListOfActPars!=null) ListOfActPars.accept(visitor);
        if(ActParsElement!=null) ActParsElement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListOfActPars!=null) ListOfActPars.traverseTopDown(visitor);
        if(ActParsElement!=null) ActParsElement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListOfActPars!=null) ListOfActPars.traverseBottomUp(visitor);
        if(ActParsElement!=null) ActParsElement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListOfActParExprClass(\n");

        if(ListOfActPars!=null)
            buffer.append(ListOfActPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsElement!=null)
            buffer.append(ActParsElement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListOfActParExprClass]");
        return buffer.toString();
    }
}
