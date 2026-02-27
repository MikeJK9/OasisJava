import java.util.ArrayList;

class Visitor
{

}
enum ExpressionType{
    None,
    Real,
    Imaginary,
    Variable,
    Add,
    Subtract,
    Multiply,
    Divide,
    Exponent,
    Log,
    Integral,
    Limit,
    Derivative,
    Negate,
    Sqrt,
    Matrix,
    Pi,
    EulerNumber,
    Magnitude
}

enum ExpressionCategory {
    None (0),
    Associative (1),
    Commutative (1 << 1),
    BinExp (1 << 2),
    UnExp (1 << 3);
    public final long value;
    ExpressionCategory(long value) {
        this.value = value;
    }
}

public abstract class Expression
{
    //abstract functions
    public abstract Expression Copy();
    public abstract Expression Differentiate();
    public abstract boolean Equals();
    public abstract long getCategory();
    public abstract ExpressionType getType();
    public abstract Expression Generalize();
    public abstract Expression Integrate();
    public abstract Expression IntegrateWithBounds();
    public abstract Expression Simplify();
    public abstract boolean StructurallyEquivalent(Expression other);
    public abstract Expression Substitute(Expression var, Expression val);


    //defined functions
    public ArrayList<Expression> FindZeros(){
        return null;
    }
    public <T extends Expression> boolean Is(){
        //return getType() == T;
        return false;
        //TODO: implement binary and unary versions as well
    }

    //private functions
}