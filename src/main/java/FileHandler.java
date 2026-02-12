import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileHandler {
    private String folderPath;

    public String getFolderPath() {
        return folderPath;
    }

    private Boolean isValidRequest(Path filePath) {
        Path p = Paths.get(filePath.toString());
        return Files.exists(p);
    }

    public String getFileContents(ArrayList<String> fileName) throws IOException {
        ArrayList<String> fileContent = new ArrayList<>();
        for (int i = 0; i < fileName.size(); i++) {
            Path filePath = Paths.get(folderPath + fileName);
            if(isValidRequest(filePath)) {
                fileContent.add(Files.readString(filePath)+"\n");
            }
            else {
                return "Error! Invalid request - File does not exist.";
            }
        }
        return fileContent.toString();
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    public FileHandler(String folderPath) {
        this.folderPath = folderPath;
    }

    @Override
    public String toString() {
        return "FileHandler{" +
                "folderPath='" + folderPath + '\'' +
                '}';
    }
}
