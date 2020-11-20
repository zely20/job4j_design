import org.junit.Test;
import ru.job4j.OOD.tdd.Generator;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GeneratorTest {

    @Test
    public void produce() {
        Generator generator = new GeneratorImpl();
        Map<String,String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String input = "I am a ${name}, Who are ${subject}?";
        String result = generator.produce(input, map);
        assertThat(result, is("I am a Petr Arsentev, Who are you?"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionOneTest() {
        Generator generator = new GeneratorImpl();
        Map<String,String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String input = "I am a ${name}, Who are ${subject}, ${address}?";
        String result = generator.produce(input, map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionTwoTest() {
        Generator generator = new GeneratorImpl();
        Map<String,String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        map.put("address", "//////");
        String input = "I am a ${name}, Who are ${subject}?";
        String result = generator.produce(input, map);
    }

}
