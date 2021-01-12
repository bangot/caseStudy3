package model;

public class Student {
    private int id;
    private String name;
    private String sex;
    private int testScore;

    public Student(String name, String sex, int testScore) {
    }

    public Student(int id, String name, String sex, int testScore) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.testScore = testScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getTestScore() {
        return testScore;
    }

    public void setTestScore(int testScore) {
        this.testScore = testScore;
    }
}
