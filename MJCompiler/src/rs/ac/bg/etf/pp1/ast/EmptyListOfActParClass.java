// generated with ast extension for cup
// version 0.8
// 7/1/2023 2:0:43


package rs.ac.bg.etf.pp1.ast;

public class EmptyListOfActParClass extends ListOfActPars {

    private ActParsElement ActParsElement;

    public EmptyListOfActParClass (ActParsElement ActParsElement) {
        this.ActParsElement=ActParsElement;
        if(ActParsElement!=null) ActParsElement.setParent(this);
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
        if(ActParsElement!=null) ActParsElement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsElement!=null) ActParsElement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsElement!=null) ActParsElement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EmptyListOfActParClass(\n");

        if(ActParsElement!=null)
            buffer.append(ActParsElement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EmptyListOfActParClass]");
        return buffer.toString();
    }
}
