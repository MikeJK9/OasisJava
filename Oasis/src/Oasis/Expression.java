package Oasis;

import java.util.ArrayList;

import static java.lang.Math.abs;

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
    //TODO
    // currently only supports polynomials of one variable.
    /**
     * The FindZeros function finds all rational zeros of a polynomial. Currently assumes an expression of the form a+bx+cx^2+dx^3+... where a, b, c, d are a integers.
     *
     * @tparam origonalExpresion The expression for which all the factors will be found.
     */
    public ArrayList<Expression> FindZeros()
    {
        ArrayList<Expression> results = new ArrayList<>();
        ArrayList<Expression> termsE = new ArrayList<>();
        if (true/*auto addCase = RecursiveCast<Add<Expression>>(*this); addCase != nullptr*/) {
            //addCase->Flatten(termsE);
        } else {
        termsE.add(Copy());
    }
        return results;

    }
    long gcf(long a, long b){
        if (b > a) {
            long c = a;
            a = b;
            b = c;
        }
        while (true) {
            a %= b;
            if (a == 0) {
                return b;
            }
            b %= a;
            if (b == 0) {
                return a;
            }
        }
    }

    ArrayList<Long> getAllFactors(long n)
{
    ArrayList<Long> answer = new ArrayList<>();
    for (long i = 1; i * i <= n; i++) {
    if (n % i == 0) {
        answer.add(i);
    }
}
    if (abs(n) != 1) {
    answer.add(abs(n));
}
    return answer;
}
    public <T extends Expression> boolean Is(){
        //return getType() == T;
        return false;
        //TODO: implement this, and binary and unary versions as well
    }

    //private functions
    protected abstract void AcceptInternal(Visitor visitor);
    public <T extends Visitor> Exception Accept(Visitor visitor){
        return null;
    }
    /*
    public <T extends Visitor>  Accept(Visitor visitor){
        return null;
    }*/




}