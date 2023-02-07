package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.*;

public class CodeGenerator extends VisitorAdaptor {
	private int mainPc;

	public int getMainPc() {
		return mainPc;
	}

	public void visit(PrintStatementClass printStmt) {
		Struct type = printStmt.getExpr().struct;
		if (type == MyTab.intType || type == MyTab.boolType) {
			Code.loadConst(5);
			Code.put(Code.print);
		} else {
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
	}

	public void visit(PrintStatementWidthClass printStmt) {
		Struct type = printStmt.getExpr().struct;
		Code.loadConst(printStmt.getWidth());
		if (type == MyTab.intType || type == MyTab.boolType) {
			Code.loadConst(5);
			Code.put(Code.print);
		} else {
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
	}

	public void visit(ReadStatementClass readStmt) {

		Struct type = readStmt.getDesignator().obj.getType();
		if (type == MyTab.charType) {
			Code.put(Code.bread);
		} else {
			Code.put(Code.read);
		}

		Code.store(readStmt.getDesignator().obj);
	}

	public void visit(DesignatorStatementAssignClass stm) {

		Code.store(stm.getDesignator().obj);
	}

	List<Obj> arrStatementDesignators = new ArrayList<>();
	boolean reverse = false;

	@Override
	public void visit(DesignArrAssignmentClass designatorParent) {
		//System.out.println(designatorParent.obj.getName());
		if(designatorParent.getDesignator() instanceof ArrayDesignatorClass) {
			reverse = true;
			ArrayDesignatorClass aaa = (ArrayDesignatorClass)designatorParent.getDesignator();
		}
		Obj designator = designatorParent.getDesignator().obj;
		arrStatementDesignators.add(designator);
	}

	@Override
	public void visit(DesignatorEpsilonClass designatorParent) {
		arrStatementDesignators.add(MyTab.noObj);
	}

	@Override
	public void visit(DesignatorStatementArrayClass statement) {
		Obj rhs = statement.getDesignator().obj;
		
		int index;
		
		if(reverse) {
			Collections.reverse(arrStatementDesignators);
			index = arrStatementDesignators.size();
		}else {
			index = -1;
		}
		
		for (Obj o : arrStatementDesignators) {
			index = reverse?index-1:index+1;
			if (o.equals(MyTab.noObj))
				continue;
			Code.load(rhs);
			Code.put(Code.const_);
			Code.put4(index);
			Code.put(Code.aload);
			System.out.println(o.getName());
			System.out.println("index" + index);
			System.out.println("Store" + Code.pc + "\n");
			Code.store(o);
			
			
		}
		reverse = false;
		arrStatementDesignators.clear();
	}

	@Override
	public void visit(DesignatorStatementIncClass statement) {
		Obj designator = statement.getDesignator().obj;
		if (designator.getKind() == Obj.Elem)
			Code.put(Code.dup2);
		Code.load(designator);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(designator);
	}

	@Override
	public void visit(DesignatorStatementDecClass statement) {
		Obj designator = statement.getDesignator().obj;
		if (designator.getKind() == Obj.Elem)
			Code.put(Code.dup2);
		Code.load(designator);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(designator);
	}

	@Override
	public void visit(ExprClass expr) {
		Addop op = expr.getAddop();
		if (op instanceof PlusOpClass)
			Code.put(Code.add);
		if (op instanceof MinusOpClass)
			Code.put(Code.sub);
	}

	@Override
	public void visit(NegativeExprClass expr) {
		Code.put(Code.neg);
	}

	@Override
	public void visit(MultipleFactorsTermClass term) {
		Mulop op = term.getMulop();
		if (op instanceof MulClass)
			Code.put(Code.mul);
		if (op instanceof DivClass)
			Code.put(Code.div);
		if (op instanceof ModClass)
			Code.put(Code.rem);
	}

	@Override
	public void visit(NumberFactorClass factor) {
		//System.out.println("loadConst" + Code.pc + " "+factor.getNumValue());
		Code.loadConst(factor.getNumValue());
	}

	@Override
	public void visit(CharFactorClass factor) {
		Code.loadConst(factor.getCharValue()); // vidi da li moze ovo(implicitna konverzija char u int)
	}

	@Override
	public void visit(BoolFactorClass factor) {
		Code.loadConst(factor.getBoolValue() == true ? 1 : 0);
	}

	@Override
	public void visit(DesignatorClass designator) {
		// Ovo za klase dodathi this ako je u natklasi
	}

	@Override
	public void visit(ArrDesignator designator) {
		Code.load(designator.getDesignator().obj);
	}

	@Override
	public void visit(ClassDesignatorClass designator) {
		// klase
	}

	@Override
	public void visit(DesignatorFactorClass factor) {
		Code.load(factor.getDesignator().obj);
	}

	@Override
	public void visit(FuncCallDesignatorClass factor) {
		Obj method = factor.getDesignator().obj;

		if (method.getName().equals("ord") || method.getName().equals("chr")) {
			return;
		}

		if (method.getName().equals("len")) {
			Code.put(Code.arraylength);
			return;
		}
		int offset = method.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);

	}

	@Override
	public void visit(DesignatorStatementFunctionClass stm) {
		Obj method = stm.getDesignator().obj;

		if (method.getName().equals("ord") || method.getName().equals("chr")) {
			return;
		}

		if (method.getName().equals("len")) {
			Code.put(Code.arraylength);
			return;
		}
		int offset = method.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);

	}

	@Override
	public void visit(ReturnMethodClass method) {
		method.obj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(method.obj.getLevel());
		Code.put(method.obj.getLocalSymbols().size());

	}
	
