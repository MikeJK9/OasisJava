import Oasis.Expression;
import Oasis.*;

void main() {

    System.out.println("Hello World!");
    Real R0 = new Real(0);
    Real R1 = new Real(1);
    Real R2 = new Real(2);

    System.out.println("Real 0 == Real 1?");
    assert (!R0.Equals(R1));
    System.out.println("false.");

    Add<Real, Real> a1 = new Add<>(R1, R1);

    System.out.println("1+1=2?");
    assert (((Real)a1.Simplify()).Equals(R2));
    System.out.println("true.");
}
