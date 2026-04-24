package Oasis;
import Oasis.Methods;
public class Add <AugendT extends Expression, AddendT extends Expression> extends BinaryExpression<Add<?,?>, AugendT, AddendT> {


    public Add(AugendT mostSigOp, AddendT leastSigOp) {

        super(mostSigOp, leastSigOp, ExpressionType.Add, ExpressionCategory.BinExp);

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
        BinaryExpression<?, Real, Real> realCase = m.recursiveCast(SimplifiedAdd, Real.class, Real.class);
        if(realCase != null){
            Real augend = realCase.getMostSigOp();
            Real addend = realCase.getLeastSigOp();
            return new Real(augend._value+addend._value);
        }

        BinaryExpression<?, Real, Expression> zeroCase = m.recursiveCast(SimplifiedAdd, Real.class, Expression.class);
        if(zeroCase != null && zeroCase.getMostSigOp()._value == 0){
            return zeroCase.getLeastSigOp().Generalize();
        }
        BinaryExpression<?, Multiply, Multiply> likeTermsCase = m.recursiveCast(SimplifiedAdd, Multiply.class, Multiply.class);
        if(likeTermsCase != null){
            Expression leftTerm = likeTermsCase.getMostSigOp().getLeastSigOp();
            Expression rightTerm = likeTermsCase.getLeastSigOp().getLeastSigOp();
            if(leftTerm.Equals(rightTerm)){
                Real coefficient1 = (Real) likeTermsCase.getMostSigOp().getMostSigOp();
                Real coefficient2 = (Real) likeTermsCase.getLeastSigOp().getMostSigOp();

                return new Multiply<>(new Real(coefficient1._value+coefficient2._value), leftTerm);
            }
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

