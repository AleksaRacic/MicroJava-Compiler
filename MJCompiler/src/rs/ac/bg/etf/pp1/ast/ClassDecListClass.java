// generated with ast extension for cup
// version 0.8
// 7/1/2023 2:0:43


package rs.ac.bg.etf.pp1.ast;

public class ClassDecListClass extends DecList {

    private DecList DecList;
    private ClassDecl ClassDecl;

    public ClassDecListClass (DecList DecList, ClassDecl ClassDecl) {
        this.DecList=DecList;
        if(DecList!=null) DecList.setParent(this);
        this.ClassDecl=ClassDecl;
        if(ClassDecl!=null) ClassDecl.setParent(this);
    }

    public DecList getDecList() {
        return DecList;
    }

    public void setDecList(DecList DecList) {
        this.DecList=DecList;
    }

    public ClassDecl getClassDecl() {
        return ClassDecl;
    }

    public void setClassDecl(ClassDecl ClassDecl) {
        this.ClassDecl=ClassDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DecList!=null) DecList.accept(visitor);
        if(ClassDecl!=null) ClassDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DecList!=null) DecList.traverseTopDown(visitor);
        if(ClassDecl!=null) ClassDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DecList!=null) DecList.traverseBottomUp(visitor);
        if(ClassDecl!=null) ClassDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecListClass(\n");

        if(DecList!=null)
            buffer.append(DecList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassDecl!=null)
            buffer.append(ClassDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecListClass]");
        return buffer.toString();
    }
}
