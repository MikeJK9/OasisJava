package Oasis;

public class LeafExpression <DerivedT> extends Expression{
    @Override
    public Expression Copy() {
        //TODO
        return null;
    }

    @Override
    public Expression Differentiate(Expression differentiationVariable) {
        return Generalize().Differentiate(differentiationVariable);
    }

    @Override
    public boolean Equals(Expression other) {
        //TODO
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
        return Generalize().Integrate(integrationVariable);
    }

    @Override
    public Expression IntegrateWithBounds(Expression variable, Expression lower, Expression upper) {
        return Generalize().IntegrateWithBounds(variable, lower, upper);
    }

    @Override
    public Expression Simplify() {
        //TODO
        return null;
    }

    @Override
    public boolean StructurallyEquivalent(Expression other) {
        return this.getType().equals(other.getType());
    }

    @Override
    public Expression Substitute(Expression var, Expression val) {
        return this.Copy();
    }

    @Override
    protected Visit AcceptInternal(Visitor visitor) {
        Expression Generalized = Generalize();
        /*
        TODO: implement me!  DerivedT and Visit needed
        const auto generalized = Generalize();
        const auto& derivedGeneralized = dynamic_cast<const DerivedT&>(*generalized);
        return visitor.Visit(derivedGeneralized);

         */
        return null;
    }
}
