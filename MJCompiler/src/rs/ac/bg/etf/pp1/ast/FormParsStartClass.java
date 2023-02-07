// generated with ast extension for cup
// version 0.8
// 7/1/2023 2:0:43


package rs.ac.bg.etf.pp1.ast;

public class FormParsStartClass extends FormParsList {

    private FormParsElement FormParsElement;
    private FormParsList FormParsList;

    public FormParsStartClass (FormParsElement FormParsElement, FormParsList FormParsList) {
        this.FormParsElement=FormParsElement;
        if(FormParsElement!=null) FormParsElement.setParent(this);
        this.FormParsList=FormParsList;
        if(FormParsList!=null) FormParsList.setParent(this);
    }

    public FormParsElement getFormParsElement() {
        return FormParsElement;
    }

    public void setFormParsElement(FormParsElement FormParsElement) {
        this.FormParsElement=FormParsElement;
    }

    public FormParsList getFormParsList() {
        return FormParsList;
    }

    public void setFormParsList(FormParsList FormParsList) {
        this.FormParsList=FormParsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParsElement!=null) FormParsElement.accept(visitor);
        if(FormParsList!=null) FormParsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsElement!=null) FormParsElement.traverseTopDown(visitor);
        if(FormParsList!=null) FormParsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsElement!=null) FormParsElement.traverseBottomUp(visitor);
        if(FormParsList!=null) FormParsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsStartClass(\n");

        if(FormParsElement!=null)
            buffer.append(FormParsElement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsList!=null)
            buffer.append(FormParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsStartClass]");
        return buffer.toString();
    }
}
