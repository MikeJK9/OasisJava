package Oasis;

import java.util.Optional;

public class Methods  <U extends UnaryExpression<?, ?>, B extends BinaryExpression<?, ?, ?>>{

    //determine if we're casting from binary, unary, or other into Type T
    public <T> T recursiveCast(Expression other, long DesiredCategory) {
        if (other.getCategory() == ExpressionCategory.UnExp.value) {
            return castUnary(other, DesiredCategory);
        } else if (other.getCategory() == ExpressionCategory.BinExp.value) {
            return castBinary(other, DesiredCategory);
        } else {
            return castOther(other, DesiredCategory);
        }
    }

    private <T> T castOther(Expression other, long Category) {
        if(other.getCategory() == Category){
            return (T)other;
        }
        return null;
/*

if constexpr (std::is_same_v<T, Expression>)
        return other.Copy();
    else
        return other.Is<T>() ? std::make_unique<T>(dynamic_cast<const T&>(other)) : nullptr;
 */
    }



    private <T> T castBinary(Expression other, long Category) {
        if(other.getCategory() != Category){
            return null;
        }
        Expression otherGeneralized = other.Generalize();
        B otherBinaryExpression = (B) otherGeneralized;
        Expression specializedMostSigOp = otherBinaryExpression.getMostSigOp();
        Expression specializedLeastSigOp = otherBinaryExpression.getLeastSigOp();
        if (specializedLeastSigOp != null && specializedMostSigOp != null) {
            return (T) new BinaryExpression<Expression,Expression, Expression>(specializedMostSigOp, specializedLeastSigOp);
        }
        if (other.getCategory() != ExpressionCategory.Commutative.value) {
            return null;
        }
        var otherWithSwappedOps = otherBinaryExpression.swapOperands();
        specializedMostSigOp = otherWithSwappedOps.getMostSigOp();
        specializedLeastSigOp = otherWithSwappedOps.getLeastSigOp();
        if (specializedLeastSigOp != null && specializedMostSigOp != null) {
            return (T) new BinaryExpression<Expression,Expression, Expression>(specializedMostSigOp, specializedLeastSigOp);
        }
        return null;
    }

    private <T> T castUnary(Expression other, long Category) {
        if(other.getCategory() != Category){
            return null;
        }
        Expression otherGeneralized = other.Generalize();
        var otherUnaryExpression = (U) otherGeneralized;
        T specializedOp = recursiveCast(otherUnaryExpression.getOperand(), Category);
        if(specializedOp != null){
            return specializedOp;
        }
        return null;
    }


}
