package model;

public class TWer {
    public String name;
    public String region;
    public String office;
    public double time_in_ThoughtWorks;
    public int age;

    public TWer(String name, String region, String office, double time_in_ThoughtWorks, int age) {
        this.name = name;
        this.region = region;
        this.office = office;
        this.time_in_ThoughtWorks = time_in_ThoughtWorks;
        this.age = age;
    }

    public TWer() {
    }

    @Override
    public String toString() {
        return "TWer{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", office='" + office + '\'' +
                ", time_in_ThoughtWorks=" + time_in_ThoughtWorks +
                ", age=" + age +
                '}';
    }
}
