package Oasis;

public class Add <AugendT extends Expression, AddendT extends Expression> extends BinaryExpression<Add<?,?>, AugendT, AddendT> {

    Add(AugendT mostSigOp, AddendT leastSigOp) {
        super(mostSigOp, leastSigOp);
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
        Add<Expression,Expression> SimplifiedAdd = new Add<Expression,Expression>(SimplifiedAddend, SimplifiedAddend);

    }

}

