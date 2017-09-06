public class ThoughtWorker implements Comparable {

    public String name;

    public String region;

    public String office;

    public int age;

    public double yearsInTW;


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
}
