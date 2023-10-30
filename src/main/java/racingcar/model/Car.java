package racingcar.model;

import racingcar.util.NumberGenerator;
import racingcar.validation.CarNameValidator;

public class Car {
    private static final int MOVEMENT_THRESHOLD = 4;
    private final NumberGenerator numberGenerator;
    private final String name;
    private int position = 0;

    public Car(final String name, final NumberGenerator numberGenerator) {
        final CarNameValidator carNameValidator = CarNameValidator.getInstance();
        carNameValidator.validate(name);
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public void moveForward() {
        final int randomNumber = numberGenerator.createRandomNumber();
        if (isMoveForward(randomNumber)) {
            position++;
        }
    }

    private boolean isMoveForward(final int randomNumber) {
        return randomNumber >= MOVEMENT_THRESHOLD;
    }

    public boolean isWinner(final int winnerPosition) {
        return position == winnerPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
