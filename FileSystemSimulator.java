import java.util.ArrayList;
import java.util.List;

public class FileSystemSimulator {
    private Directory root;
    private Journal journal;

    public FileSystemSimulator() {
        root = new Directory("root");
        journal = new Journal();
    }

    private Directory findDirectory(String path) {
        String[] parts = path.split("/");
        Directory current = root;
        for (String part : parts) {
            if (part.isEmpty()) continue;
            boolean found = false;
            for (Directory dir : current.getDirectories()) {
                if (dir.getName().equals(part)) {
                    current = dir;
                    found = true;
                    break;
                }
            }
            if (!found) return null;
        }
        return current;
    }

    public void createFile(String path, String name) {
        Directory dir = findDirectory(path);
        if (dir != null) {
            File newFile = new File(name);
            dir.addFile(newFile);
            journal.addEntry("CREATE FILE: " + path + "/" + name);
        }
    }

    public void deleteFile(String path, String name) {
        Directory dir = findDirectory(path);
        if (dir != null) {
            dir.removeFile(name);
            journal.addEntry("DELETE FILE: " + path + "/" + name);
        }
    }

    public void renameFile(String path, String oldName, String newName) {
        Directory dir = findDirectory(path);
        if (dir != null) {
            for (File file : dir.getFiles()) {
                if (file.getName().equals(oldName)) {
                    file.setName(newName);
                    journal.addEntry("RENAME FILE: " + path + "/" + oldName + " to " + newName);
                    break;
                }
            }
        }
    }

    public void createDirectory(String path, String name) {
        Directory dir = findDirectory(path);
        if (dir != null) {
            Directory newDir = new Directory(name);
            dir.addDirectory(newDir);
            journal.addEntry("CREATE DIRECTORY: " + path + "/" + name);
        }
    }

    public void deleteDirectory(String path, String name) {
        Directory dir = findDirectory(path);
        if (dir != null) {
            dir.removeDirectory(name);
            journal.addEntry("DELETE DIRECTORY: " + path + "/" + name);
        }
    }

    public void renameDirectory(String path, String oldName, String newName) {
        Directory dir = findDirectory(path);
        if (dir != null) {
            for (Directory subDir : dir.getDirectories()) {
                if (subDir.getName().equals(oldName)) {
                    subDir.setName(newName);
                    journal.addEntry("RENAME DIRECTORY: " + path + "/" + oldName + " to " + newName);
                    break;
                }
            }
        }
    }

    public void listFiles(String path) {
        Directory dir = findDirectory(path);
        if (dir != null) {
            System.out.println("Listing files in: " + path);
            for (File file : dir.getFiles()) {
                System.out.println("File: " + file.getName());
            }
            for (Directory subDir : dir.getDirectories()) {
                System.out.println("Directory: " + subDir.getName());
            }
            journal.addEntry("LIST FILES: " + path);
        }
    }

    public Journal getJournal() {
        return journal;
    }
}
