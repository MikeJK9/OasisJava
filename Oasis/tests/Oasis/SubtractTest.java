package Oasis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractTest {
    Real R0 = new Real(0);
    Real R1 = new Real(1);
    Real R2 = new Real(2);
    Real R3 = new Real(3);

    Real R4 = new Real(4);

    Methods<?, ?> methods = new Methods<>();

    @Test
    void subReals(){
        Subtract<Real, Real> s1 = new Subtract<>(R1, R1);
        assertTrue (((Real) methods.recursiveCast(s1.Simplify(), Real.class)).Equals(R0));
    }
    @Test
    void subZeroFromReal(){
        Subtract<Real, Real> s2 = new Subtract<>(R2, R1);
        Subtract<?,?> s3 = new Subtract<>(s2, R0);
        assertTrue (((Real) methods.recursiveCast(s3.Simplify(), Real.class)).Equals(R1));
        assertTrue (s3.Simplify().Equals(s2.Simplify()));
    }
    @Test
    void subLikeTerms(){
        Multiply<Real, Variable> x1 = new Multiply<>(new Real(1), new Variable("X"));
        Multiply<Real, Variable> x2 = new Multiply<>(new Real(2), new Variable("X"));
        Multiply<Real, Variable> x3 = new Multiply<>(new Real(3), new Variable("X"));

        Subtract<Multiply<Real, Variable>, Multiply<Real, Variable>> s = new Subtract<>(x3, x2);

        Multiply<?, ?> r = (Multiply<?,?>)s.Simplify();
        assertNotNull(r);
        assertInstanceOf(Multiply.class, r);
        assertTrue(r.Equals(x1));

    }
}