package Oasis;

public class UnaryExpression<DerivedT extends Expression, OpT extends Expression>
        extends Expression{
    private OpT operand;
    UnaryExpression(){

    }
    UnaryExpression(UnaryExpression other){
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
    public boolean Equals() {
        return false;
    }

    @Override
    public long getCategory() {
        return 0;
    }

    @Override
    public ExpressionType getType() {
        return null;
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
