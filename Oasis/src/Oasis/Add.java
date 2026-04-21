package Oasis;
import Oasis.Methods;
public class Add <AugendT extends Expression, AddendT extends Expression> extends BinaryExpression<Add<?,?>, AugendT, AddendT> {
    AugendT Augend;
    AddendT Addend;

    public Add(AugendT mostSigOp, AddendT leastSigOp) {
        super(mostSigOp, leastSigOp);
    }
    Add(BinaryExpression<?, ? extends AugendT, ? extends AddendT> binExp){
        super(binExp);
    }

    public Expression Simplify(){
        Expression SimplifiedAugend;
        Expression SimplifiedAddend;
        if(getMostSigOp() != null) {
            SimplifiedAugend = getMostSigOp().Simplify();
        }
        else{
            SimplifiedAugend = null;
        }
        if(getLeastSigOp() != null) {
            SimplifiedAddend = getLeastSigOp().Simplify();
        }
        else{
            SimplifiedAddend = null;
        }
        Add<Expression,Expression> SimplifiedAdd = new Add<Expression,Expression>(SimplifiedAugend, SimplifiedAddend);

        Methods<UnaryExpression<Expression, Expression>, BinaryExpression<Expression, Expression, Expression>> m = new Methods<>();
        BinaryExpression<Expression, Real, Real> realCase = m.recursiveCast(SimplifiedAdd, ExpressionCategory.BinExp.value);
        if(realCase != null){
            Real augend = realCase.getMostSigOp();
            Real addend = realCase.getLeastSigOp();
            return new Real(augend._value+addend._value);
        }

        BinaryExpression<Expression, Real, Expression> zeroCase = m.recursiveCast(SimplifiedAdd, ExpressionCategory.BinExp.value);
        if(zeroCase != null && zeroCase.getMostSigOp()._value == 0){
            return zeroCase.getLeastSigOp().Generalize();
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

