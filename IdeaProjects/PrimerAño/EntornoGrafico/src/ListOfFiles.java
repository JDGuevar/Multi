import java.io.File;
import java.io.FilenameFilter;

public class ListOfFiles {

    final String fileType = ".jpeg";
    final String directory = "./images";

    public ListOfFiles(){
        usingList();
        usingListFiles();
        usingListFilenameFilter();
        usingListFileFilenameFilter();
    }

    public void usingList(){
        File directoryPath = new File(directory);
        String listOfFiles[] = directoryPath.list();
        assert listOfFiles != null : "No files in the directory";

        for(String fileName : listOfFiles)
            if(fileName.toLowerCase().endsWith(fileType)) System.out.println(fileName);
        System.out.println(listOfFiles.length);
    }

    public void usingListFiles(){
        File directoryPath = new File(directory);
        File filesList[] = directoryPath.listFiles();
        assert filesList != null : "No files in the directory";
        for(File file : filesList){
            String fileName = file.getName();
            if(file.getName().toLowerCase().endsWith(fileType)) System.out.println(file.getName());
        }

        System.out.println(filesList.length);
    }

    public void usingListFilenameFilter(){
        File directoryPath = new File(directory);
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(fileType);
            }
        };
        String listOfFiles[] = directoryPath.list(filter);
        assert listOfFiles != null : "No files in the directory";
        for(String fileName : listOfFiles)
            System.out.println(fileName);
        System.out.println(listOfFiles.length);
    }

    public void usingListFileFilenameFilter(){
        File directoryPath = new File(directory);
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(fileType);
            }
        };
        File filesList[] = directoryPath.listFiles(filter);
        assert filesList != null : "No files in the directory";
        for(File file : filesList)
            System.out.println(file.getName());
        System.out.println(filesList.length);
    }

    public static void main(String[] args) {
        new ListOfFiles();
    }
}
