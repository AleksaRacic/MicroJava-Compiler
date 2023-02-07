// generated with ast extension for cup
// version 0.8
// 7/1/2023 2:0:43


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(ListOfStatements ListOfStatements);
    public void visit(Mulop Mulop);
    public void visit(MethodDecl MethodDecl);
    public void visit(ConstructorDecl ConstructorDecl);
    public void visit(VarDecLastElement VarDecLastElement);
    public void visit(Relop Relop);
    public void visit(DesignatorOrEpsilon DesignatorOrEpsilon);
    public void visit(OptionalBrackets OptionalBrackets);
    public void visit(MethodDecList MethodDecList);
    public void visit(Addop Addop);
    public void visit(Factor Factor);
    public void visit(CondTerm CondTerm);
    public void visit(Designator Designator);
    public void visit(VarDecElement VarDecElement);
    public void visit(Term Term);
    public void visit(ClassBody ClassBody);
    public void visit(FormParsList FormParsList);
    public void visit(Condition Condition);
    public void visit(ConstructorDecList ConstructorDecList);
    public void visit(IfCond IfCond);
    public void visit(ListOfActPars ListOfActPars);
    public void visit(DecList DecList);
    public void visit(Extended Extended);
    public void visit(OptDesignatorList OptDesignatorList);
    public void visit(VarDecList VarDecList);
    public void visit(ListOfMethodDecl ListOfMethodDecl);
    public void visit(ListOfVarDecl ListOfVarDecl);
    public void visit(Expr Expr);
    public void visit(ArrDsignator ArrDsignator);
    public void visit(ActPars ActPars);
    public void visit(MethodTypeName MethodTypeName);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(ConstDecElement ConstDecElement);
    public void visit(ConstDecLastElement ConstDecLastElement);
    public void visit(ProgName ProgName);
    public void visit(Statement Statement);
    public void visit(VarDecl VarDecl);
    public void visit(Type Type);
    public void visit(ClassDecl ClassDecl);
    public void visit(ConstDecl ConstDecl);
    public void visit(CondFact CondFact);
    public void visit(Program Program);
    public void visit(ConstDecList ConstDecList);
    public void visit(LeqOpClass LeqOpClass);
    public void visit(LessOpClass LessOpClass);
    public void visit(GreOpClass GreOpClass);
    public void visit(GrOpClass GrOpClass);
    public void visit(NeqOpClass NeqOpClass);
    public void visit(EqOpClass EqOpClass);
    public void visit(ArrDesignator ArrDesignator);
    public void visit(DesignatorClass DesignatorClass);
    public void visit(ArrayDesignatorClass ArrayDesignatorClass);
    public void visit(ClassDesignatorClass ClassDesignatorClass);
    public void visit(MinusOpClass MinusOpClass);
    public void visit(PlusOpClass PlusOpClass);
    public void visit(ActParsElement ActParsElement);
    public void visit(EmptyListOfActParClass EmptyListOfActParClass);
    public void visit(ListOfActParExprClass ListOfActParExprClass);
    public void visit(ActParsFlag ActParsFlag);
    public void visit(NoActualParsClass NoActualParsClass);
    public void visit(ActualParsClass ActualParsClass);
    public void visit(ModClass ModClass);
    public void visit(DivClass DivClass);
    public void visit(MulClass MulClass);
    public void visit(ClassFactorClass ClassFactorClass);
    public void visit(ArrayFactorClass ArrayFactorClass);
    public void visit(ExpFactorClass ExpFactorClass);
    public void visit(BoolFactorClass BoolFactorClass);
    public void visit(CharFactorClass CharFactorClass);
    public void visit(NumberFactorClass NumberFactorClass);
    public void visit(FuncCallDesignatorClass FuncCallDesignatorClass);
    public void visit(DesignatorFactorClass DesignatorFactorClass);
    public void visit(SingleFactorTermClass SingleFactorTermClass);
    public void visit(MultipleFactorsTermClass MultipleFactorsTermClass);
    public void visit(NegativeExprClass NegativeExprClass);
    public void visit(PositiveExprClass PositiveExprClass);
    public void visit(ExprClass ExprClass);
    public void visit(SingleCondFactClass SingleCondFactClass);
    public void visit(CondFactClass CondFactClass);
    public void visit(SingleCondTermClass SingleCondTermClass);
    public void visit(CondTermClass CondTermClass);
    public void visit(OrJump OrJump);
    public void visit(SingleConditionClass SingleConditionClass);
    public void visit(ConditionClass ConditionClass);
    public void visit(DesignatorEpsilonClass DesignatorEpsilonClass);
    public void visit(DesignArrAssignmentClass DesignArrAssignmentClass);
    public void visit(SingleOrEndOfListDesignatorClass SingleOrEndOfListDesignatorClass);
    public void visit(OptDesignatorListClass OptDesignatorListClass);
    public void visit(DesignatorStatementArrayClass DesignatorStatementArrayClass);
    public void visit(DesignatorStatementDecClass DesignatorStatementDecClass);
    public void visit(DesignatorStatementIncClass DesignatorStatementIncClass);
    public void visit(DesignatorStatementFunctionClass DesignatorStatementFunctionClass);
    public void visit(ErrDesignatorStatementAssignClass ErrDesignatorStatementAssignClass);
    public void visit(DesignatorStatementAssignClass DesignatorStatementAssignClass);
    public void visit(ErrIfCondClass ErrIfCondClass);
    public void visit(IfCondClass IfCondClass);
    public void visit(TestForEach TestForEach);
    public void visit(ForeachIdent ForeachIdent);
    public void visit(ForeachFlag ForeachFlag);
    public void visit(WhileFlag WhileFlag);
    public void visit(StartIfStatement StartIfStatement);
    public void visit(EndIf EndIf);
    public void visit(StartIf StartIf);
    public void visit(StatementBlock StatementBlock);
    public void visit(ForEachStatementClass ForEachStatementClass);
    public void visit(PrintStatementWidthClass PrintStatementWidthClass);
    public void visit(PrintStatementClass PrintStatementClass);
    public void visit(ReadStatementClass ReadStatementClass);
    public void visit(ReturnExprStatementClass ReturnExprStatementClass);
    public void visit(ReturnStatementClass ReturnStatementClass);
    public void visit(ContinueStatementClass ContinueStatementClass);
    public void visit(BreakStatementClass BreakStatementClass);
    public void visit(WhileStatementClass WhileStatementClass);
    public void visit(IfElseStatementClass IfElseStatementClass);
    public void visit(IfStatementClass IfStatementClass);
    public void visit(DesignatorStatementClass DesignatorStatementClass);
    public void visit(EmptyListOfStatementsClass EmptyListOfStatementsClass);
    public void visit(ListOfStatementsClass ListOfStatementsClass);
    public void visit(FormParsElement FormParsElement);
    public void visit(FormParsRparenErrorClass FormParsRparenErrorClass);
    public void visit(FormParsCommaErrorClass FormParsCommaErrorClass);
    public void visit(FormParsEnd FormParsEnd);
    public void visit(FormParsNextElementClass FormParsNextElementClass);
    public void visit(FormParsStartClass FormParsStartClass);
    public void visit(VoidMethodClass VoidMethodClass);
    public void visit(ReturnMethodClass ReturnMethodClass);
    public void visit(MethodDeclClass MethodDeclClass);
    public void visit(ConstructorDeclClass ConstructorDeclClass);
    public void visit(SingleConstructorDecListClass SingleConstructorDecListClass);
    public void visit(ConstructorDecListClass ConstructorDecListClass);
    public void visit(EmptyListOfMethodDeclClass EmptyListOfMethodDeclClass);
    public void visit(ListOfMethodDeclClass ListOfMethodDeclClass);
    public void visit(SingleMethodDecListClass SingleMethodDecListClass);
    public void visit(MethodDecListClass MethodDecListClass);
    public void visit(EmptyListOfVarDeclClass EmptyListOfVarDeclClass);
    public void visit(ListOfVarDeclClass ListOfVarDeclClass);
    public void visit(ClassBodyAllClass ClassBodyAllClass);
    public void visit(ClassBodyVarConstructorClass ClassBodyVarConstructorClass);
    public void visit(ClassBodyVarMethodClass ClassBodyVarMethodClass);
    public void visit(ClassBodyVarEmptyClass ClassBodyVarEmptyClass);
    public void visit(ClassBodyVarClass ClassBodyVarClass);
    public void visit(ErrorExtendedClass ErrorExtendedClass);
    public void visit(NotExtendedClass NotExtendedClass);
    public void visit(ExtendedClass ExtendedClass);
    public void visit(ClassDeclClass ClassDeclClass);
    public void visit(VarDecLastElementErrClass VarDecLastElementErrClass);
    public void visit(VarDecLastElementClass VarDecLastElementClass);
    public void visit(NoArrayBracketsClass NoArrayBracketsClass);
    public void visit(ArrayBracketsClass ArrayBracketsClass);
    public void visit(VarDecElementErrClass VarDecElementErrClass);
    public void visit(VarDecElementClass VarDecElementClass);
    public void visit(VarDecLastListElementClass VarDecLastListElementClass);
    public void visit(VarDecListElementClass VarDecListElementClass);
    public void visit(VarDeclClass VarDeclClass);
    public void visit(TypeClass TypeClass);
    public void visit(ConstElementCharLast ConstElementCharLast);
    public void visit(ConstElementNumberLast ConstElementNumberLast);
    public void visit(ConstElementBooleanLast ConstElementBooleanLast);
    public void visit(ConstElementChar ConstElementChar);
    public void visit(ConstElementNumber ConstElementNumber);
    public void visit(ConstElementBoolean ConstElementBoolean);
    public void visit(ConstDecLastElementClass ConstDecLastElementClass);
    public void visit(ConstDecListElementClass ConstDecListElementClass);
    public void visit(ConstDeclClass ConstDeclClass);
    public void visit(NoDecListClass NoDecListClass);
    public void visit(ClassDecListClass ClassDecListClass);
    public void visit(ConstDecListClass ConstDecListClass);
    public void visit(VarDecListClass VarDecListClass);
    public void visit(ProgNameClass ProgNameClass);
    public void visit(ProgramClass ProgramClass);

}
