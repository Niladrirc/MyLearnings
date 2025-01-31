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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentMarks that = (StudentMarks) o;
        return Double.compare(maths, that.maths) == 0 && Double.compare(physics, that.physics) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) maths;
        result = prime * result + (int) physics;
        return result;
    }
}