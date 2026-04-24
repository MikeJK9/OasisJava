package Oasis;

public class Negate<OperandT extends Expression> extends UnaryExpression<Negate<OperandT>, OperandT>{

    Negate(){
        super(ExpressionType.Negate, ExpressionCategory.UnExp);
    }
    Negate(Negate<OperandT> other){
        super(ExpressionType.Negate, ExpressionCategory.UnExp);
        setOperand(other.getOperand());

    }
    public Negate(OperandT operand){
        super(ExpressionType.Negate, ExpressionCategory.UnExp);
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
