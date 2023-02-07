package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor {

	boolean errorDetected = false;
	Struct curType = Tab.noType;
	
	static int nVars;

	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.info(msg.toString());
	}

	String getCurType() {
		int i = curType.getKind();
		switch (i) {
		case 0:
			return "NONE";
		case 1:
			return "INT";
		case 2:
			return "CHAR";
		case 3:
			return "ARRAY";
		case 4:
			return "CLASS";
		case 5:
			return "BOOL";
		default:
			return "ERROR";
		}
	}

	String getTypeOf(int i) {
		switch (i) {
		case 0:
			return "NONE";
		case 1:
			return "INT";
		case 2:
			return "CHAR";
		case 3:
			return "ARRAY";
		case 4:
			return "CLASS";
		case 5:
			return "BOOL";
		default:
			return "ERROR";
		}
	}

	public SemanticAnalyzer() {
		Tab.currentScope.addToLocals(new Obj(Obj.Type, "bool", MyTab.boolType));
	}

	@Override
	public void visit(ProgNameClass progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getName(), Tab.noType);
		Tab.openScope();
	}

	@Override
	public void visit(ProgramClass program) {
		nVars = MyTab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
		
		if(!hasMain) {
			report_error("SEMANTICKA GRESKA: ne postoji main funkcija", program);
		}
	}

	@Override
	public void visit() {
	}

	@Override
	public void visit(TypeClass type) {
		Obj typeObj = Tab.find(type.getName());

		if (typeObj == Tab.noObj) {
			report_error("SEMANTICKA GRESKA [" + type.getLine() + "]: Nije pronadjen tip " + type.getName()
					+ " u tabeli simbola", type);
			type.struct = Tab.noType;
		} else {
			if (Obj.Type == typeObj.getKind()) {
				type.struct = typeObj.getType();
			} else {
				type.struct = Tab.noType;
				report_error(
						"SEMANTICKA GRESKA[" + type.getLine() + "]: Ime " + type.getName() + " ne predstavlja tip ",
						type);
			}

			// KLASE
//			Obj tmpClassObj = Tab.find(type.getTypeName());
//			if(tmpClassObj.getType().getKind() == Struct.Class && type.getParent() instanceof NewClassWithActParsOperatorFactor) {
//				
//				nameOfConstr = tmpClassObj.getName();
//				//System.out.println("KLASNI TIP:" + nameOfConstr);
//			}
		}
		curType = type.struct;
	}

	@Override
	public void visit(ConstElementBoolean constDecl) {

		Struct nodeStruct = MyTab.boolType;
		Obj constObj = Tab.find(constDecl.getConstName());

		if (constObj != Tab.noObj) {
			report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Ime " + constDecl.getConstName()
					+ " je vec deklarisano", constDecl);
		} else {
			if (!nodeStruct.equals(curType)) {
				report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Tip "
						+ tableUtils.typeOfStructNode(nodeStruct.getKind()) + " nije isti tip vrednosti kao i "
						+ getCurType(), constDecl);
			} else {
				constObj = Tab.insert(Obj.Con, constDecl.getConstName(), nodeStruct);
				constObj.setAdr((constDecl.getValue() == true) ? 1 : 0);
				report_info("Kreirana je konstanta " + getCurType() + " " + constDecl.getConstName(), constDecl);
			}
		}

	}

	@Override
	public void visit(ConstElementNumber constDecl) {

		Struct nodeStruct = MyTab.intType;
		Obj constObj = Tab.find(constDecl.getConstName());

		if (constObj != Tab.noObj) {
			report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Ime " + constDecl.getConstName()
					+ " je vec deklarisano", constDecl);
		} else {
			if (!nodeStruct.equals(curType)) {
				report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Tip "
						+ tableUtils.typeOfStructNode(nodeStruct.getKind()) + " nije isti tip vrednosti kao i "
						+ getCurType(), constDecl);
			} else {
				constObj = Tab.insert(Obj.Con, constDecl.getConstName(), nodeStruct);
				constObj.setAdr(constDecl.getValue());
				report_info("Kreirana je konstanta " + getCurType() + " " + constDecl.getConstName(), constDecl);
			}
		}

	}

	@Override
	public void visit(ConstElementChar constDecl) {

		Struct nodeStruct = MyTab.charType;
		Obj constObj = Tab.find(constDecl.getConstName());

		if (constObj != Tab.noObj) {
			report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Ime " + constDecl.getConstName()
					+ " je vec deklarisano", constDecl);
		} else {
			if (!nodeStruct.equals(curType)) {
				report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Tip "
						+ tableUtils.typeOfStructNode(nodeStruct.getKind()) + " nije isti tip vrednosti kao i "
						+ getCurType(), constDecl);
			} else {
				constObj = Tab.insert(Obj.Con, constDecl.getConstName(), nodeStruct);
				constObj.setAdr(constDecl.getValue());
				report_info("Kreirana je konstanta " + getCurType() + " " + constDecl.getConstName(), constDecl);
			}
		}

	}

	@Override
	public void visit(ConstElementBooleanLast constDecl) {

		Struct nodeStruct = MyTab.boolType;
		Obj constObj = Tab.find(constDecl.getConstName());

		if (constObj != Tab.noObj) {
			report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Ime " + constDecl.getConstName()
					+ " je vec deklarisano", constDecl);
		} else {
			if (!nodeStruct.equals(curType)) {
				report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Tip "
						+ tableUtils.typeOfStructNode(nodeStruct.getKind()) + " nije isti tip vrednosti kao i "
						+ getCurType(), constDecl);
			} else {
				constObj = Tab.insert(Obj.Con, constDecl.getConstName(), nodeStruct);
				constObj.setAdr((constDecl.getValue() == true) ? 1 : 0);
				report_info("Kreirana je konstanta " + getCurType() + " " + constDecl.getConstName(), constDecl);
			}
		}

	}

	@Override
	public void visit(ConstElementNumberLast constDecl) {

		Struct nodeStruct = MyTab.intType;
		Obj constObj = Tab.find(constDecl.getConstName());

		if (constObj != Tab.noObj) {
			report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Ime " + constDecl.getConstName()
					+ " je vec deklarisano", constDecl);
		} else {
			if (!nodeStruct.equals(curType)) {
				report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Tip "
						+ tableUtils.typeOfStructNode(nodeStruct.getKind()) + " nije isti tip vrednosti kao i "
						+ getCurType(), constDecl);
			} else {
				constObj = Tab.insert(Obj.Con, constDecl.getConstName(), nodeStruct);
				constObj.setAdr(constDecl.getValue());
				report_info("Kreirana je konstanta " + getCurType() + " " + constDecl.getConstName(), constDecl);
			}
		}

	}

	@Override
	public void visit(ConstElementCharLast constDecl) {

		Struct nodeStruct = MyTab.charType;
		Obj constObj = Tab.find(constDecl.getConstName());

		if (constObj != Tab.noObj) {
			report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Ime " + constDecl.getConstName()
					+ " je vec deklarisano", constDecl);
		} else {
			if (!nodeStruct.equals(curType)) {
				report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Tip "
						+ tableUtils.typeOfStructNode(nodeStruct.getKind()) + " nije isti tip vrednosti kao i "
						+ getCurType(), constDecl);
			} else {
				constObj = Tab.insert(Obj.Con, constDecl.getConstName(), nodeStruct);
				constObj.setAdr(constDecl.getValue());
				report_info("Kreirana je konstanta " + getCurType() + " " + constDecl.getConstName(), constDecl);
			}
		}

	}

	@Override
	public void visit(ConstDeclClass decl) {
		curType = MyTab.noType;
	}

	boolean isArray = false;

	@Override
	public void visit(ArrayBracketsClass arr) {
		isArray = true;
	}

	@Override
	public void visit(VarDecElementClass varDecl) {
		if (MyTab.currentScope.findSymbol(varDecl.getVarName()) != null) {
			report_error("SEMANTICKA GRESKA: Ime promenljive " + varDecl.getVarName() + " je vec deklarisano", varDecl);
		} else {
			Struct tmp;
			tmp = isArray ? new Struct(Struct.Array, curType) : curType;
			Tab.insert(Obj.Var, varDecl.getVarName(), tmp);
			report_info("Kreirana je promenjiva " + getCurType() + " " + varDecl.getVarName() + (isArray ? "[]" : ""),
					varDecl);
		}
		isArray = false;
	}

	@Override
	public void visit(VarDecLastElementClass varDecl) {
		if (MyTab.currentScope.findSymbol(varDecl.getVarName()) != null) {
			report_error("SEMANTICKA GRESKA: Ime promenljive " + varDecl.getVarName() + " je vec deklarisano", varDecl);
		} else {
			Struct tmp;
			tmp = isArray ? new Struct(Struct.Array, curType) : curType;
			Tab.insert(Obj.Var, varDecl.getVarName(), tmp);
			report_info("Kreirana je promenjiva " + getCurType() + " " + varDecl.getVarName() + (isArray ? "[]" : ""),
					varDecl);
		}
		isArray = false;
	}

	@Override
	public void visit(VarDeclClass decl) {
		curType = MyTab.noType;
	}

	Obj curClass = MyTab.noObj;

	Stack<Obj> methodsDeclStack = new Stack<Obj>();

	Stack<Obj> methodsCallStack = new Stack<Obj>();

	@Override
	public void visit(ReturnMethodClass methDecl) {
		String name = methDecl.getName();
		Obj node = Tab.currentScope().findSymbol(name);
		if (node != null) {
			report_error("SEMANTICKA GRESKA: Ime metode ili funkcije " + name + " je ranije vec deklarisano", methDecl);
			MyTab.openScope(); // ili daj neki signal za gresku
		} else {
			node = Tab.insert(Obj.Meth, name, curType);
			MyTab.openScope();

			if (!curClass.equals(MyTab.noObj)) {
				Tab.insert(Obj.Var, "this", curClass.getType());
			}
			// curMethod = node;
			methodsDeclStack.push(node);
			report_info("Definicija " + (curClass.equals(MyTab.noObj) ? "funkcije " : "metode ") + getCurType() + " "
					+ name, methDecl);
			
			methDecl.obj = node;
		}
	}

	@Override
	public void visit(VoidMethodClass methDecl) {
		String name = methDecl.getName();
		Obj node = Tab.currentScope().findSymbol(name);
		if (node != null) {
			report_error("SEMANTICKA GRESKA: Ime metode ili funkcije " + name + " je ranije vec deklarisano", methDecl);
			MyTab.openScope(); // ili daj neki signal za gresku
		} else {
			node = Tab.insert(Obj.Meth, name, MyTab.noType);
			MyTab.openScope();

			if (!curClass.equals(MyTab.noObj)) {
				Tab.insert(Obj.Var, "this", curClass.getType());
				numOfFormPars++;
			}

			// curMethod = node;
			methodsDeclStack.push(node);
			report_info("Definicija " + (curClass.equals(MyTab.noObj) ? "funkcije " : "metode ") + getCurType() + " "
					+ name, methDecl);
			
			methDecl.obj = node;
		}
	}

	int numOfFormPars = 0;
	boolean hasMain = false;
	boolean hasReturn = false;

	@Override
	public void visit(MethodDeclClass methDecl) {
		Obj curMethod = methodsDeclStack.pop();
		if (!hasReturn && curMethod.getType() != Tab.noType) {
			report_error("SEMANTICKA GRESKA: Funcija " + curMethod.getName() + " nema return", methDecl);
		}

		curMethod.setLevel(numOfFormPars);
		Tab.chainLocalSymbols(curMethod);
		MyTab.closeScope();

		if (curMethod.getName().equals("main")) {
			hasMain = true;
		}

		// curMethod = MyTab.noObj;
		hasReturn = false;
		numOfFormPars = 0;
	}

	@Override
	public void visit(FormParsElement formPar) {
		numOfFormPars++;
		Obj curMethod = methodsDeclStack.peek();
		if (MyTab.currentScope.findSymbol(formPar.getNameForm()) != null) {
			report_error("SEMANTICKA GRESKA: Ime formalnog parametra " + getCurType() + " " + formPar.getNameForm()
					+ " je vec deklarisano", formPar);
		} else {

			// TODO Treba za konstruktor
			Struct tmp;
			tmp = isArray ? new Struct(Struct.Array, curType) : curType;
			Tab.insert(Obj.Var, formPar.getNameForm(), tmp);
			report_info("Kreirana je lokalna promenjiva " + getCurType() + " " + formPar.getNameForm()
					+ (isArray ? "[]" : ""), formPar);

		}
		isArray = false;
	}

	@Override
	public void visit(DesignatorClass designator) {
		designator.obj = MyTab.find(designator.getName());
		if (designator.obj == MyTab.noObj) {
			report_error("SEMANTICKA GRESKA: Nije deklarisana promenljiva " + designator.getName(), designator);
		} else {
			if (designator.obj.getKind() == Obj.Con) {
				report_info("Detektovan je pristup simbolickoj konstantni " + designator.obj.getName(), designator);
			}
		}

	}
	
	@Override
	public void visit(ArrDesignator designator) {
		designator.obj = designator.getDesignator().obj;
	}

	@Override
	public void visit(ArrayDesignatorClass designator) {
		Obj arrObj = designator.getArrDsignator().obj;
		if (arrObj.getType().getKind() != Struct.Array) {
			report_error("SEMANTICKA GRESKA: " + arrObj.getName() + " mora bit niz nekog tipa", designator);
			designator.obj = Tab.noObj;
		} else {
			if (designator.getExpr().struct != MyTab.intType) {
				designator.obj = Tab.noObj;
				report_error("SEMANTICKA GRESKA: Index niza mora bit tipa INT", designator);
			}
		}
		designator.obj = new Obj(Obj.Elem, arrObj.getName(), arrObj.getType().getElemType());
		report_info("Detektovan je pristup elemntu niza " + arrObj.getName(), designator);

	}

	// TODO ClassDesignatorClass

	@Override
	public void visit(MultipleFactorsTermClass term) {
		if (term.getFactor().struct != MyTab.intType || term.getTerm().struct != MyTab.intType) {
			report_error("SEMANTICKA GRESKA: Tip term i factor mora biti INT", term);
			term.struct = MyTab.noType;
		} else {
			term.struct = Tab.intType;
		}
	}

	@Override
	public void visit(SingleFactorTermClass term) {
		term.struct = term.getFactor().struct;
	}

	@Override
	public void visit(DesignatorFactorClass factor) {
		factor.struct = factor.getDesignator().obj.getType();
	}

	@Override
	public void visit(FuncCallDesignatorClass factor) {
		Obj designator = factor.getDesignator().obj;

		if (designator.getKind() != Obj.Meth) {
			report_error("SEMANTICKA GRESKA: " + factor.getDesignator().obj.getName() + " nije funkcija", factor);
			factor.struct = MyTab.noType;
		} else {
			factor.struct = factor.getDesignator().obj.getType();

			List<Struct> actParsList = actParsListStack.pop();
			List<Obj> formParList = new ArrayList<Obj>(designator.getLocalSymbols());

			int num_of_formal_parameters = designator.getLevel();

			if (num_of_formal_parameters != actParsList.size()) {
				report_error("SEMANTICKA GRESKA: " + designator.getName() + " broj formalnih parametara: "
						+ num_of_formal_parameters + "broj stvarnih parametara: " + actParsList.size(), factor);

			} else {
				for (int i = 0; i < num_of_formal_parameters; i++) {
					Struct rhs = actParsList.get(i);
					Struct lhs = formParList.get(i).getType();
					if (!rhs.assignableTo(lhs)) {
						report_error("SEMANTICKA GRESKA: Nepodudaranje tipova: " + getTypeOf(lhs.getKind()) + " = "
								+ getTypeOf(rhs.getKind()), factor);
					}

				}
			}

		}
		actParsList.clear();
	}

	@Override
	public void visit(NumberFactorClass factor) {
		factor.struct = MyTab.intType;
	}

	@Override
	public void visit(CharFactorClass factor) {
		factor.struct = MyTab.charType;
	}

	@Override
	public void visit(BoolFactorClass factor) {
		factor.struct = MyTab.boolType;
	}

	@Override
	public void visit(ExpFactorClass factor) {
		factor.struct = factor.getExpr().struct;

	}

	@Override
	public void visit(ArrayFactorClass factor) {
		if (factor.getExpr().struct != Tab.intType) {
			report_error("SEMANTICKA GRESKA: Index mora biti INT", factor);
			factor.struct = MyTab.noType;
		} else {
			factor.struct = new Struct(Struct.Array, factor.getType().struct);
		}
	}

	// TODO class Factor

	@Override
	public void visit(ExprClass expr) {
		if (!expr.getExpr().struct.compatibleWith(expr.getTerm().struct)) {
			expr.struct = Tab.noType;
			report_error("SEMANTICKA GRESKA: Sabirci nisu kompatibilni ", expr);
		} else {
			if (!expr.getExpr().struct.equals(MyTab.intType) || !expr.getTerm().struct.equals(MyTab.intType)) {
				report_error("SEMANTICKA GRESKA: Sabirci nisu INT ", expr);
			} else {
				expr.struct = MyTab.intType;
			}
		}
	}

	@Override
	public void visit(PositiveExprClass expr) {
		expr.struct = expr.getTerm().struct;
	}

	@Override
	public void visit(NegativeExprClass expr) {
		if (expr.getTerm().struct != Tab.intType) {
			report_error("SEMANTICKA GRESKA: Moguca je samo negacija izraza tipa INT", expr);
			expr.struct = Tab.noType;
		} else {
			// otherwise it must be int type
			expr.struct = Tab.intType;
		}
	}

	@Override
	public void visit(DesignatorStatementAssignClass statement) {
		Obj designator = statement.getDesignator().obj;
		if (designator.getKind() != Obj.Var && designator.getKind() != Obj.Fld && designator.getKind() != Obj.Elem) {
			report_error("SEMANTICKA GRESKA: Designator " + designator.getName()
					+ " mora oznacavati promenljivu, element niza ili polje ", statement);
		} else {
			Struct lhs = designator.getType();
			Struct rhs = statement.getExpr().struct;

			if (!rhs.assignableTo(lhs)) {
				report_error("SEMANTICKA GRESKA: Leva strana nije kompatibilna desnoj strani pri dodeli", statement);
			}
		}

	}

	Stack<List<Struct>> actParsListStack = new Stack<>();
	List<Struct> actParsList = new ArrayList<Struct>();

	@Override
	public void visit(DesignatorStatementFunctionClass statement) {
		List<Struct> actParsList = actParsListStack.pop();

		Obj designator = statement.getDesignator().obj;

		if (designator.getKind() != Obj.Meth) {
			report_error("SEMANTICKA GRESKA: " + designator.getName() + " nije funkcija", statement);
		} else {
			List<Obj> formParList = new ArrayList<Obj>(designator.getLocalSymbols());

			int num_of_formal_parameters = designator.getLevel();

			if (num_of_formal_parameters != actParsList.size()) {
				report_error(
						"SEMANTICKA GRESKA: " + designator.getName() + " broj formalnih parametara: "
								+ num_of_formal_parameters + "broj stvarnih parametara: " + actParsList.size(),
						statement);

			} else {
				for (int i = 0; i < num_of_formal_parameters; i++) {
					Struct rhs = actParsList.get(i);
					Struct lhs = formParList.get(i).getType();
					if (!rhs.assignableTo(lhs)) {
						report_error("SEMANTICKA GRESKA: Nepodudaranje tipova: " + getTypeOf(lhs.getKind()) + " = "
								+ getTypeOf(rhs.getKind()), statement);
					}

				}
			}

		}
		actParsList.clear();
	}

	@Override
	public void visit(ActParsFlag flag) {
		actParsListStack.add(new ArrayList<Struct>());
	}

	@Override
	public void visit(ActParsElement par) {
		par.struct = par.getExpr().struct;
		actParsListStack.peek().add(par.struct);
	}

	@Override
	public void visit(DesignatorStatementIncClass statement) {
		Obj designator = statement.getDesignator().obj;
		if (designator.getKind() != Obj.Var && designator.getKind() != Obj.Fld && designator.getKind() != Obj.Elem) {
			report_error("SEMANTICKA GRESKA: Designator " + designator.getName()
					+ " mora oznacavati promenljivu, element niza ili polje ", statement);
		} else {
			if (designator.getType() != MyTab.intType) {
				report_error("SEMANTICKA GRESKA: Designator " + designator.getName() + " mora biti tipa INT",
						statement);
			}
		}
	}

	@Override
	public void visit(DesignatorStatementDecClass statement) {
		Obj designator = statement.getDesignator().obj;
		if (designator.getKind() != Obj.Var && designator.getKind() != Obj.Fld && designator.getKind() != Obj.Elem) {
			report_error("SEMANTICKA GRESKA: Designator " + designator.getName()
					+ " mora oznacavati promenljivu, element niza ili polje ", statement);
		} else {
			if (designator.getType() != MyTab.intType) {
				report_error("SEMANTICKA GRESKA: Designator " + designator.getName() + " mora biti tipa INT",
						statement);
			}
		}
	}

	List<Obj> arrStatementDesignators = new ArrayList<>();

	@Override
	public void visit(DesignArrAssignmentClass designatorParent) {
		Obj designator = designatorParent.getDesignator().obj;
		if (designator.getKind() != Obj.Var && designator.getKind() != Obj.Fld && designator.getKind() != Obj.Elem) {
			report_error("SEMANTICKA GRESKA: Designator " + designator.getName()
					+ " mora oznacavati promenljivu, element niza ili polje ", designatorParent);
		} else {
			designatorParent.obj = designator;
			arrStatementDesignators.add(designator);
		}
	}

	@Override
	public void visit(DesignatorEpsilonClass designatorParent) {
		Obj designator = MyTab.noObj;
		designatorParent.obj = designator;
		arrStatementDesignators.add(designator);
	}

	@Override
	public void visit(DesignatorStatementArrayClass statement) {
		Obj rhs = statement.getDesignator().obj;
		if (rhs.getType().getKind() != Struct.Array) {
			report_error("SEMANTICKA GRESKA: Designator " + rhs.getName() + " mora biti niz ", statement);
		} else {
			for (Obj o : arrStatementDesignators) {
				if (o.equals(MyTab.noObj))
					continue;
				if (!rhs.getType().getElemType().assignableTo(o.getType())) {
					report_error("SEMANTICKA GRESKA:" + rhs.getName() + " se ne moze dodeliti " + o.getName(),
							statement);
				}
			}
		}
		arrStatementDesignators.clear();
	}

	@Override
	public void visit(ReadStatementClass statement) {
		Obj designator = statement.getDesignator().obj;
		if (designator.getKind() != Obj.Var && designator.getKind() != Obj.Fld && designator.getKind() != Obj.Elem) {
			report_error("SEMANTICKA GRESKA: Designator " + designator.getName()
					+ " mora oznacavati promenljivu, element niza ili polje ", statement);
		} else {
			if (!designator.getType().equals(MyTab.intType) && !designator.getType().equals(MyTab.charType)
					&& !designator.getType().equals(MyTab.boolType)) {
				report_error("SEMANTICKA GRESKA: Designator " + designator.getName()
						+ " mora oznacavati CHAR, INT ili BOOL ", statement);
			}
		}

	}

	@Override
	public void visit(PrintStatementClass statement) {
		Struct expr = statement.getExpr().struct;
		if (!expr.equals(MyTab.intType) && !expr.equals(MyTab.boolType) && !expr.equals(MyTab.charType)) {
			report_error("SEMANTICKA GRESKA: Expr u PRINT mora oznacavati CHAR, INT ili BOOL ", statement);
		}
	}

	@Override
	public void visit(ReturnStatementClass stm) {
		hasReturn = true;
		if (methodsDeclStack.isEmpty()) {
			report_error("SEMANTICKA GRESKA: RETURN ne sme biti van tela funkcije", stm);
		} else {
			Obj curMethod = methodsDeclStack.peek();

			if (curMethod.getType() != Tab.noType) {
				report_error("SEMANTICKA GRESKA: Funcija " + curMethod.getName() + " mora da vrati Expr", stm);
			}
		}
	}

	@Override
	public void visit(ReturnExprStatementClass stm) {
		hasReturn = true;
		if (methodsDeclStack.isEmpty()) {
			report_error("SEMANTICKA GRESKA: RETURN ne sme biti van tela funkcije", stm);
		} else {
			Obj curMethod = methodsDeclStack.peek();
			Struct returnType = stm.getExpr().struct;
			if (!curMethod.getType().equals(returnType)) {
				report_error("SEMANTICKA GRESKA: Funcija " + curMethod.getName() + " mora da vrati "
						+ getTypeOf(curMethod.getType().getKind()), stm);
			}
		}
	}

	@Override
	public void visit(CondFactClass cond) {
		Struct lhs = cond.getExpr().struct;
		Struct rhs = cond.getExpr1().struct;
		if (!lhs.compatibleWith(rhs)) {
			report_error("SEMANTICKA GRESKA: Expr moraju biti kompatibilni u CondFact", cond);
		}
		{
			if (lhs.getKind() == Struct.Array || lhs.getKind() == Struct.Class) {
				Relop relop = cond.getRelop();
				if (!(relop instanceof EqOpClass) || !(relop instanceof NeqOpClass)) {
					report_error("SEMANTICKA GRESKA: Nizovi i Klase se mogu porediti samo sa != ili ==", cond);
				}
			}
		}
	}

	@Override
	public void visit(SingleCondFactClass cond) {
		if (!cond.getExpr().struct.equals(MyTab.boolType)) {
			report_error("SEMANTICKA GRESKA: Condition mora biti tipa BOOL", cond);
		}
	}

	int loop_depth = 0;

	@Override
	public void visit(WhileFlag flag) {
		loop_depth++;
	}

	@Override
	public void visit(ForeachFlag flag) {
		loop_depth++;
	}

	@Override
	public void visit(BreakStatementClass stm) {
		if (loop_depth <= 0)
			report_error("SEMANTICKA GRESKA: BREAK se koristi samo unutar petlje", stm);
	}

	@Override
	public void visit(ContinueStatementClass stm) {
		if (loop_depth <= 0)
			report_error("SEMANTICKA GRESKA: CONTINUE se koristi samo unutar petlje", stm);
	}

	@Override
	public void visit(WhileStatementClass stm) {
		loop_depth--;
	}

	@Override
	public void visit(ForEachStatementClass stm) {
		loop_depth--;
		Obj designator = stm.getForeachFlag().getDesignator().obj;
		stm.getForeachFlag().obj = designator;

		if (designator.getType().getKind() != Struct.Array) {
			report_error("SEMANTICKA GRESKA: Designator u foreach petlje treba biti niz proizvoljnog tipa", stm);
		} else {
			Obj varNode = Tab.find(stm.getForeachIdent().getFeIdent());
			stm.getForeachIdent().obj = varNode;
			if (varNode.getKind() != Obj.Var) {
				report_error("SEMANTICKA GRESKA: Identifikator u foreach pelji mora biti promenljiva", stm);
			} else {
				if (!varNode.getType().equals(designator.getType().getElemType())) {
					report_error("SEMANTICKA GRESKA: Identifikator i niz moraju biti istog tipa", stm);
				}
			}
		}
	}
	

	public boolean errorDetected() {
		return errorDetected;
	}

}
