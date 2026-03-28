package Oasis;

public class Pi extends LeafExpression{
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
