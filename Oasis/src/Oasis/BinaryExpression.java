package Oasis;

public class BinaryExpression<DerivedT extends Expression,
        MostSigOpT extends Expression, LeastSigOpT extends Expression> extends Expression{
    private MostSigOpT MostSigOp;
    private LeastSigOpT LeastSigOp;
    BinaryExpression(MostSigOpT mostSigOp, LeastSigOpT leastSigOp)
    {
        setMostSigOp(mostSigOp);
        setLeastSigOp(leastSigOp);
    }
    BinaryExpression(BinaryExpression<Expression, MostSigOpT, LeastSigOpT> binExp)
    {
        setMostSigOp(binExp.MostSigOp);
        setLeastSigOp(binExp.LeastSigOp);
    }
    MostSigOpT getMostSigOp(){
        return MostSigOp;
    }

    LeastSigOpT getLeastSigOp(){
        return LeastSigOp;
    }

    void setMostSigOp(MostSigOpT e){
        MostSigOp = e;
    }

    void setLeastSigOp(LeastSigOpT e){
        LeastSigOp = e;
    }

    BinaryExpression<?,?,?> swapOperands(){
        return new BinaryExpression<DerivedT, LeastSigOpT, MostSigOpT>(LeastSigOp,MostSigOp);
    }

    //TODO: implement the following
    @Override
    public Expression Copy() {
        return null;
    }

    @Override
    public Expression Differentiate(Expression differentiationVariable) {
        return null;
    }

    @Override
    public boolean Equals() {
        return false;
    }

    @Override
    public long getCategory() {
        return 0;
    }

    @Override
    public ExpressionType getType() {
        return null;
    }

    @Override
    public Expression Generalize() {
        return null;
    }

    @Override
    public Expression Integrate(Expression integrationVariable) {
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
    public Expression Substitute(Expression var, Expression val) {
        return null;
    }

    @Override
    protected Visit AcceptInternal(Visitor visitor) {
        return null;
    }
}

