package collect;

public record StudentMarks(String name, double maths, double physics) implements Comparable<StudentMarks> {

    @Override
    public String toString() {
        return "StudentMarks{" +
                "name='" + name + '\'' +
                ", maths=" + maths +
                ", physics=" + physics +
                '}';
    }

    @Override
    public int compareTo(StudentMarks o) {
        return (int) (o.maths - this.maths);
    }
}
