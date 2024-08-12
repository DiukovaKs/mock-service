package parcer.project.mockservice.domain.seek;

import java.util.Random;

public enum WorkTypeEnum {
    PARTTIME,
    FULLTIME,
    CONTRACT,
    CASUAL;

    private static final Random RANDOM = new Random();

    public static WorkTypeEnum getRandomWorkType() {
        WorkTypeEnum[] types = values();
        return types[RANDOM.nextInt(types.length)];
    }
}
