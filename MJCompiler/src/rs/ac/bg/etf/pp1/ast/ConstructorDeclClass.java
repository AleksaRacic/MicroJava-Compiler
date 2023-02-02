// generated with ast extension for cup
// version 0.8
// 2/1/2023 20:40:20


package rs.ac.bg.etf.pp1.ast;

public class ConstructorDeclClass extends ConstructorDecl {

    private String name;
    private FormParsList FormParsList;
    private ListOfVarDecl ListOfVarDecl;
    private ListOfStatements ListOfStatements;

    public ConstructorDeclClass (String name, FormParsList FormParsList, ListOfVarDecl ListOfVarDecl, ListOfStatements ListOfStatements) {
        this.name=name;
        this.FormParsList=FormParsList;
        if(FormParsList!=null) FormParsList.setParent(this);
        this.ListOfVarDecl=ListOfVarDecl;
        if(ListOfVarDecl!=null) ListOfVarDecl.setParent(this);
        this.ListOfStatements=ListOfStatements;
        if(ListOfStatements!=null) ListOfStatements.setParent(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public FormParsList getFormParsList() {
        return FormParsList;
    }

    public void setFormParsList(FormParsList FormParsList) {
        this.FormParsList=FormParsList;
    }

    public ListOfVarDecl getListOfVarDecl() {
        return ListOfVarDecl;
    }

    public void setListOfVarDecl(ListOfVarDecl ListOfVarDecl) {
        this.ListOfVarDecl=ListOfVarDecl;
    }

    public ListOfStatements getListOfStatements() {
        return ListOfStatements;
    }

    public void setListOfStatements(ListOfStatements ListOfStatements) {
        this.ListOfStatements=ListOfStatements;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParsList!=null) FormParsList.accept(visitor);
        if(ListOfVarDecl!=null) ListOfVarDecl.accept(visitor);
        if(ListOfStatements!=null) ListOfStatements.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsList!=null) FormParsList.traverseTopDown(visitor);
        if(ListOfVarDecl!=null) ListOfVarDecl.traverseTopDown(visitor);
        if(ListOfStatements!=null) ListOfStatements.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsList!=null) FormParsList.traverseBottomUp(visitor);
        if(ListOfVarDecl!=null) ListOfVarDecl.traverseBottomUp(visitor);
        if(ListOfStatements!=null) ListOfStatements.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstructorDeclClass(\n");

        buffer.append(" "+tab+name);
        buffer.append("\n");

        if(FormParsList!=null)
            buffer.append(FormParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListOfVarDecl!=null)
            buffer.append(ListOfVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListOfStatements!=null)
            buffer.append(ListOfStatements.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstructorDeclClass]");
        return buffer.toString();
    }
}
