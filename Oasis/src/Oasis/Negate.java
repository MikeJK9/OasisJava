package Oasis;

public class Negate<OperandT extends Expression> extends UnaryExpression<Negate<OperandT>, OperandT>{
    ExpressionType Type = ExpressionType.Negate;
    ExpressionCategory Cat = ExpressionCategory.UnExp;
    Negate(){

    }
    Negate(Negate<OperandT> other){
        setOperand(other.getOperand());
    }
    public Negate(OperandT operand){
        setOperand(operand);
    }

    @Override
    public Expression Simplify(){
        return (new Multiply<Real, OperandT>(new Real(-1.0), getOperand())).Simplify();
    }
    @Override
    public Expression Differentiate(Expression other){
        Expression operandDerivative = getOperand().Differentiate(other);
        return (new Negate<Expression>(operandDerivative)).Simplify();
    }

}
