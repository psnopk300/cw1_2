import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Dec2HexTest {

    private Dec2Hex converter;

    @Before
    public void setUp() {
        converter = new Dec2Hex();
    }

    @Test
    public void testValidConversion() {
        assertEquals("FF", converter.convert(255));
        assertEquals("100", converter.convert(256));
        assertEquals("7B", converter.convert(123));
    }

    @Test
    public void testZeroConversion() {
        assertEquals("0", converter.convert(0));
    }

    @Test
    public void testValidateAndConvert_ValidInput() {
        assertEquals("1F", converter.validateAndConvert("31"));
    }

    @Test
    public void testValidateAndConvert_InvalidInput() {
        assertEquals("Error: Invalid input. 'abc' is not a valid integer.", converter.validateAndConvert("abc"));
    }

    @Test
    public void testValidateAndConvert_EmptyInput() {
        assertEquals("Error: No input provided. Please provide an integer.", converter.validateAndConvert(""));
    }

    @Test
    public void testValidateAndConvert_NullInput() {
        assertEquals("Error: No input provided. Please provide an integer.", converter.validateAndConvert(null));
    }
}

