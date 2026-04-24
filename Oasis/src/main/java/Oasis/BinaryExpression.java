package Oasis;

public class BinaryExpression<DerivedT extends Expression,
        MostSigOpT extends Expression, LeastSigOpT extends Expression> extends Expression{
    private MostSigOpT MostSigOp;
    private LeastSigOpT LeastSigOp;

    protected BinaryExpression(MostSigOpT mostSigOp, LeastSigOpT leastSigOp, ExpressionType type, ExpressionCategory cat) {
        super(type, cat);
        setMostSigOp(mostSigOp);
        setLeastSigOp(leastSigOp);
    }

    BinaryExpression(){
        super(ExpressionType.None, ExpressionCategory.BinExp);

    }
    BinaryExpression(MostSigOpT mostSigOp, LeastSigOpT leastSigOp)
    {
        super(ExpressionType.None, ExpressionCategory.BinExp);
        setMostSigOp(mostSigOp);
        setLeastSigOp(leastSigOp);
    }
    BinaryExpression(BinaryExpression<?, ? extends MostSigOpT, ? extends LeastSigOpT> binExp)
    {
        super(ExpressionType.None, ExpressionCategory.BinExp);
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
    public boolean Equals(Expression other) {
        if (!(other instanceof BinaryExpression<?,?,?> otherBin)) return false;
        if (other.getType() != getType()) return false;

        if(!(getCategory() == ExpressionCategory.Commutative.value)) {
            return getMostSigOp().Equals(otherBin.getMostSigOp()) &&
                    getLeastSigOp().Equals(otherBin.getLeastSigOp());
        }
        boolean equal = (getMostSigOp().Equals(otherBin.getMostSigOp()) &&
                getLeastSigOp().Equals(otherBin.getLeastSigOp()) ) ||
                (getMostSigOp().Equals(otherBin.getLeastSigOp()) &&
                        getLeastSigOp().Equals(otherBin.getMostSigOp()));
        return equal;
    }

    @Override
    public Expression Generalize() {
        return this;
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

