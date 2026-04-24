package Oasis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideTest {
    Real R0 = new Real(0);
    Real R1 = new Real(1);
    Real R2 = new Real(2);
    Real R3 = new Real(3);
    Real R4 = new Real(4);


    Methods<?, ?> methods = new Methods<>();


    @Test
    void divReals(){
        Divide<Real, Real> d1 = new Divide<>(R3, R1);
        assertTrue (((Real) methods.recursiveCast(d1.Simplify(), Real.class)).Equals(R3));
    }
    @Test
    void divFromZero(){
        Add<Real, Real> a2 = new Add<>(R2, R1);
        Divide<Real, Add<Real, Real>> d2 = new Divide<>(R0, a2);
        assertTrue (((Real) methods.recursiveCast(d2.Simplify(), Real.class)).Equals(R0));
    }
    @Test
    void divByZero(){
        Divide<Real, Real> d3 = new Divide<>(R1, R0);
        Undefined u = new Undefined();
        assertTrue (u.Equals(((Real) methods.recursiveCast(d3.Simplify(), Real.class))));
    }

    @Test
    void divLikeTerms(){
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