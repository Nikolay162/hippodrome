import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.configuration.IMockitoConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HippodromeTest {

    @Test
    public void whenArgNullThenIllExceptionAndMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,()->
        new Hippodrome(null));
        assertEquals("Horses cannot be null.", exception.getMessage());

    }
    @Test
    public void whenArgEmptyThenIllExceptionAndMessage() {
        List<Horse> horses1 = new ArrayList<>();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,()->
                new Hippodrome(horses1));
        assertEquals("Horses cannot be empty.", exception.getMessage());

    }

    @Test
    void getHorses() {
        List<Horse> horseList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            horseList.add(new Horse("" + i, i, i));
        }
        Hippodrome hippodrome = new Hippodrome(horseList);
        assertEquals(horseList, hippodrome.getHorses());
    }

    @Test
    void move() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(mock(Horse.class));
        }
        new Hippodrome(horses).move();
        for (Horse horse: horses) {
            verify(horse,only()).move();
        }
    }

    @Test
    void getWinner() {
        Horse horse = new Horse("H1",1, 1);
        Horse horse1 = new Horse("H1",1, 2);
        Horse horse2 = new Horse("H1",1, 3);
        Horse horse3 = new Horse("H1",1, 4);
        Horse horse4 = new Horse("H1",1, 5);

        Hippodrome hippodrome = new Hippodrome(List.of(horse, horse1, horse2, horse3, horse4));
        assertSame(horse4, hippodrome.getWinner());
    }
}