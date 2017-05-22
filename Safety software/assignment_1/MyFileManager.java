import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
/**
 * Created by Shlomi Alon on 22/05/2017.
 */
public class MyFileManager implements FileManager {
    private File file;
    private FileWriter out;
    private FileReader in;

    public MyFileManager() {
        file = null;
        out = null;
        in = null;
    }
//
    public MyFileManager(File file) {
        this.file = file;
        try {
            out = new FileWriter(file, true);
            in = new FileReader(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    PROBLEM - the NullPointerExeption which is hiding the real mistake of the program.
//    SOLUTION - check if the object is null
    @Override
    public void writeToFile(String line) {
        try {
            out.write(line);
        } catch (NullPointerException | IOException e) {
            System.out.println("Null Pointer Exception");
        }
    }


    //PROBLEM - not check for filename to be null
    //SOLUTION - check if the filename is not null
    @Override
    public void openFile(String fileName) {
        file = new File(fileName);
        try {
//          file.createNewFile();
            in = new FileReader(file);
            out = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //PROBLEM - not check for close() - NULL
    //SOLUTION - if(out.close == null){ out.close();}
    @Override
    public void closeFile() {
        try {
            in.close();
            out.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public File getFile() {
        return file;
    }

    /**PROBLEM - we call equals() method on obj which might be null since
     * we have || (or) statement the program will continue to this method even of the object is null.
     * SOLUTION - if ((null == obj && null == current) || obj.equals(current) && obj != null)
     */
    @Override
    public boolean isInCollection(Object obj, Collection<?> collection) {
        if (collection == null) {
            return false;
        }
        for (Object current : collection) {
            if ((null == obj && null == current) || obj.equals(current)) { // Null pointer dereference
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        MyFileManager fileManager = new MyFileManager();
//        fileManager.writeToFile("Hey there!");

        fileManager.openFile("Shlomi.log");
        fileManager.writeToFile("Done..");
        fileManager.closeFile();
        ArrayList<File> files = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            File temp = new File("file" + i + ".txt");
            files.add(temp);
        }
        fileManager.isInCollection(fileManager.getFile(), files);
    }
}





