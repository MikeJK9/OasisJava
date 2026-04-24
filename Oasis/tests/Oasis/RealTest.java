package Oasis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RealTest {
    Real R0 = new Real(0);
    Real R1 = new Real(1);
    Real R1_2 = new Real(1);

    @Test
    void equals() {
        assertFalse(R0.Equals(R1));
        assertTrue(R1.Equals(R1));
        assertTrue(R1.Equals(R1_2));
    }

    @Test
    void getValue() {
        assertEquals(1, R1._value);
    }

    @Test
    void copy() {
        Real R1_3 = (Real)R1.Copy();
        assertTrue(R1.Equals(R1_3));
        R1_3._value = 4;
        assertFalse(R1.Equals(R1_3));

    }
}