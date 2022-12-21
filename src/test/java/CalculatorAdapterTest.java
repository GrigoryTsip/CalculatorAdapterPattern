import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.netology.Ints;
import ru.netology.IntsCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorAdapterTest {

    @BeforeEach
    public void init() {
        System.out.println("Test begin");
    }

    @AfterEach
    public void finish() {
        System.out.println("End of test");
    }

    @Test
    public void calcTest() {
        System.out.println("======== Calculation test");

        Ints intsCalc = new IntsCalculator();
        assertEquals(114, intsCalc.sum(36, 78));
        assertEquals(7434, intsCalc.mult(118, 63));
        assertEquals(3375, intsCalc.pow(15, 3));

    }

    @CsvFileSource(files = "src/test/resources/wronginteger.csv")
    @ParameterizedTest
    public void calcExcept(int arg1, int arg2, String operation) {
        System.out.println("======== Exception test");

        Ints intsCalc = new IntsCalculator();
        switch (operation) {
            case "sum":
                assertThrows(IllegalStateException.class, () -> intsCalc.sum(arg1, arg2), "Integer overflow");
                break;
            case "mult":
                assertThrows(IllegalStateException.class, () -> intsCalc.mult(arg1, arg2), "Integer overflow");
                break;
            case "pow":
                assertThrows(IllegalStateException.class, () -> intsCalc.pow(arg1, arg2), "Integer overflow");
                break;
        }
    }
}


