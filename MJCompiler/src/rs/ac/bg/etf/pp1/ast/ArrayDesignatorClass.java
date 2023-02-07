// generated with ast extension for cup
// version 0.8
// 7/1/2023 2:0:43


package rs.ac.bg.etf.pp1.ast;

public class ArrayDesignatorClass extends Designator {

    private ArrDsignator ArrDsignator;
    private Expr Expr;

    public ArrayDesignatorClass (ArrDsignator ArrDsignator, Expr Expr) {
        this.ArrDsignator=ArrDsignator;
        if(ArrDsignator!=null) ArrDsignator.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public ArrDsignator getArrDsignator() {
        return ArrDsignator;
    }

    public void setArrDsignator(ArrDsignator ArrDsignator) {
        this.ArrDsignator=ArrDsignator;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ArrDsignator!=null) ArrDsignator.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ArrDsignator!=null) ArrDsignator.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ArrDsignator!=null) ArrDsignator.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ArrayDesignatorClass(\n");

        if(ArrDsignator!=null)
            buffer.append(ArrDsignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ArrayDesignatorClass]");
        return buffer.toString();
    }
}
