import java.io.File;
import java.util.Collection;

/**
 * Created by Shlomi Alon on 22/05/2017.
 */
public interface FileManager {
        void writeToFile(String messageToLog);
        void openFile(String filename);
        void closeFile();
        File getFile();
        boolean isInCollection(Object obj, Collection<?> collection);
}

