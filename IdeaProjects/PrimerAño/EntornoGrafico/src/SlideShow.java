import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class SlideShow {
    ArrayList<ViewerSlide> viewers = new ArrayList<>();
    int currentIndex = 0;
    String[] files;

    public SlideShow() {
        File dir = new File("images/.");
        FilenameFilter filter = (dir1, name) -> name.toLowerCase().endsWith(".jpeg");
        files = dir.list(filter);

        if (files != null) {
            for (String file : files) {
                ViewerSlide viewer = new ViewerSlide(dir.getPath() + File.separator + file, this);
                addViewer(viewer);
            }

            if (!viewers.isEmpty()){
                viewers.get(currentIndex).setVisible(true);
            }else {
                System.out.println("No images found in the directory");
            }
        }
    }

    public void addViewer(ViewerSlide viewer) {
        viewer.setTitle("SlideShow " + (viewers.size() + 1));
        viewers.add(viewer);
        viewer.setVisible(false);
    }


    // Muestra la siguiente ventana de forma circular
    public void showNextViewer() {
        viewers.get(currentIndex).setVisible(false);
        currentIndex = (currentIndex + 1) % viewers.size();
        viewers.get(currentIndex).setVisible(true);
    }

    // Muestra la ventana anterior de forma circular
    public void showPreviousViewer() {
        viewers.get(currentIndex).setVisible(false);
        currentIndex = (currentIndex - 1 + viewers.size()) % viewers.size();
        viewers.get(currentIndex).setVisible(true);
    }

    public static void main(String[] args) {
        new SlideShow();
    }
}

