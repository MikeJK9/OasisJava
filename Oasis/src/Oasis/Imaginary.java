package Oasis;

public class Imaginary extends LeafExpression{
    public Imaginary(){
        //todo- constructor
    }
    public Imaginary(Imaginary other){
        //todo- copy constructor
    }

    public boolean Equals(Expression other){
        return other.getType().equals(ExpressionType.Imaginary);
    }

    /*
    EXPRESSION_TYPE(Imaginary)
    EXPRESSION_CATEGORY(UnExp)

     */

}
