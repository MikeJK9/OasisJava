package Oasis;

import java.util.Optional;

public class Methods  <U extends UnaryExpression<?, ?>, B extends BinaryExpression<?, ?, ?>>{

    //determine if we're casting from binary, unary, or other into Type T
    public <T extends Expression> T recursiveCast(Expression other, Class<T> TargetType) {
        if (other == null) return null;

        if (other.getCategory() == ExpressionCategory.UnExp.value) {
            return castUnary(other, TargetType);
        } else if (other.getCategory() == ExpressionCategory.BinExp.value) {
            return castBinary(other, TargetType);
        } else {
            return castOther(other, TargetType);
        }
    }

    public <T extends Expression, L extends Expression, R extends Expression> BinaryExpression<?, L, R>
    recursiveCast(Expression other, Class<L> leftType, Class<R> rightType) {
        if (!(other instanceof BinaryExpression<?,?,?>)) {
            return null;
        }
        BinaryExpression<?,?,?> binaryExpression = (BinaryExpression<?,?,?>) other;
        Expression left  = binaryExpression.getMostSigOp();
        Expression right = binaryExpression.getLeastSigOp();

        if (leftType.isInstance(left) && rightType.isInstance(right)) {
            return (BinaryExpression<?, L, R>) binaryExpression;
        }

        if ((other.getCategory() & ExpressionCategory.Commutative.value) != 0) {
            if (leftType.isInstance(right) && rightType.isInstance(left)) {
                return recursiveCast(binaryExpression.swapOperands(),leftType,rightType);
            }
        }

        return null;
    }


    private <T extends Expression> T castOther(Expression other, Class<T> TargetType) {
        if(TargetType.isInstance(other)){
            return (T)other;
        }
        return null;

    }



    private <T extends Expression> T castBinary(Expression other, Class<T> TargetType) {
        if (!TargetType.isInstance(other)) {
            if ((other.getCategory() & ExpressionCategory.Commutative.value) != 0) {
                BinaryExpression<?,?,?> bin = (BinaryExpression<?,?,?>) other;
                Expression swapped = bin.swapOperands();
                if (TargetType.isInstance(swapped)) {
                    return TargetType.cast(swapped);
                }
            }
            return null;
        }
        return TargetType.cast(other);
    }

    private <T extends Expression> T castUnary(Expression other, Class<T> TargetType) {
        if (TargetType.isInstance(other)) {
            return TargetType.cast(other);
        }
        return null;

    }



}
