import javax.swing.*;
import java.io.File;

/**
 * Created by volkswagen1 on 12.08.2016.
 * here we start new Thread with main logic
 */
public class AnotherThread implements Runnable  {
    public void run() {
        if(Frames.file!=null&&Frames.correctFile&&Frames.PERCENT>0) {
            Service service = new Service();
            service.startSearchSameSerName(Frames.file, Frames.PERCENT);
        }
        else{
            JOptionPane.showMessageDialog(new JFrame(),"Введен не корректный файл или неправильные настройки");
        }
    }
}
