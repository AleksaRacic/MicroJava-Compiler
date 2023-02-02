// generated with ast extension for cup
// version 0.8
// 2/1/2023 20:40:20


package rs.ac.bg.etf.pp1.ast;

public class VarDecLastElementClass extends VarDecLastElement {

    private String varName;
    private OptionalBrackets OptionalBrackets;

    public VarDecLastElementClass (String varName, OptionalBrackets OptionalBrackets) {
        this.varName=varName;
        this.OptionalBrackets=OptionalBrackets;
        if(OptionalBrackets!=null) OptionalBrackets.setParent(this);
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public OptionalBrackets getOptionalBrackets() {
        return OptionalBrackets;
    }

    public void setOptionalBrackets(OptionalBrackets OptionalBrackets) {
        this.OptionalBrackets=OptionalBrackets;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalBrackets!=null) OptionalBrackets.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalBrackets!=null) OptionalBrackets.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalBrackets!=null) OptionalBrackets.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDecLastElementClass(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(OptionalBrackets!=null)
            buffer.append(OptionalBrackets.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDecLastElementClass]");
        return buffer.toString();
    }
}
