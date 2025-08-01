package org.example.domain;

import java.io.IOException;
import java.util.List;

public interface LogWriter<T> {
    void write(T log) throws IOException;
    List<String> readAll() throws IOException;
}