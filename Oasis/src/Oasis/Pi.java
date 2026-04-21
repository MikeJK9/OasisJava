package Oasis;

public class Pi extends Expression{
    ExpressionType Type = ExpressionType.Pi;
    ExpressionCategory Cat = ExpressionCategory.UnExp;
    public Pi(){

    }
    public Pi(Expression e){

    }
    public double getValue(){
        return Math.PI;
    }
    public boolean Equals(Expression other){
        return other.getType().equals(ExpressionType.Pi);
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

public:
    Pi() = default;
    Pi(const Pi& other) = default;

    [[nodiscard]] auto Equals(const Expression& other) const -> bool final;

    EXPRESSION_TYPE(Pi)
    EXPRESSION_CATEGORY(UnExp)

    static auto GetValue() -> double;
};

    auto Pi::Equals(const Expression& other) const -> bool
{
    return other.Is<Pi>() == dynamic_cast<const Pi&>(other).Is<Pi>();
}

auto Pi::GetValue() -> double
{
    return std::numbers::pi;
}
     */
}
