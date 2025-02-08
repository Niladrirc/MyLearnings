import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public final class Tutor {
    private final String name;
    private final Set<Student> tutees;

    public Tutor(String name, Student[] tutees) {
        this.name = name;
        this.tutees = Arrays.stream(tutees).collect(Collectors.toSet());
    }

    public String getName() {
        return name;
    }

    public Set<Student> getTutees() {
        return Collections.unmodifiableSet(tutees);
    }
}
