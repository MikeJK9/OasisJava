package Oasis;

public class Add <AugendT extends Expression, AddendT extends Expression> extends BinaryExpression<Add<?,?>, AugendT, AddendT> {

    Add(AugendT mostSigOp, AddendT leastSigOp) {
        super(mostSigOp, leastSigOp);
    }

}

