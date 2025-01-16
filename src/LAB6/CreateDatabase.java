package LAB6;

import org.apache.derby.tools.ij;

import java.io.IOException;

public class CreateDatabase {
    public static void main(String[] args) throws IOException {
        String[] ij_args = {"C:\\Users\\User\\IdeaProjects\\CSC3104 - Advanced Programming Lab\\src\\LAB6\\CreateTable_javadb.txt"};
        ij.main(ij_args);
    }
}
