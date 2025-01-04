package structuralDesignPatterns.composite;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Directory implements FileComponent {
    private List<FileComponent> fileComponents;
    private final String name;
    private boolean executable;
    private boolean readable;
    private boolean writeable;
    private final String timestamp;

    public Directory(String name) {
        this.name = name;
        fileComponents = new ArrayList<>();
        this.executable = false;
        this.readable = true;
        this.writeable = true;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public void addFile(FileComponent fileComponent) {
        fileComponents.add(fileComponent);
    }

    @Override
    public void setAsReadable(boolean readable) {
        this.readable = readable;
    }

    @Override
    public void setAdWriteable(boolean writeable) {
        this.writeable = writeable;
    }

    @Override
    public void setAsExecutable(boolean executable) {
        this.executable = executable;
    }

    @Override
    public void chmod(String pattern) {
        char control = pattern.charAt(0);
        char mode = pattern.charAt(1);

        if (control == '+') {
            switch (mode) {
                case 'r':
                    setAsReadable(true);
                    break;
                case 'w':
                    setAdWriteable(true);
                    break;
                case 'x':
                    setAsExecutable(true);
                    break;
                default:
                    System.out.println("Wrong pattern");
            }
        } else if (control == '-') {
            switch (mode) {
                case 'r':
                    setAsReadable(false);
                    break;
                case 'w':
                    setAdWriteable(false);
                    break;
                case 'x':
                    setAsExecutable(false);
                    break;
                default:
                    System.out.println("Wrong pattern");
            }
        } else {
            System.out.println("Wrong pattern");
        }
    }

    @Override
    public void ls() {
        char isReadable = readable ? 'r' : '-';
        char isWriteable = writeable ? 'w' : '-';
        char isExecutable = executable ? 'x' : '-';
        System.out.println(String.valueOf(isReadable)+String.valueOf(isWriteable)+String.valueOf(isExecutable)+" "+
                timestamp+ " " + name);
        for (FileComponent fileComponent : fileComponents) {
            System.out.print("\t");
            fileComponent.ls();
        }
    }
}
