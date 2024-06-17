import java.util.ArrayList;
import java.util.List;

public class Directory {
    private String name;
    private List<File> files = new ArrayList<>();
    private List<Directory> directories = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public List<File> getFiles() {
        return files;
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void addDirectory(Directory directory) {
        directories.add(directory);
    }

    public void removeFile(String name) {
        files.removeIf(file -> file.getName().equals(name));
    }

    public void removeDirectory(String name) {
        directories.removeIf(directory -> directory.getName().equals(name));
    }
}
