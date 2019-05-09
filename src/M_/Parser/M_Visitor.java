// Generated from D:/Compiler/codes/trial_1/src/M_\M_.g4 by ANTLR 4.7.2
package M_.Parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link M_Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface M_Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link M_Parser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(M_Parser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#program_unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram_unit(M_Parser.Program_unitContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#variable_defination}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_defination(M_Parser.Variable_definationContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#init_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit_expr(M_Parser.Init_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#malloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMalloc(M_Parser.MallocContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#empty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty(M_Parser.EmptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#variable_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_name(M_Parser.Variable_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#class_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_type(M_Parser.Class_typeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link M_Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(M_Parser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link M_Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(M_Parser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link M_Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(M_Parser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code void}
	 * labeled alternative in {@link M_Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoid(M_Parser.VoidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code others}
	 * labeled alternative in {@link M_Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOthers(M_Parser.OthersContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#class_defination}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_defination(M_Parser.Class_definationContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#class_function_defination}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_function_defination(M_Parser.Class_function_definationContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#class_init_fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_init_fun(M_Parser.Class_init_funContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#function_defination}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_defination(M_Parser.Function_definationContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#func_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_name(M_Parser.Func_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(M_Parser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(M_Parser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(M_Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(M_Parser.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#declation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclation(M_Parser.DeclationContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(M_Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#emptye}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptye(M_Parser.EmptyeContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#expr_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_statement(M_Parser.Expr_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pos_neg}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPos_neg(M_Parser.Pos_negContext ctx);
	/**
	 * Visit a parse tree produced by the {@code add}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(M_Parser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalnot}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalnot(M_Parser.LogicalnotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compare}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(M_Parser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constant}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(M_Parser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mul}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(M_Parser.MulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefix}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix(M_Parser.PrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitor}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitor(M_Parser.BitorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code class_func}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_func(M_Parser.Class_funcContext ctx);
	/**
	 * Visit a parse tree produced by the {@code index}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex(M_Parser.IndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitshift}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitshift(M_Parser.BitshiftContext ctx);
	/**
	 * Visit a parse tree produced by the {@code func_call}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_call(M_Parser.Func_callContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logical}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical(M_Parser.LogicalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equal}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(M_Parser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code this_}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThis_(M_Parser.This_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code bitand}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitand(M_Parser.BitandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitxor}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitxor(M_Parser.BitxorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(M_Parser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code class_member}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_member(M_Parser.Class_memberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code new_st}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_st(M_Parser.New_stContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blanket}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlanket(M_Parser.BlanketContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfix}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfix(M_Parser.PostfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitnot}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitnot(M_Parser.BitnotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link M_Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(M_Parser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(M_Parser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string_const}
	 * labeled alternative in {@link M_Parser#const_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_const(M_Parser.String_constContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integer}
	 * labeled alternative in {@link M_Parser#const_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(M_Parser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code true}
	 * labeled alternative in {@link M_Parser#const_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue(M_Parser.TrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code false}
	 * labeled alternative in {@link M_Parser#const_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse(M_Parser.FalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code null}
	 * labeled alternative in {@link M_Parser#const_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull(M_Parser.NullContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#if_else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_else(M_Parser.If_elseContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#while_stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stm(M_Parser.While_stmContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#for_stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stm(M_Parser.For_stmContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(M_Parser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate(M_Parser.UpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#termanite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermanite(M_Parser.TermaniteContext ctx);
	/**
	 * Visit a parse tree produced by {@link M_Parser#return_stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stm(M_Parser.Return_stmContext ctx);
}