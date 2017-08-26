import java.util.List;

public class LambdaDemo {
    public static void main(String[] args) {

    }

    public static long countGraduateFromChinaByForIteration(List<Graduate> graduates) {
        int count = 0;
        for (Graduate graduate : graduates) {
            if (graduate.region.equals("China")) {
                count ++;
            }
        }
        return count;
    }

    public static long countGraduateFromChinaByLambda(List<Graduate> graduates) {
        return graduates
                .stream()
                .filter(graduate -> graduate.region.equals("China"))
                .count();
    }
}
