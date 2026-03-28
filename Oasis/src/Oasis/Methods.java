package Oasis;
import java.util.Optional;

public class Methods <U extends Concepts.UnaryExpression<?, ?, ?, ?>, B extends Concepts.BinaryExpression<?, ?, ?, ?>, T>{

    private final Class<U> unaryType;
    private final Class<B> binaryType;
    private final Class<T> generalType;

    public Methods(Class<U> unaryType,Class<B> binaryType, Class<T> generalType) {
        this.unaryType = unaryType;
        this.binaryType = binaryType;
        this.generalType = generalType;
    }


    //unary
    public Optional<U> RecursiveCast(U other){
        U dummy;
        return dummy;
    }

    //binary
    public Optional<B> RecursiveCast(B other){
        B dummy;
        return dummy;
    }

    //not unary or binary derived
    public Optional<T> RecursiveCast(T other){
        if(generalType.equals(other.getClass())){
            return Optional.of(generalType.cast(other)); // safe cast using class token
        }
        return Optional.empty();
    }
}
