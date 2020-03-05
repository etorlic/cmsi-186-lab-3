import java.util.Random;

public class Die {
    private static Random random = new Random();

    public static final String SIX_SIDED_DIE_EMOJI = "🎲";

    private int value;
    private final int sides;

    public Die(int sides, int value) {
        if (sides < 4)
            throw new IllegalArgumentException ("At least four sides required");
        if (value < 1 || value > sides)
            throw new IllegalArgumentException ("Die value not legal for die shape");
        this.sides = sides;
        this.value = value;
    }

    public int roll() {
        value = random.nextInt(sides) + 1;
        return value;
    }

    public int getSides() {
        return sides;
    }

    public int getValue() {
        return value;
    }

    @Override public String toString() {
        // TODO
        return "[" + getValue() + "]";
    }
}
