// generated with ast extension for cup
// version 0.8
// 2/1/2023 20:40:20


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclClass extends ClassDecl {

    private String className;
    private Extended Extended;
    private ClassBody ClassBody;

    public ClassDeclClass (String className, Extended Extended, ClassBody ClassBody) {
        this.className=className;
        this.Extended=Extended;
        if(Extended!=null) Extended.setParent(this);
        this.ClassBody=ClassBody;
        if(ClassBody!=null) ClassBody.setParent(this);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className=className;
    }

    public Extended getExtended() {
        return Extended;
    }

    public void setExtended(Extended Extended) {
        this.Extended=Extended;
    }

    public ClassBody getClassBody() {
        return ClassBody;
    }

    public void setClassBody(ClassBody ClassBody) {
        this.ClassBody=ClassBody;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Extended!=null) Extended.accept(visitor);
        if(ClassBody!=null) ClassBody.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Extended!=null) Extended.traverseTopDown(visitor);
        if(ClassBody!=null) ClassBody.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Extended!=null) Extended.traverseBottomUp(visitor);
        if(ClassBody!=null) ClassBody.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclClass(\n");

        buffer.append(" "+tab+className);
        buffer.append("\n");

        if(Extended!=null)
            buffer.append(Extended.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassBody!=null)
            buffer.append(ClassBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclClass]");
        return buffer.toString();
    }
}
