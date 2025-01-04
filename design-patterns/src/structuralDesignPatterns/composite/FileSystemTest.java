package structuralDesignPatterns.composite;

public class FileSystemTest {
    public static void main(String[] args) {
        FileSystem A = new File("A");
        FileSystem B = new File("B");
        FileSystem C = new File("C");
        FileSystem D = new File("D");

        Directory dirA = new Directory("DirA");
        dirA.addFile(A);
        dirA.addFile(B);

        Directory dirB = new Directory("DirB");
        dirB.addFile(C);
        dirB.addFile(D);
        dirB.addFile(dirA);

        dirB.ls();
    }
}
