package testDemo.ports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public interface LocalFilePort {

    File getFromPath(String path);

    default FileInputStream fileStream(String path) throws FileNotFoundException {
        return new FileInputStream(getFromPath(path));
    }
}
