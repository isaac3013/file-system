public class Main {
    public static void main(String[] args) {
        FileSystemSimulator fs = new FileSystemSimulator();
        
        // Operações de exemplo
        fs.createDirectory("/root", "docs");
        fs.createFile("/root/docs", "file1.txt");
        fs.listFiles("/root");
        fs.listFiles("/root/docs");
        
        fs.renameFile("/root/docs", "file1.txt", "file2.txt");
        fs.listFiles("/root/docs");
        
        fs.deleteFile("/root/docs", "file2.txt");
        fs.listFiles("/root/docs");
        
        fs.renameDirectory("/root", "docs", "documents");
        fs.listFiles("/root");
        
        fs.deleteDirectory("/root", "documents");
        fs.listFiles("/root");

        // Exibir o log do Journal
        System.out.println("\nJournal Log:");
        for (String entry : fs.getJournal().getLog()) {
            System.out.println(entry);
        }
    }
}
