package Oasis;
import java.util.Optional;

public class Methods <U extends Concepts.UnaryExpression<?, ?, ?, ?>, B extends Concepts.BinaryExpression<?, ?, ?, ?>, T> {

    private final Class<U> unaryType;
    private final Class<B> binaryType;
    private final Class<T> generalType;

    public Methods(Class<U> unaryType, Class<B> binaryType, Class<T> generalType) {
        this.unaryType = unaryType;
        this.binaryType = binaryType;
        this.generalType = generalType;
    }


    public Optional<? extends Expression> recursiveCast(Expression other) {
        if (unaryType.isInstance(other)) {
            return castUnary(unaryType, other);
        } else if (binaryType.isInstance(other)) {
            return castBinary(binaryType, other);
        } else {
            return castLeaf(generalType, other);
        }
    }

    private Optional<? extends Expression> castLeaf(Class<T> generalType, Expression other) {

        return Optional.empty();
    }

    private Optional<? extends Expression> castBinary(Class<B> binaryType, Expression other) {
        return Optional.empty();
    }

    private Optional<? extends Expression> castUnary(Class<U> unaryType, Expression other) {
        return Optional.empty();
    }


}
