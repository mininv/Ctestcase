import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void checkCases(){
        int i = Main.changeLastZeroBit(0);
        assertTrue(i==1);

        //например ([][[]()]) - правильно, ([][]()]) – неправильно
        boolean loopMatch = Main.isLoopMatch("([][[]()])");
        assertTrue(loopMatch);
        boolean loopMatch1 = Main.isLoopMatch("([][]()])");
        assertFalse(loopMatch1);

        Integer[] arr = {3, 3, 3};
        Set<?> objects = Main.sortAndOrderArray(arr);
        assertTrue(objects.contains(new NumberCounter(3,3)));

    }
}