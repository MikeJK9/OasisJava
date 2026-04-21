package Oasis;
import Oasis.Methods;
public class Multiply <MultiplicandT extends Expression, MultiplierT extends Expression> extends BinaryExpression<Multiply<?,?>, MultiplicandT, MultiplierT> {
    ExpressionType Type = ExpressionType.Multiply;
    ExpressionCategory Cat = ExpressionCategory.BinExp;

    public Multiply(MultiplicandT mostSigOp, MultiplierT leastSigOp) {
        super(mostSigOp, leastSigOp);
    }
    Multiply(BinaryExpression<?, ? extends MultiplicandT, ? extends MultiplierT> binExp){
        super(binExp);
    }

    public Expression Simplify(){
        Expression SimplifiedMultiplicand;
        Expression SimplifiedMultiplier;
        if(getMostSigOp() != null) {
            SimplifiedMultiplicand = getMostSigOp().Simplify();
        }
        else{
            SimplifiedMultiplicand = null;
        }
        if(getLeastSigOp() != null) {
            SimplifiedMultiplier = getLeastSigOp().Simplify();
        }
        else{
            SimplifiedMultiplier = null;
        }
        Multiply<Expression,Expression> SimplifiedMult = new Multiply<Expression,Expression>(SimplifiedMultiplicand, SimplifiedMultiplier);

        Methods<UnaryExpression<Expression, Expression>, BinaryExpression<Expression, Expression, Expression>> m = new Methods<>();
        BinaryExpression<Expression, Real, Real> realCase = m.recursiveCast(SimplifiedMult, ExpressionCategory.BinExp.value);
        if(realCase != null){
            Real augend = realCase.getMostSigOp();
            Real addend = realCase.getLeastSigOp();
            return new Real(augend._value*addend._value);
        }

        BinaryExpression<Expression, Real, Expression> zeroCase = m.recursiveCast(SimplifiedMult, ExpressionCategory.BinExp.value);
        if(zeroCase != null && zeroCase.getMostSigOp()._value == 0){
            return new Real(0);
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

