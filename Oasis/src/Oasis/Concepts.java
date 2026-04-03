package Oasis;
import Oasis.ExpressionType;

/**
 * An expression concept.
 * An expression concept is a type that satisfies the following requirements:
 * - It is derived from `Expression`.
 * - It has a static `Specialize` function that returns a `std::unique_ptr<T>` and takes a `const Expression&` as an argument.
 * - It has a static `Specialize` function that returns a `std::unique_ptr<T>` and takes a `const Expression&` and a `tf::Subflow&` as arguments.
 * - It has a static `GetStaticCategory` function that returns a `uint32_t`.
 * - It has a static `GetStaticType` function that returns an `ExpressionType`.
 *  T: The type to check.
 */
public record Concepts() {
    public interface IExpression<T, J extends Expression> {
        long GetStaticCategory();

        ExpressionType GetStaticType();

        T Specialize(Expression e);

    }
//TODO:
//&& std::derived_from<T, Expression>) || std::is_same_v<T, Expression>;
//check that IExpression is either derived from Expression or Expression itself.

    class IExpressionClass implements IExpression {
        @Override
        public long GetStaticCategory() {
            return 0;
        }

        @Override
        public ExpressionType GetStaticType() {
            return null;
        }

        @Override
        public Object Specialize(Expression e) {
            return null;
        }

    }

    public interface BinaryExpression<T extends IExpression, DerivedT extends IExpression,
            MostSigOpT extends IExpressionClass, LeastSigOpT extends IExpressionClass> {

        Expression getMostSigOp();

        Expression getLeastSigOp();

        BinaryExpression<?,?,?,?> swapOperands();
    }

    public interface UnaryExpression<T extends IExpression, DerivedT extends IExpression,
            MostSigOpT extends IExpressionClass, LeastSigOpT extends IExpressionClass> {

        Expression getOperand();
    }

    /*
     * Checks if Object obj's type is same as any of the provided types in types.
     *
     * @param obj The type to compare against.
     * @param types The comparison types.
     * @return true if T is same as any type in U, false otherwise.
     */
    public static boolean isAnyOf(Object obj, Class<?>... types) {
        for (Class<?> type : types) {
            if (type.equals(obj.getClass())) return true;
        }
        return false;
    }

    public static <T extends BinaryExpression<?, ?, ?, ?>> boolean derivedFromBinaryExpression(T obj) {
        return true;
    }

    public static <T extends UnaryExpression<?, ?, ?, ?>> boolean derivedFromUnaryExpression(T obj) {
        return true; // if it compiles, the constraint is satisfied
    }

    void main() {
    }


}







/*
template <typename T>
concept IVisitor = requires {
typename T::RetT; // Checks for the type alias
requires std::is_base_of_v<Visitor, T>; // Ensures T derives from BaseClass
};

template <typename T>
concept ExpectedWithString = requires {
typename T::unexpected_type;
requires std::same_as<typename T::unexpected_type, std::unexpected<std::string>>;
        };

*/
