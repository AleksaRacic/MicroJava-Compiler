// generated with ast extension for cup
// version 0.8
// 7/1/2023 2:0:43


package rs.ac.bg.etf.pp1.ast;

public class ProgramClass extends Program {

    private ProgName ProgName;
    private DecList DecList;
    private ListOfMethodDecl ListOfMethodDecl;

    public ProgramClass (ProgName ProgName, DecList DecList, ListOfMethodDecl ListOfMethodDecl) {
        this.ProgName=ProgName;
        if(ProgName!=null) ProgName.setParent(this);
        this.DecList=DecList;
        if(DecList!=null) DecList.setParent(this);
        this.ListOfMethodDecl=ListOfMethodDecl;
        if(ListOfMethodDecl!=null) ListOfMethodDecl.setParent(this);
    }

    public ProgName getProgName() {
        return ProgName;
    }

    public void setProgName(ProgName ProgName) {
        this.ProgName=ProgName;
    }

    public DecList getDecList() {
        return DecList;
    }

    public void setDecList(DecList DecList) {
        this.DecList=DecList;
    }

    public ListOfMethodDecl getListOfMethodDecl() {
        return ListOfMethodDecl;
    }

    public void setListOfMethodDecl(ListOfMethodDecl ListOfMethodDecl) {
        this.ListOfMethodDecl=ListOfMethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgName!=null) ProgName.accept(visitor);
        if(DecList!=null) DecList.accept(visitor);
        if(ListOfMethodDecl!=null) ListOfMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgName!=null) ProgName.traverseTopDown(visitor);
        if(DecList!=null) DecList.traverseTopDown(visitor);
        if(ListOfMethodDecl!=null) ListOfMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgName!=null) ProgName.traverseBottomUp(visitor);
        if(DecList!=null) DecList.traverseBottomUp(visitor);
        if(ListOfMethodDecl!=null) ListOfMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramClass(\n");

        if(ProgName!=null)
            buffer.append(ProgName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DecList!=null)
            buffer.append(DecList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListOfMethodDecl!=null)
            buffer.append(ListOfMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramClass]");
        return buffer.toString();
    }
}
