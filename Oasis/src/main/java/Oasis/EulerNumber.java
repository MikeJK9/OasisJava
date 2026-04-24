package Oasis;

public class EulerNumber extends Expression{

    EulerNumber(){
        super(ExpressionType.EulerNumber, ExpressionCategory.UnExp);

    }

    @Override
    public Expression Copy() {
        return new EulerNumber();
    }

    @Override
    public Expression Differentiate(Expression differentiationVariable) {
        return null;
    }

    @Override
    public boolean Equals(Expression other) {
        return false;
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
