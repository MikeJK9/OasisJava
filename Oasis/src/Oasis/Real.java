package Oasis;

public class Real extends Expression{
    ExpressionType Type = ExpressionType.Real;
    ExpressionCategory Cat = ExpressionCategory.UnExp;

    double _value;
    public Real(double value){
        _value = value;
    }
    public Real Differentiate(){
        return new Real(0);
    }
    public boolean Equals(Expression other){
        if(other instanceof Real){
            return ((Real)other)._value == _value;
        }
        return false;
    }
    public double GetValue(){
        return _value;
    }

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

    //todo: finish integrate
    public Expression Integrate(Expression integrationVariable){
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
/*
auto Real::Integrate(const Expression& integrationVariable) const -> std::unique_ptr<Expression>
{
    if (auto variable = RecursiveCast<Variable>(integrationVariable); variable != nullptr) {
        // Constant rule
        if (value != 0) {

            Add adder {
                Multiply<Real, Variable> { Real { value }, Variable { (*variable).GetName() } },
                Variable { "C" }
            };
            return adder.Simplify();
        }

        // Zero rule
        return std::make_unique<Variable>(Variable { "C" })->Simplify();
    }

    Integral<Expression, Expression> integral { *(this->Copy()), *(integrationVariable.Copy()) };

    return integral.Copy();
}

} // namespace Oasis
 */