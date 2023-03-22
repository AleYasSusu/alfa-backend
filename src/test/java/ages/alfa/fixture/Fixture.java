package ages.alfa.fixture;

import org.jeasy.random.EasyRandom;

public class Fixture {

    private static final EasyRandom easyRandom = new EasyRandom();

    public static  <T> T make(final T classMock) {
        return (T) easyRandom.nextObject(classMock.getClass());
    }
}
