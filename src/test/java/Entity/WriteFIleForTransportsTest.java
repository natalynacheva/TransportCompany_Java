package Entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

;

class WriteFIleForTransportsTest{
    @Test
    void CheckIfWrite(@TempDir Path tempDir) throws IOException {
        Path file1 = tempDir.resolve("myfile.txt");


        WriteFIleForTransports.writeFile(file1.toString());

        assertTrue(Files.exists(file1), "File should exist");
    }
}