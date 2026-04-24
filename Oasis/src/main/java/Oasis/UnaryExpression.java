package Oasis;

public class UnaryExpression<DerivedT extends Expression, OpT extends Expression>
        extends Expression{
    private OpT operand;

    protected UnaryExpression(UnaryExpression<DerivedT, OpT> other, ExpressionType type, ExpressionCategory cat) {
        super(type, cat);
        if(other.HasOperand()){
            setOperand((OpT) other.operand);
        }
    }
    protected UnaryExpression(ExpressionType type, ExpressionCategory cat) {
        super(type, cat);

    }

    UnaryExpression(){
        super(ExpressionType.None, ExpressionCategory.UnExp);

    }
    UnaryExpression(UnaryExpression<DerivedT, OpT> other){
        super(ExpressionType.None, ExpressionCategory.UnExp);
        if(other.HasOperand()){
            setOperand((OpT) other.operand);
        }
    }

    OpT getOperand() {
        return operand;
    }
    void setOperand(OpT e) {
        operand = e;
    }
    boolean HasOperand(){
        return operand!=null;
    }


    //TODO: implement the following

    @Override
    public Expression Copy() {
        return null;
    }

    @Override
    public Expression Differentiate(Expression differentiationVariable) {
        return null;
    }

    @Override
    public boolean Equals(Expression other) {
        if(other.getType() != getType()){
            return false;
        }

        Expression otherGeneralized = other.Generalize();
        UnaryExpression<DerivedT, OpT> otherUnaryGeneralized = (UnaryExpression<DerivedT, OpT>)otherGeneralized;
        return operand == otherUnaryGeneralized.operand;
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
}
