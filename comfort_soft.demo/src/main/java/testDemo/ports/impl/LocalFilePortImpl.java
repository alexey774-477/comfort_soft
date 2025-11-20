package testDemo.ports.impl;



import testDemo.application.annotation.Port;
import testDemo.ports.LocalFilePort;

import java.io.File;

@Port
public class LocalFilePortImpl implements LocalFilePort {

    @Override
    public File getFromPath(String path) {

        return path.isBlank() ? null : new File(path);
    }
}
