package map;

public record Students(int maths, int physics) implements Comparable<Students> {

    @Override
    public int compareTo(Students o) {
        return o.maths - this.maths;
    }

    @Override
    public String toString() {
        return "Student{" +
                "maths="+maths+
                ", physics=" + physics +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null && getClass() != o.getClass()) return false;
        Students that = (Students) o;
        return this.maths == that.maths() && this.physics == that.physics();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + this.maths;
        result = prime * result + this.physics;
        return result;
    }
}
