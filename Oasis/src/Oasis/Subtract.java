package Oasis;
import Oasis.Methods;
public class Subtract <MinuendT extends Expression, SubtruendT extends Expression> extends BinaryExpression<Subtract<?,?>, MinuendT, SubtruendT> {
    ExpressionType Type = ExpressionType.Subtract;
    ExpressionCategory Cat = ExpressionCategory.BinExp;

    public Subtract(MinuendT mostSigOp, SubtruendT leastSigOp) {
        super(mostSigOp, leastSigOp);
    }
    Subtract(BinaryExpression<?, ? extends MinuendT, ? extends SubtruendT> binExp){
        super(binExp);
    }

    public Expression Simplify(){
        Expression SimplifiedMinuend;
        Expression SimplifiedSubtruend;
        if(getMostSigOp() != null) {
            SimplifiedMinuend = getMostSigOp().Simplify();
        }
        else{
            SimplifiedMinuend = null;
        }
        if(getLeastSigOp() != null) {
            SimplifiedSubtruend = getLeastSigOp().Simplify();
        }
        else{
            SimplifiedSubtruend= null;
        }
        Subtract<Expression,Expression> SimplifiedSubtract = new Subtract<Expression,Expression>(SimplifiedMinuend, SimplifiedSubtruend);

        Methods<UnaryExpression<Expression, Expression>, BinaryExpression<Expression, Expression, Expression>> m = new Methods<>();
        BinaryExpression<Expression, Real, Real> realCase = m.recursiveCast(SimplifiedSubtract, ExpressionCategory.BinExp.value);
        if(realCase != null){
            Real minuend = realCase.getMostSigOp();
            Real subtruend = realCase.getLeastSigOp();
            return new Real(minuend._value-subtruend._value);
        }

        BinaryExpression<Expression, Real, Expression> zeroCase = m.recursiveCast(SimplifiedSubtract, ExpressionCategory.BinExp.value);
        if(zeroCase != null && zeroCase.getMostSigOp()._value == 0){
            return zeroCase.getLeastSigOp().Generalize();
        }
        Subtract<Multiply<Real, Expression>, Multiply<Real, Expression>> likeTermsCase = m.recursiveCast(SimplifiedSubtract, ExpressionCategory.BinExp.value);
        if(likeTermsCase != null){
            Expression leftTerm = likeTermsCase.getMostSigOp().getLeastSigOp();
            Expression rightTerm = likeTermsCase.getLeastSigOp().getLeastSigOp();
            if(leftTerm == rightTerm){
                Real coefficient1 = likeTermsCase.getMostSigOp().getMostSigOp();
                Real coefficient2 = likeTermsCase.getLeastSigOp().getMostSigOp();
                return new Multiply<Expression, Real>(leftTerm, new Real(coefficient1._value-coefficient2._value));
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

