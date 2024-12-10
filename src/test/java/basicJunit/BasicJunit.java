
package basicJunit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicJunit {
    @BeforeEach
    public void setup(){
        // todo logica que se ejecute antes del test
        System.out.println("setup");
    }

    @AfterEach
    public void cleanup(){
        // todo logica que se ejecute despues del test
        System.out.println("cleanup");
    }

    @Test
    public void testSomeThing(){
        System.out.println("test1");

    }

    @Test
    public void testSomeThing1(){
        System.out.println("test2");

    }



}
