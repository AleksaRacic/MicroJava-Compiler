// generated with ast extension for cup
// version 0.8
// 2/1/2023 20:40:20


package rs.ac.bg.etf.pp1.ast;

public class ClassBodyVarEmptyClass extends ClassBody {

    private ListOfVarDecl ListOfVarDecl;

    public ClassBodyVarEmptyClass (ListOfVarDecl ListOfVarDecl) {
        this.ListOfVarDecl=ListOfVarDecl;
        if(ListOfVarDecl!=null) ListOfVarDecl.setParent(this);
    }

    public ListOfVarDecl getListOfVarDecl() {
        return ListOfVarDecl;
    }

    public void setListOfVarDecl(ListOfVarDecl ListOfVarDecl) {
        this.ListOfVarDecl=ListOfVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListOfVarDecl!=null) ListOfVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListOfVarDecl!=null) ListOfVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListOfVarDecl!=null) ListOfVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassBodyVarEmptyClass(\n");

        if(ListOfVarDecl!=null)
            buffer.append(ListOfVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassBodyVarEmptyClass]");
        return buffer.toString();
    }
}
