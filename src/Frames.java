import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by volkswagen1 on 11.08.2016.
 */
public class Frames {
    private JFrame frame = new JFrame();
    private JFrame mainFrame = new JFrame();
    public static File file = null;
    public static boolean correctFile = false;
    public static int PERCENT;
    private File fileOut = new File("OutputFILE.txt");
    private PersonModel firstPerson = new PersonModel();
    private PersonModel secondPerson = new PersonModel();

    {
        if (!fileOut.exists()) {
            try {
                fileOut.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static JComponent positionComponent(JComponent component, int positionX, int positionY) {
        Dimension size1 = component.getPreferredSize();
        component.setBounds(positionX, positionY, size1.width, size1.height);
        return component;
    }

    private class NextStep implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Service.FLAG_STOP = false;
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }

    }

    private class PutInFile implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Files.write(Paths.get(fileOut.getAbsolutePath()), (firstPerson.toString() + " = " + secondPerson.toString() + "  \n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            Service.FLAG_STOP = false;
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }

    }

    private class SetFile implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JFileChooser fileOpen = new JFileChooser();
//            fileOpen.DIALOG_TYPE_CHANGED_PROPERTY=".xls";
            int ret = fileOpen.showDialog(null, "Загрузить файл XLS");
            if (ret == JFileChooser.APPROVE_OPTION) {
                file = fileOpen.getSelectedFile();
                StringBuffer stringBuffer = new StringBuffer(file.getName());
                if (stringBuffer.substring(stringBuffer.lastIndexOf(".") + 1, stringBuffer.length()).equalsIgnoreCase("xls")) {
                    correctFile = true;
                }
            }
        }
    }

    private class Start implements ActionListener {
        public void actionPerformed(ActionEvent e) {
//            if(file!=null&&file.exists()&&correctFile){
//                Service service=new Service();
//                service.startSearchSameSerName(new File("D:/Java/Java projects/GetSameSerName/contragents.xls"),90);
            Thread thread = new Thread(new AnotherThread());
            thread.start();
//            }
        }
    }

    /**
     * this method just show to persons data on a new frame
     * @param firs it is a PersonModel object
     * @param second it is a PersonModel object
     * @see PersonModel
     */
    public void showSamePersons(PersonModel firs, PersonModel second) {
        firstPerson = firs;
        secondPerson = second;
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);
        JLabel firstPerson = new JLabel(firs.getSerName() + "  " + firs.getName() + "  " + firs.getFirstName());
        JLabel secondPerson = new JLabel(second.getSerName() + "  " + second.getName() + "  " + second.getFirstName());
        JButton putInFile = new JButton("Save in File");
        putInFile.addActionListener(new PutInFile());
        JButton next = new JButton("Next ->");
        next.addActionListener(new NextStep());
        panel.add(positionComponent(firstPerson, 80, 50));
        panel.add(positionComponent(secondPerson, 80, 100));
        panel.add(positionComponent(putInFile, 80, 200));
        panel.add(positionComponent(next, 250, 200));
        frame.setSize(400, 300);
        frame.setLocation(600, 400);
        frame.setVisible(true);
    }

    /**
     * This method show main frame. Here user input main data (xls file and same percent ) */
    public void showMainFrame() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = (JPanel) mainFrame.getContentPane();
        panel.setLayout(null);
        JLabel text = new JLabel("Здесь нужно выбрать файл с расширением  xls и  нажать кнопку старт");
        JButton setFile = new JButton("Загрузить файл");
        setFile.addActionListener(new SetFile());
        JButton start = new JButton("Старт");
        DefaultListModel listModel = new DefaultListModel();

        listModel.addElement("50");
        listModel.addElement("60");
        listModel.addElement("70");
        listModel.addElement("80");
        listModel.addElement("90");
        listModel.addElement("100");
        final JList list = new JList(listModel);
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    PERCENT = new Integer(list.getSelectedValuesList().get(0).toString());
                }
            }
        });
//        JProgressBar progressBar=new JProgressBar();
//        progressBar.setMaximum(100);
//        progressBar.setMinimum(0);
//        progressBar.setSize(500,10);
        start.addActionListener(new Start());
        panel.add(positionComponent(text, 30, 10));
        panel.add(positionComponent(setFile, 220, 70));
        panel.add(positionComponent(start, 400, 70));
        panel.add(positionComponent(list, 10, 40));
//        panel.add(positionComponent(progressBar,60,80));
        mainFrame.setSize(550, 200);
        mainFrame.setLocation(600, 400);
        mainFrame.setVisible(true);

    }
}