	@Override
	public void visit(VoidMethodClass method) {
		if("main".equalsIgnoreCase(method.getName())) {
			mainPc = Code.pc;
		}
		method.obj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(method.obj.getLevel());
		Code.put(method.obj.getLocalSymbols().size());

	}
	
	@Override
	public void visit(ArrayFactorClass method) {
		Code.put(Code.newarray);
		Code.put(method.getExpr().struct.getElemType() == MyTab.charType ? 0 : 1);
	}
	
	@Override
	public void visit(MethodDeclClass method) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	Stack<List<Integer>> andStack = new Stack<List<Integer>>();
	Stack<List<Integer>> orStack = new Stack<List<Integer>>();

	Stack<List<Integer>> elseStack = new Stack<List<Integer>>();
	
	@Override
	public void visit(CondFactClass fact) {
		
		andStack.peek().add(Code.pc+1);
		
		if(fact.getRelop() instanceof EqOpClass) {
			Code.putFalseJump(Code.eq, 0);
		}else if(fact.getRelop() instanceof NeqOpClass) {
			Code.putFalseJump(Code.ne, 0); 			
		} else if(fact.getRelop() instanceof GrOpClass) {
			Code.putFalseJump(Code.gt, 0); 			
		} else if(fact.getRelop() instanceof GreOpClass) {
			Code.putFalseJump(Code.ge, 0); 			
		} else if(fact.getRelop() instanceof LessOpClass) {
			Code.putFalseJump(Code.lt, 0); 			
		} else if(fact.getRelop() instanceof LeqOpClass) {
			Code.putFalseJump(Code.le, 0); 			
		}
	}
	
	@Override
	public void visit(StartIf si) {
		System.out.println("IF start " + Code.pc);
		andStack.push(new ArrayList<Integer>());
		orStack.push(new ArrayList<Integer>());
		elseStack.push(new ArrayList<Integer>());
		
	}
	
	@Override
	public void visit(IfStatementClass fisi) {
		andStack.pop();
		orStack.pop();
		elseStack.pop();
		
	}
	
	@Override
	public void visit(IfElseStatementClass fisi) {
		
		andStack.pop();
		orStack.pop();
		//FGor ones that are jumping to the end of else statement
		for(int i : elseStack.pop()) {
			Code.fixup(i);
		}
		System.out.println("IF END " + Code.pc);
	}
	
	@Override
	public void visit(EndIf ei) {
		System.out.println("IFELSE end " + Code.pc);
		if(ei.getParent() instanceof IfElseStatementClass) {
			elseStack.peek().add(Code.pc + 1);
			Code.putJump(0);

		}
		
		//Who is Jumping to the beginning of ELSE (last term in 
		for(int i : andStack.peek()) {
			Code.fixup(i);
		}
		andStack.peek().clear();
		
	}
	
	@Override
	public void visit(OrJump oj) {
		orStack.peek().add(Code.pc + 1);
		Code.putJump(0);
		
		//jumping to the next and term
		for(int i : andStack.peek()) {
			Code.fixup(i);
		}
		andStack.peek().clear();
	}
	
	
	@Override
	public void visit(SingleCondFactClass scc) {
		//Code.put(Code.const_1);
		Code.loadConst(1);
		andStack.peek().add(Code.pc+1);
		Code.putFalseJump(Code.eq, 0);
	}
	
	@Override
	public void visit(StartIfStatement sis) {
		for(int i : orStack.peek()) {
			Code.fixup(i);
		}
		orStack.peek().clear();
	}
	
	Stack<List<Integer>> breakStack = new Stack<List<Integer>>();
	Stack<Integer> loopStartStack = new Stack<Integer>();
	
	@Override
	public void visit(WhileFlag wf) {
		andStack.push(new ArrayList<Integer>());
		orStack.push(new ArrayList<Integer>());
		breakStack.push(new ArrayList<Integer>()); //In LOOP context else will will lead to end of the loop
		loopStartStack.push(Code.pc); //no stack needed because it will 

		System.out.println("WHILE start " + Code.pc);
	}
	
	@Override
	public void visit(WhileStatementClass wsc) {
		System.out.println("WHILE end " + Code.pc);
		Code.putJump(loopStartStack.pop());
		
		for(int i : andStack.pop()) {
			Code.fixup(i);
		}
		
		for(int i : breakStack.pop()) {
			Code.fixup(i);
		}
		
		orStack.pop();
	}
	
	@Override
	public void visit(BreakStatementClass bsc) {
		breakStack.peek().add(Code.pc + 1);
		Code.putJump(0); //hopefully fixup will be at the end of WhileStatement
	}
	
	@Override
	public void visit(ContinueStatementClass csc) {
		Code.putJump(loopStartStack.peek());
	}
	
	Obj foreachDesignator;
	
	@Override
	public void visit(ForeachFlag ff) {
		foreachDesignator = ff.obj;
		Code.load(ff.obj);
		Code.put(Code.arraylength);
		Code.loadConst(0);
		loopStartStack.push(Code.pc);
	}
	
	@Override
	public void visit(ForeachIdent fei) {
		Obj ident = fei.obj;
		Code.put(Code.dup);
		Code.load(foreachDesignator);
		Code.put(Code.dup_x1);
		Code.put(Code.pop);
		Code.put(Code.aload);
		Code.store(ident);
	}
	
	@Override
	public void visit(TestForEach tfe) {
		Code.loadConst(1);
		Code.put(Code.add);
		Code.put(Code.dup2);
		Code.putFalseJump(Code.le, loopStartStack.peek());
		//Clear remaining garbage
		Code.put(Code.pop);
		Code.put(Code.pop);
	}
	
	@Override
	public void visit(ForEachStatementClass fes) {
		loopStartStack.pop();
	}
	
	
	
}
