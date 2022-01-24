package Entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReadFileTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void readFile(@TempDir Path tempDir) throws IOException {
        Path file1 = tempDir.resolve("myfile.txt");
        WriteFIleForTransports.writeFile(file1.toString());
        ReadFile.readFile("myfile.txt");
        assertEquals("", outContent.toString());
    }

}