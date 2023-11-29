package vn.edu.iuh.fit.enums;

public enum SkillType {
    BEGINNER(0),
    INTERMEDIATE(1),
    MASTER(2);

    private final int value;

    SkillType(int value) {
        this.value = value;
    }

    public int getTypeNum() {
        return this.value;
    }

    public static SkillType getSkillType(int value) {
        return value == 2 ? MASTER : value == 1 ? INTERMEDIATE : BEGINNER;
    }

}
