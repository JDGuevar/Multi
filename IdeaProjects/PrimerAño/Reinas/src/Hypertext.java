import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class Hypertext {
    private String title;
    public PrintWriter pw;
    public void html(String filename, String title){
        if (!filename.toLowerCase().contains(".html")) filename+=".html";
        this.title = title;

        try{
            pw =  new PrintWriter(filename);
            pw.println("<!doctype html>");
            pw.println("<html>");
            head();
            body();
            pw.println("</html>");
            pw.close();
        }catch (FileNotFoundException exception){
            System.err.println("Something went wrong about file " +filename);
        }
    }
    private void head()
    {
        pw.println("<head>");
        pw.println("<meta charset=\"utf-8\">");
        pw.printf("<title>%s</title>\n", title);
        style();
        pw.println("</head>");
    }

    private void style()
    {
        pw.println("<style>");
        styleContent();
        pw.println("</style>");
    }

    private void body()
    {
        pw.println("<body>");
        bodyContent();
        pw.println("</body>");
    }


    public abstract void styleContent();
    public abstract void bodyContent();
}