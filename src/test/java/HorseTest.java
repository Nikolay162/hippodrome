import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

class HorseTest {

    @Test
    public void WhenNameNullThenIllExceptionAndMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Horse(null, 1, 1));
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "\s", "   ", "\t\t", "\n\n\n\n"})
    public void WhenNameBlankThenExceptionAndMessage(String name) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Horse(name, 1, 1));
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    public void whenTwoParameterNegativeThenIllArgExceptionAndMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Horse("Вася", -1, 2));
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    public void whenThreeParameterNegativeThenIllArgExceptionAndMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Horse("Вася", 1, -2));
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    void getName() {
        Horse horse = new Horse("вишня", 4, 4);
        assertEquals("вишня", horse.getName());
    }

    @Test
    void getSpeed() {
        Horse horse = new Horse("вишня", 4, 4);
        assertEquals(4, horse.getSpeed());
    }

    @Test
    void getDistance() {
            Horse horse = new Horse("вишня", 4, 4);
            assertEquals(4, horse.getSpeed());
    }

    @Test
    void moveUsersGetRandom() {
        try (MockedStatic<Horse> mockedStatic = mockStatic (Horse.class)) {
new Horse("faaf", 1,1).move();
       mockedStatic.verify(()-> Horse.getRandomDouble(0.2, 0.9));
        }
    }
}
