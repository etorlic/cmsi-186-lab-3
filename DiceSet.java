import java.util.*;

/**
 * A dice set holds a collection of Die objects. All of the die objects have
 * the same number of sides.
 */
public class DiceSet {
    private Die[] diceSet;

    public DiceSet(int sidesOnEachDie, int numberOfDice) {
        if (numberOfDice < 2)
            throw new IllegalArgumentException ("At least two dice required");
        if (sidesOnEachDie < 4)
            throw new IllegalArgumentException ("Dice must have at least four sides");

        diceSet = new Die[numberOfDice];
        for (int i = 0; i < numberOfDice; i++)
            diceSet[i] = new Die(sidesOnEachDie, 1);
    }

    public DiceSet(int sidesOnEachDie, int... values) {
        for (int i = 0; i < values.length; i++) {
          if (sidesOnEachDie < 4 && values[i] > sidesOnEachDie)
              throw new IllegalArgumentException ("Die value not legal for die shape");
        }
        if (values.length < 2)
            throw new IllegalArgumentException ("At least two dice required");

        diceSet = new Die[values.length];
        for (int i = 0; i < values.length; i++)
            diceSet[i] = new Die(sidesOnEachDie, values[i]);
    }

    public String descriptor() {
        return (diceSet.length + "d" + diceSet[0].getSides());
    }

    public int sum() {
        var sum = 0;
        for (int i = 0; i < diceSet.length; i++) {
            sum += diceSet[i].getValue();
        }
        return sum;
    }

    public void rollAll() {
        for (int i = 0; i < diceSet.length; i++) {
            diceSet[i].roll();
        }
    }

    public void rollIndividual(int i) {
        diceSet[i].roll();
    }

    public int getIndividual(int i) {
        return diceSet[i].getValue();
    }

    public List<Integer> values() {
        ArrayList<Integer> values = new ArrayList<Integer>();
        for (int i = 0; i < diceSet.length; i++)
            values.add(diceSet[i].getValue());
        return values;
    }

    public boolean isIdenticalTo(DiceSet diceSet) {
        boolean isIdentical = false;
        if (this.diceSet.length != diceSet.diceSet.length ||
            this.diceSet[0].getSides() != diceSet.diceSet[0].getSides())
            isIdentical = false;

        List<Integer> set1 = this.values();
        List<Integer> set2 = diceSet.values();
        Collections.sort(set1);
        Collections.sort(set2);
        if (set1.equals(set2))
            isIdentical = true;

        return isIdentical;
    }

    @Override public String toString() {
        String message = "";
        for (int i = 0; i < diceSet.length; i++)
            message += "[" + diceSet[i].getValue() + "]";
        return message;
    }
}
