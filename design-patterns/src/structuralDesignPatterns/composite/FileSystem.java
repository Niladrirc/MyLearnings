package structuralDesignPatterns.composite;

public interface FileSystem {
    void setAsReadable(boolean readable);
    void setAdWriteable(boolean writeable);
    void setAsExecutable(boolean executable);
    void chmod(String pattern);
    void ls();
}
