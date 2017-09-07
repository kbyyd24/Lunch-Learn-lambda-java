public class ThoughtWorker implements Comparable {

    public String name;

    public String region;

    public String office;

    public int age;

    public double yearsInTW;
    public String title;

    public ThoughtWorker(String name, String region, String office, int age, double yearsInTW) {
        this.name = name;
        this.region = region;
        this.office = office;
        this.age = age;
        this.yearsInTW = yearsInTW;
    }

    public ThoughtWorker() {

    }


    @Override
    public int compareTo(Object o) {
        if (o == null) {
            return 1;
        }
        if (!o.getClass().getSimpleName().equals(this.getClass().getSimpleName())) {
            return 1;
        }
        ThoughtWorker other = (ThoughtWorker) o;
        return name.compareTo(other.name);
    }

    public int getAge() {
        return age;
    }
}
