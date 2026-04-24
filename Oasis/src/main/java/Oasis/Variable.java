package Oasis;

public class Variable extends Expression{

    String _name;
    public Variable(String name){
        super(ExpressionType.Variable, ExpressionCategory.UnExp);
        _name = name;

        //todo: check if we need to move name like in original c++ code
    }

    @Override
    public boolean Equals(Expression other){
        if(other instanceof Variable){
            return ((Variable)other)._name.equals(_name);
        }
        return false;
    }
    public String GetName(){
        return _name;
    }
    //todo: finish integrate, differentiate, substitute
    public Expression Integrate(Expression integrationVariable){
        return null;
    }

    @Override
    public Expression IntegrateWithBounds(Expression variable, Expression lower, Expression upper) {
        return null;
    }

    @Override
    public Expression Simplify() {
        return null;
    }

    @Override
    public boolean StructurallyEquivalent(Expression other) {
        return false;
    }

    @Override
    public Expression Copy() {
        return null;
    }

    public Expression Differentiate(Expression differentiationVariable){
        return null;
    }



    @Override
    public Expression Generalize() {
        return this;
    }

    public Expression Substitute(Expression var, Expression val){
        Methods<UnaryExpression<Expression, Expression>, BinaryExpression<Expression, Expression, Expression>> m = new Methods<>();

        Variable varClone = m.recursiveCast(var, Variable.class);
        if(varClone == null){
            System.out.println("Variable was not a variable.");
            return null;
        }
        if (varClone.GetName().equals(GetName())) {
            return val.Copy();
        }
        return Copy();
    }

    @Override
    protected Visit AcceptInternal(Visitor visitor) {
        return null;
    }
}
