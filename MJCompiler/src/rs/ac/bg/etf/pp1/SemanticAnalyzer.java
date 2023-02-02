package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;


public class SemanticAnalyzer extends VisitorAdaptor {
	
	boolean errorDetected = false;
	Struct curType = Tab.noType;
	
	
	
	Logger log = Logger.getLogger(getClass());
	
	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
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
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
	}
	
	@Override
	public void visit() {}
	
	@Override
	public void visit(TypeClass type) {
		Obj typeObj = Tab.find(type.getName());
		
		if (typeObj == Tab.noObj) {
			report_error("SEMANTICKA GRESKA [" + type.getLine() + "]: Nije pronadjen tip " + type.getName() + " u tabeli simbola", type);
			type.struct = Tab.noType;
		}else{
			if (Obj.Type == typeObj.getKind()) {
				type.struct = typeObj.getType();
			} else {
				type.struct = Tab.noType;
				report_error("SEMANTICKA GRESKA[" + type.getLine() + "]: Ime " + type.getName() + " ne predstavlja tip ", type);
			}
			
			//KLASE
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
		
		if(constObj != Tab.noObj) {
			report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Ime " + constDecl.getConstName() + " je vec deklarisano", constDecl);
		} else {
			if(!nodeStruct.equals(curType)) {
				report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Tip " + tableUtils.typeOfStructNode(nodeStruct.getKind()) + " nije isti tip vrednosti kao i " + tableUtils.typeOfStructNode(curType.getKind()), constDecl);
			}else {
				constObj = Tab.insert(Obj.Con, constDecl.getConstName(), nodeStruct);
				constObj.setAdr((constDecl.getValue() == true)? 1:0);
				report_info("Kreirana je konstanta " + tableUtils.typeOfStructNode(curType.getKind()) + " " +constDecl.getConstName(), constDecl);
			}
		}
		
	}
	
	@Override
	public void visit(ConstElementNumber constDecl) {
		
		Struct nodeStruct = MyTab.intType;
		Obj constObj = Tab.find(constDecl.getConstName());
		
		if(constObj != Tab.noObj) {
			report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Ime " + constDecl.getConstName() + " je vec deklarisano", constDecl);
		} else {
			if(!nodeStruct.equals(curType)) {
				report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Tip " + tableUtils.typeOfStructNode(nodeStruct.getKind()) + " nije isti tip vrednosti kao i " + tableUtils.typeOfStructNode(curType.getKind()), constDecl);
			}else {
				constObj = Tab.insert(Obj.Con, constDecl.getConstName(), nodeStruct);
				constObj.setAdr(constDecl.getValue());
				report_info("Kreirana je konstanta " + tableUtils.typeOfStructNode(curType.getKind()) + " " +constDecl.getConstName(), constDecl);
			}
		}
		
	}
	
	@Override
	public void visit(ConstElementChar constDecl) {
		
		Struct nodeStruct = MyTab.charType;
		Obj constObj = Tab.find(constDecl.getConstName());
		
		if(constObj != Tab.noObj) {
			report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Ime " + constDecl.getConstName() + " je vec deklarisano", constDecl);
		} else {
			if(!nodeStruct.equals(curType)) {
				report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Tip " + tableUtils.typeOfStructNode(nodeStruct.getKind()) + " nije isti tip vrednosti kao i " + tableUtils.typeOfStructNode(curType.getKind()), constDecl);
			}else {
				constObj = Tab.insert(Obj.Con, constDecl.getConstName(), nodeStruct);
				constObj.setAdr(constDecl.getValue());
				report_info("Kreirana je konstanta " + tableUtils.typeOfStructNode(curType.getKind()) + " " +constDecl.getConstName(), constDecl);
			}
		}
		
	}
	
	@Override
	public void visit(ConstElementBooleanLast constDecl) {
		
		Struct nodeStruct = MyTab.boolType;
		Obj constObj = Tab.find(constDecl.getConstName());
		
		if(constObj != Tab.noObj) {
			report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Ime " + constDecl.getConstName() + " je vec deklarisano", constDecl);
		} else {
			if(!nodeStruct.equals(curType)) {
				report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Tip " + tableUtils.typeOfStructNode(nodeStruct.getKind()) + " nije isti tip vrednosti kao i " + tableUtils.typeOfStructNode(curType.getKind()), constDecl);
			}else {
				constObj = Tab.insert(Obj.Con, constDecl.getConstName(), nodeStruct);
				constObj.setAdr((constDecl.getValue() == true)? 1:0);
				report_info("Kreirana je konstanta " + tableUtils.typeOfStructNode(curType.getKind()) + " " +constDecl.getConstName(), constDecl);
			}
		}
		
	}
	
	@Override
	public void visit(ConstElementNumberLast constDecl) {
		
		Struct nodeStruct = MyTab.intType;
		Obj constObj = Tab.find(constDecl.getConstName());
		
		if(constObj != Tab.noObj) {
			report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Ime " + constDecl.getConstName() + " je vec deklarisano", constDecl);
		} else {
			if(!nodeStruct.equals(curType)) {
				report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Tip " + tableUtils.typeOfStructNode(nodeStruct.getKind()) + " nije isti tip vrednosti kao i " + tableUtils.typeOfStructNode(curType.getKind()), constDecl);
			}else {
				constObj = Tab.insert(Obj.Con, constDecl.getConstName(), nodeStruct);
				constObj.setAdr(constDecl.getValue());
				report_info("Kreirana je konstanta " + tableUtils.typeOfStructNode(curType.getKind()) + " " +constDecl.getConstName(), constDecl);
			}
		}
		
	}
	
	@Override
	public void visit(ConstElementCharLast constDecl) {
		
		Struct nodeStruct = MyTab.charType;
		Obj constObj = Tab.find(constDecl.getConstName());
		
		if(constObj != Tab.noObj) {
			report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Ime " + constDecl.getConstName() + " je vec deklarisano", constDecl);
		} else {
			if(!nodeStruct.equals(curType)) {
				report_error("SEMANTICKA GRESKA[" + constDecl.getLine() + "]: Tip " + tableUtils.typeOfStructNode(nodeStruct.getKind()) + " nije isti tip vrednosti kao i " + tableUtils.typeOfStructNode(curType.getKind()), constDecl);
			}else {
				constObj = Tab.insert(Obj.Con, constDecl.getConstName(), nodeStruct);
				constObj.setAdr(constDecl.getValue());
				report_info("Kreirana je konstanta " + tableUtils.typeOfStructNode(curType.getKind()) + " " +constDecl.getConstName(), constDecl);
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
		if(MyTab.currentScope.findSymbol(varDecl.getVarName()) != null) {
			report_error("SEMANTICKA GRESKA: Ime promenljive " + varDecl.getVarName() + " je vec deklarisano", varDecl);
		}else {
			Struct tmp;
			tmp = isArray ? new Struct(Struct.Array, curType) : curType;
			Tab.insert(Obj.Var, varDecl.getVarName(), tmp);
			report_info("Kreirana je promenjiva " + tableUtils.typeOfStructNode(curType.getKind()) + " " + varDecl.getVarName()+ (isArray?"[]":""), varDecl);
		}
	}
		
	@Override
	public void visit(VarDecLastElementClass varDecl) {
		if(MyTab.currentScope.findSymbol(varDecl.getVarName()) != null) {
			report_error("SEMANTICKA GRESKA: Ime promenljive " + varDecl.getVarName() + " je vec deklarisano", varDecl);
		}else {
			Struct tmp;
			tmp = isArray ? new Struct(Struct.Array, curType) : curType;
			Tab.insert(Obj.Var, varDecl.getVarName(), tmp);
			report_info("Kreirana je promenjiva " + tableUtils.typeOfStructNode(curType.getKind()) + " " + varDecl.getVarName() + (isArray?"[]":""), varDecl);
		}
	}
	
	@Override
	public void visit(VarDeclClass decl) {
		curType = MyTab.noType;
		isArray = false;
	}
	
	Obj curClass = MyTab.noObj;
	
	Map<Obj, List<Struct>> methods = new HashMap<Obj, List<Struct>>(); 
	
	Obj curMethod = MyTab.noObj;
	
	@Override
	public void visit(ReturnMethodClass methDecl) {
		String name = methDecl.getName();
		Obj node = Tab.currentScope().findSymbol(name);
		if(node != null) {
			report_error("SEMANTICKA GRESKA: Ime metode ili funkcije " + name + " je ranije vec deklarisano", methDecl);
			MyTab.openScope(); //ili daj neki signal za gresku
		}else {
			node = Tab.insert(Obj.Meth, name, curType);
			MyTab.openScope();
			
			if(!curClass.equals(MyTab.noObj)) {
				Tab.insert(Obj.Var, "this", curClass.getType());
			}
			
			methods.put(node, new ArrayList<>());
			curMethod = node;
			report_info("Definicija " + (curClass.equals(MyTab.noObj)?"funkcije ":"metode ") + tableUtils.typeOfStructNode(curType.getKind()) + name, methDecl);
		}
	}
	
	@Override
	public void visit(VoidMethodClass methDecl) {
		String name = methDecl.getName();
		Obj node = Tab.currentScope().findSymbol(name);
		if(node != null) {
			report_error("SEMANTICKA GRESKA: Ime metode ili funkcije " + name + " je ranije vec deklarisano", methDecl);
			MyTab.openScope(); //ili daj neki signal za gresku
		}else {
			node = Tab.insert(Obj.Meth, name, MyTab.noType);
			MyTab.openScope();
			
			if(!curClass.equals(MyTab.noObj)) {
				Tab.insert(Obj.Var, "this", curClass.getType());
				numOfFormPars++;
			}
			
			methods.put(node, new ArrayList<>());
			curMethod = node;
			report_info("Definicija " + (curClass.equals(MyTab.noObj)?"funkcije ":"metode ") + tableUtils.typeOfStructNode(curType.getKind()) + name, methDecl);
		}
	}
	
	int numOfFormPars = 0;
	boolean hasMain;
	boolean hasReturn = false;
	
	@Override
	public void visit(MethodDeclClass methDecl) {
		
		if (!hasReturn && curMethod.getType() != Tab.noType) {
			report_error("SEMANTICKA GRESKA: Funcija " + curMethod.getName() + " nema return", methDecl);
		}
		
		curMethod.setLevel(numOfFormPars);
		Tab.chainLocalSymbols(curMethod);
		MyTab.closeScope();
		
		if (curMethod.getName().equals("main")) {
			hasMain = true;
		}
		
		curMethod = MyTab.noObj;
		hasReturn = false;
		numOfFormPars = 0;
	}
	
	
	
	
	public boolean errorDetected() {
		return errorDetected;
	}

}
