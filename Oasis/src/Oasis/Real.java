package Oasis;

public class Real extends LeafExpression{
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
    //todo: finish integrate
    public Expression Integrate(Expression integrationVariable){
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