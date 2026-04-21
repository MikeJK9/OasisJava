package Oasis;

public class Variable extends Expression{
    ExpressionType Type = ExpressionType.Variable;
    ExpressionCategory Cat = ExpressionCategory.UnExp;
    String _name;
    public Variable(String name){
        _name = name;
        //todo: check if we need to move name like in original c++ code
    }

    @Override
    public boolean Equals(Expression other){
        if(other instanceof Variable){
            return ((Variable)other)._name.equals(_name);
        }
        return false;
    }
    public String GetName(){
        return _name;
    }
    //todo: finish integrate, differentiate, substitute
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
    public Expression Copy() {
        return null;
    }

    public Expression Differentiate(Expression differentiationVariable){
        return null;
    }



    @Override
    public Expression Generalize() {
        return null;
    }

    public Expression Substitute(Expression var, Expression val){
        Methods<UnaryExpression<Expression, Expression>, BinaryExpression<Expression, Expression, Expression>> m = new Methods<>();

        Variable varClone = m.recursiveCast(var, Cat.value);
        if(varClone == null){
            System.out.println("Variable was not a variable.");
            return null;
        }
        if (varClone.GetName().equals(GetName())) {
            return val.Copy();
        }
        return Copy();
    }

    @Override
    protected Visit AcceptInternal(Visitor visitor) {
        return null;
    }
}
/*
auto Variable::Substitute(const Expression& var, const Expression& val) -> std::unique_ptr<Expression>
{
    auto varclone = RecursiveCast<Variable>(var);
    if (varclone == nullptr) {
        throw std::invalid_argument("Variable was not a variable.");
    }
    if (varclone->GetName() == GetName()) {
        return val.Copy();
    }
    return Copy();
}

auto Variable::Integrate(const Expression& integrationVariable) const -> std::unique_ptr<Expression>
{
    if (auto variable = RecursiveCast<Variable>(integrationVariable); variable != nullptr) {

        // Power rule
        if (name == (*variable).GetName()) {
            Add adder {
                Divide {
                    Exponent { Variable { (*variable).GetName() }, Real { 2.0f } },
                    Real { 2.0f } },
                Variable { "C" }
            };
            return adder.Simplify();
        }

        // Different variable, treat as constant
        Add adder {
            Multiply { Variable { name }, Variable { (*variable).GetName() } },
            Variable { "C" }
        };
        return adder.Simplify();
    }

    Integral<Expression, Expression> integral { *(this->Copy()), *(integrationVariable.Copy()) };

    return integral.Copy();
}

auto Variable::Differentiate(const Expression& differentiationVariable) const -> std::unique_ptr<Expression>
{
    if (auto variable = RecursiveCast<Variable>(differentiationVariable); variable != nullptr) {

        // Power rule
        if (name == (*variable).GetName()) {
            return std::make_unique<Real>(Real { 1.0f })
                ->Simplify();
        }

        // Different variable, treat as constant
        return std::make_unique<Real>(Real { 0 })
            ->Simplify();
    }

    return Copy();
}

} // Oasis


 */