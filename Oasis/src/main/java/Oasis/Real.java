package Oasis;

public class Real extends Expression{


    double _value;
    public Real(double value){
        super(ExpressionType.Real, ExpressionCategory.UnExp);
        _value = value;

    }
    public Real Differentiate(){
        return new Real(0);
    }

    @Override
    public boolean Equals(Expression other){
        System.out.println("Checking equality of reals");
        if(other instanceof Real){
            System.out.println(((Real)other)._value + " is equal to " +_value);
            return ((Real)other)._value == _value;
        } else if (other instanceof Undefined) {
            return _value == Float.MAX_VALUE;
        }
        return false;
    }
    public double GetValue(){
        return _value;
    }

    @Override
    public Expression Copy() {
        return new Real(_value);
    }

    @Override
    public Expression Differentiate(Expression differentiationVariable) {
        return null;
    }

    @Override
    public Expression Generalize() {
        return this;
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
        return this;
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