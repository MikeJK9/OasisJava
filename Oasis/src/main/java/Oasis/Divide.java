package Oasis;
import Oasis.Methods;
public class Divide <DividendT extends Expression, DivisorT extends Expression> extends BinaryExpression<Multiply<?,?>, DividendT, DivisorT> {


    public Divide(DividendT mostSigOp, DivisorT leastSigOp) {
        super(mostSigOp, leastSigOp, ExpressionType.Divide, ExpressionCategory.BinExp);

    }
    Divide(BinaryExpression<?, ? extends DividendT, ? extends DivisorT> binExp){
        super(binExp);
    }

    public Expression Simplify(){
        Expression SimplifiedDividend;
        Expression SimplifiedDivisor;
        if(getMostSigOp() != null) {
            SimplifiedDividend = getMostSigOp().Simplify();
        }
        else{
            SimplifiedDividend = null;
        }
        if(getLeastSigOp() != null) {
            SimplifiedDivisor = getLeastSigOp().Simplify();
        }
        else{
            SimplifiedDivisor = null;
        }
        Multiply<Expression,Expression> SimplifiedDiv = new Multiply<Expression,Expression>(SimplifiedDividend, SimplifiedDivisor);

        Methods<UnaryExpression<Expression, Expression>, BinaryExpression<Expression, Expression, Expression>> m = new Methods<>();
        BinaryExpression<?, Real, Real> realCase = m.recursiveCast(SimplifiedDiv, Real.class, Real.class);
        if(realCase != null){
            Real dividend = realCase.getMostSigOp();
            Real divisor = realCase.getLeastSigOp();
            if(divisor._value == 0){
                return new Real(Double.MAX_VALUE);
            }
            return new Real(dividend._value/divisor._value);
        }

        BinaryExpression<?, Real, Expression> zeroCase = m.recursiveCast(SimplifiedDiv, Real.class, Expression.class);
        if(zeroCase != null && zeroCase.getMostSigOp()._value == 0){
            return new Real(0);
        }
        BinaryExpression<?, Expression, Real> divByZeroCase = m.recursiveCast(SimplifiedDiv, Expression.class, Real.class);
        if(divByZeroCase != null && divByZeroCase.getLeastSigOp()._value == 0){
            return new Real(Double.MAX_VALUE);
        }
        if(true/*LIKE TERMS CASE*/){

        }

        if(true/*MATRIX PLUS MATRIX CASE*/){

        }
        if(true/*LOG A PLUS LOG B == LOG AB CASE*/){

        }
        if(true/*X PLUS X == 2X CASE*/){

        }
        if(true/*2X PLUS X == 3X CASE*/){

        }

        return this;
        //simplify expressions and combine like terms:
    }

}

