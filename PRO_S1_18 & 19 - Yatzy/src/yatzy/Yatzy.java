package yatzy;

import java.util.Random;

/**
 * Models a game of Yatzy. 
 */
public class Yatzy {
    /** 
     * Face values of the 5 dice. <br/>
     * 1 <= values[i] <= 6.
     */
    private int[] values = new int[5];

    /** 
     * Number of times the 5 dice have been thrown. <br/>
     * 0 <= throwCount <= 3.
     */
    private int throwCount = 0;

    /** 
     * Random number generator.
     */
    private Random random = new Random();
    
    /**
     * Rolls the 5 dice. <br/>
     * Only roll dice that are not hold. <br/>
     * Requires: holds contain 5 boolean values.
     */
    public void throwDice(boolean[] holds) {
        // TODO: Implement
    }

    /**
     * Returns the number of times the five dice have been thrown.
     */
    public int getThrowCount() {
        return throwCount;
    }
    
    /**
     * Resets the throw count.
     */
    public void resetThrowCount() {
        throwCount = 0;
    }
    
    /**
     * Get current dice values
     */
    public int[] getValues() {
        return values;
    }
    
    /**
     * Set the current dice values
     */
    public void setValues(int[] values) {
        this.values = values;
    }
    
    /**
     * Returns all results possible with the current face values. <br/>
     * The order of the results is the same as on the score board.
     */
    public int[] getPossibleResults() {
        int[] results = new int[15];
        for (int i = 0; i <= 5; i++) {
            results[i] = this.valueSpecificFace(i + 1);
        }
        results[6] = this.valueOnePair();
        results[7] = this.valueTwoPair();
        results[8] = this.valueThree();
        results[9] = this.valueFour();
        results[10] = this.valueFullHouse();
        results[11] = this.valueSmallStraight();
        results[12] = this.valueLargeStraight();
        results[13] = this.valueChance();
        results[14] = this.valueYatzy();
        return results;
    }
    
    /** 
     * Returns an int[7] containing the frequency of face values. <br/>
     * Frequency at index v is the number of dice with the face value v, 1 <= v <= 6. <br/>
     * Index 0 is not used.
     */
    private int[] freqFaceValue() {
        // TODO: Implement
        return new int[0];
    }

    /**
     * Returns the total value for the dice currently showing the given face value
     * @param face the face value to return values for
     */
    public int valueSpecificFace(int face) {
        // TODO: Implement
        return 0;
    }

    /**
     * Returns the maximum value for n-of-a-kind for the given n. <br/>
     * For example, valueManyOfAKind(3) returns the maximum value for 3 of-a-kind. <br/>
     * Requires: 1 <= faceValue and faceValue <= 6
     * @param n number of kind
     */
    public int valueManyOfAKind(int n) {
        // TODO: Implement
        return 0;
    }

    /**
     * The current value if you try to score the current face values as Yatzy.
     */
    public int valueYatzy() {
        // TODO: Implement
        return 0;
    }

    /**
     * Returns the current score if used as "chance".
     */
    public int valueChance() {
        // TODO: Implement
        return 0;
    }

    /**
     * Returns the current score for one pair.
     */
    public int valueOnePair() {
        // TODO: Implement
        return 0;
    }

    /**
     * Returns the current score for two pairs.
     */
    public int valueTwoPair() {
        // TODO: Implement
        return 0;
    }
    
    /**
     * Returns the current score for three of a kind.
     */
    public int valueThree() {
        // TODO: Implement
        return 0;
    }
    
    /**
     * Returns the current score for four of a kind.
     */
    public int valueFour() {
        // TODO: Implement
        return 0;
    }

    /**
     * Returns the value of a small straight with the current face values.
     */
    public int valueSmallStraight() {
        // TODO: Implement
        return 0;
    }

    /**
     * Returns the value of a large straight with the current face values.
     */
    public int valueLargeStraight() {
        // TODO: Implement
        return 0;
    }

    /**
     * Returns the value of a full house with the current face values.
     */
    public int valueFullHouse() {
        // TODO: Implement
        return 0;
    }

}
