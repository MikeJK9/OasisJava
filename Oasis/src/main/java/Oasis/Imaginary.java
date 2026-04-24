package Oasis;

public class Imaginary extends Expression{

    public Imaginary(){
        super(ExpressionType.Imaginary, ExpressionCategory.UnExp);

        //todo- constructor
    }
    public Imaginary(Imaginary other){
        super(ExpressionType.Imaginary, ExpressionCategory.UnExp);

        //todo- copy constructor
    }

    @Override
    public boolean Equals(Expression other){
        return other.getType().equals(ExpressionType.Imaginary);
    }

    @Override
    public Expression Copy() {
        return new Imaginary();
    }

    @Override
    public Expression Differentiate(Expression differentiationVariable) {
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

    /*
    EXPRESSION_TYPE(Imaginary)
    EXPRESSION_CATEGORY(UnExp)

     */

}
