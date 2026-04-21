import Oasis.*;

void main() {

    System.out.println("Hello World!");
    Real R0 = new Real(0);
    Real R1 = new Real(1);
    Real R2 = new Real(2);

    System.out.println("Real 0 == Real 1?");
    assert (!R0.Equals(R1));
    System.out.println("false.");

    System.out.println("Type of R0 == Real?");
    assert (R0.getType() == ExpressionType.Real);
    System.out.println("true.");


    System.out.println("\nTesting Addition:");


    Add<Real, Real> a1 = new Add<>(R1, R1);
    System.out.println("1+1=2?");
    assert (((Real)a1.Simplify()).Equals(R2));
    System.out.println("true.");

    Add<Real, Real> a2 = new Add<>(R2, R1);
    Add<Real, Add<Real, Real>> a3 = new Add<>(R0, a2);
    Real R3 = new Real(3);

    System.out.println("0+(2+1)=3?");
    assert (((Real)a3.Simplify()).Equals(R3));
    System.out.println("true.");

    Multiply<Real, Variable> x1 = new Multiply<>(new Real(1), new Variable("X"));
    Multiply<Real, Variable> x2 = new Multiply<>(new Real(2), new Variable("X"));
    Multiply<Real, Variable> x3 = new Multiply<>(new Real(3), new Variable("X"));

    Add<Multiply<Real, Variable>, Multiply<Real, Variable>> a4 = new Add<Multiply<Real, Variable>, Multiply<Real, Variable>>(x1, x2);
    System.out.println("\n Adding like terms:");
    assert (((Multiply<Real, Variable>)a4.Simplify()).Equals(x3));
    System.out.println("\nTesting Subtraction:");

    Subtract<Real, Real> s1 = new Subtract<>(R1, R1);
    System.out.println("1-1=0?");
    assert (((Real)s1.Simplify()).Equals(R0));
    System.out.println("true.");
}
