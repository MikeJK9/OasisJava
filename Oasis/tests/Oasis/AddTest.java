package Oasis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {
    Real R0 = new Real(0);
    Real R1 = new Real(1);
    Real R2 = new Real(2);
    Methods<?, ?> methods = new Methods<>();


    @Test
    void addReals(){
        Add<Real, Real> a1 = new Add<>(R1, R1);
        assertTrue (((Real) methods.recursiveCast(a1.Simplify(), Real.class)).Equals(R2));
    }
    @Test
    void addZeroToReal(){
        Add<Real, Real> a2 = new Add<>(R2, R1);
        Add<Real, Add<Real, Real>> a3 = new Add<>(R0, a2);
        Real R3 = new Real(3);
        assertTrue (((Real) methods.recursiveCast(a3.Simplify(), Real.class)).Equals(R3));
    }
    @Test
    void addLikeTerms(){
        Multiply<Real, Variable> x1 = new Multiply<>(new Real(1), new Variable("X"));
        Multiply<Real, Variable> x2 = new Multiply<>(new Real(2), new Variable("X"));
        Multiply<Real, Variable> x3 = new Multiply<>(new Real(3), new Variable("X"));

        Add<Multiply<Real, Variable>, Multiply<Real, Variable>> a = new Add<Multiply<Real, Variable>, Multiply<Real, Variable>>(x1, x2);

        Multiply<?, ?> r = (Multiply<?,?>)a.Simplify();
        assertNotNull(r);
        assertInstanceOf(Multiply.class, r);
         assertTrue(r.Equals(x3));

    }
}