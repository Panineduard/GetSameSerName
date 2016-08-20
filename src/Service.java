import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by volkswagen1 on 11.08.2016.
 * it is a main logic class
 */
public class Service {
    private Frames frames = new Frames();
    public static boolean FLAG_STOP = false;

    /**
     * @param one         it is a PersonModel object
     * @param two         it is a PersonModel object
     * @param samePercent it is a percent of same data
     * @return all percent on same
     * @see PersonModel
     */
    private int isPersonsTheSame(PersonModel one, PersonModel two, int samePercent) {
        int serNamePercent = 0;
        if (one.getSerName() != null && two.getSerName() != null) {
            if (one.getSerName().length() == two.getSerName().length()) {
                StringBuffer stringBuffer = new StringBuffer(one.getSerName().toLowerCase());
                StringBuffer stringBuffer1 = new StringBuffer(two.getSerName().toLowerCase());
                int count1 = 0;
                for (int i = 0; i < stringBuffer.length(); i++) {
                    if (stringBuffer.charAt(i) == stringBuffer1.charAt(i)) {
                        count1++;
                    }
                }
                serNamePercent = (count1 * 100) / stringBuffer.length();
            }

            if (one.getSerName().length() > two.getSerName().length()) {
                StringBuffer stringBuffer = new StringBuffer(one.getSerName().toLowerCase());
                StringBuffer stringBuffer1 = new StringBuffer(two.getSerName().toLowerCase());
                int count1 = 0;
                int count2 = 0;
                for (int i = 0; i < stringBuffer1.length(); i++) {
                    if (stringBuffer.charAt(i) == stringBuffer1.charAt(i)) {
                        count1++;
                    }
                }
                for (int i = stringBuffer1.length() - 1; i >= 0; i--) {
                    if (stringBuffer.charAt(i + (stringBuffer.length() - stringBuffer1.length())) == stringBuffer1.charAt(i)) {
                        count2++;
                    }
                }
                if (count1 >= count2) {
                    serNamePercent = (count1 * 100) / stringBuffer1.length();
                } else {
                    serNamePercent = (count2 * 100) / stringBuffer1.length();
                }
            }
            if (one.getSerName().length() < two.getSerName().length()) {
                StringBuffer stringBuffer = new StringBuffer(one.getSerName().toLowerCase());
                StringBuffer stringBuffer1 = new StringBuffer(two.getSerName().toLowerCase());
                int count1 = 0;
                int count2 = 0;
                for (int i = 0; i < stringBuffer.length(); i++) {
                    if (stringBuffer.charAt(i) == stringBuffer1.charAt(i)) {
                        count1++;
                    }
                }
                for (int i = stringBuffer.length() - 1; i >= 0; i--) {
                    if (stringBuffer1.charAt(i + (stringBuffer1.length() - stringBuffer.length())) == stringBuffer.charAt(i)) {
                        count2++;
                    }
                }
                if (count1 >= count2) {
                    serNamePercent = (count1 * 100) / stringBuffer.length();
                } else {
                    serNamePercent = (count2 * 100) / stringBuffer.length();
                }
            }
        }
        int namePercent = 0;
        if (one.getName() != null && two.getName() != null) {
            if (one.getName().length() == two.getName().length()) {
                StringBuffer stringBuffer = new StringBuffer(one.getName().toLowerCase());
                StringBuffer stringBuffer1 = new StringBuffer(two.getName().toLowerCase());
                int count1 = 0;
                for (int i = 0; i < stringBuffer.length(); i++) {
                    if (stringBuffer.charAt(i) == stringBuffer1.charAt(i)) {
                        count1++;
                    }
                    ;
                }
                namePercent = (count1 * 100) / stringBuffer.length();
            }
            if (one.getName().length() > two.getName().length()) {
                StringBuffer stringBuffer = new StringBuffer(one.getName().toLowerCase());
                StringBuffer stringBuffer1 = new StringBuffer(two.getName().toLowerCase());
                int count1 = 0;
                int count2 = 0;
                for (int i = 0; i < stringBuffer1.length(); i++) {
                    if (stringBuffer.charAt(i) == stringBuffer1.charAt(i)) {
                        count1++;
                    }
                }
                for (int i = stringBuffer1.length() - 1; i >= 0; i--) {
                    if (stringBuffer.charAt(i + (stringBuffer.length() - stringBuffer1.length())) == stringBuffer1.charAt(i)) {
                        count2++;
                    }
                }
                if (count1 >= count2) {
                    namePercent = (count1 * 100) / stringBuffer1.length();
                } else {
                    namePercent = (count2 * 100) / stringBuffer1.length();
                }
            }
            if (one.getName().length() < two.getName().length()) {
                StringBuffer stringBuffer = new StringBuffer(one.getName().toLowerCase());
                StringBuffer stringBuffer1 = new StringBuffer(two.getName().toLowerCase());
                int count1 = 0;
                int count2 = 0;
                for (int i = 0; i < stringBuffer.length(); i++) {
                    if (stringBuffer.charAt(i) == stringBuffer1.charAt(i)) {
                        count1++;
                    }
                }
                for (int i = stringBuffer.length() - 1; i >= 0; i--) {
                    if (stringBuffer1.charAt(i + (stringBuffer1.length() - stringBuffer.length())) == stringBuffer.charAt(i)) {
                        count2++;
                    }
                }
                if (count1 >= count2) {
                    namePercent = (count1 * 100) / stringBuffer.length();
                } else {
                    namePercent = (count2 * 100) / stringBuffer.length();
                }
            }
        }
        int firstNamePercent = 0;
        if (one.getFirstName() != null && two.getFirstName() != null) {
            if (one.getFirstName().length() == two.getFirstName().length()) {
                StringBuffer stringBuffer = new StringBuffer(one.getFirstName().toLowerCase());
                StringBuffer stringBuffer1 = new StringBuffer(two.getFirstName().toLowerCase());
                int count1 = 0;
                for (int i = 0; i < stringBuffer.length(); i++) {
                    if (stringBuffer.charAt(i) == stringBuffer1.charAt(i)) {
                        count1++;
                    }
                    ;
                }
                firstNamePercent = (count1 * 100) / stringBuffer.length();
            }

            if (one.getFirstName().length() > two.getFirstName().length()) {
                StringBuffer stringBuffer = new StringBuffer(one.getFirstName().toLowerCase());
                StringBuffer stringBuffer1 = new StringBuffer(two.getFirstName().toLowerCase());
                int count1 = 0;
                int count2 = 0;
                for (int i = 0; i < stringBuffer1.length(); i++) {
                    if (stringBuffer.charAt(i) == stringBuffer1.charAt(i)) {
                        count1++;
                    }
                }
                for (int i = stringBuffer1.length() - 1; i >= 0; i--) {
                    if (stringBuffer.charAt(i + (stringBuffer.length() - stringBuffer1.length())) == stringBuffer1.charAt(i)) {
                        count2++;
                    }
                }
                if (count1 >= count2) {
                    firstNamePercent = (count1 * 100) / stringBuffer1.length();
                } else {
                    firstNamePercent = (count2 * 100) / stringBuffer1.length();
                }
            }
            if (one.getFirstName().length() < two.getFirstName().length()) {
                StringBuffer stringBuffer = new StringBuffer(one.getFirstName().toLowerCase());
                StringBuffer stringBuffer1 = new StringBuffer(two.getFirstName().toLowerCase());
                int count1 = 0;
                int count2 = 0;
                for (int i = 0; i < stringBuffer.length(); i++) {
                    if (stringBuffer.charAt(i) == stringBuffer1.charAt(i)) {
                        count1++;
                    }
                }
                for (int i = stringBuffer.length() - 1; i >= 0; i--) {
                    if (stringBuffer1.charAt(i + (stringBuffer1.length() - stringBuffer.length())) == stringBuffer.charAt(i)) {
                        count2++;
                    }
                }
                if (count1 >= count2) {
                    firstNamePercent = (count1 * 100) / stringBuffer.length();
                } else {
                    firstNamePercent = (count2 * 100) / stringBuffer.length();
                }
            }
        }
        return (serNamePercent + namePercent + firstNamePercent) / 3;
    }

    private List<PersonModel> xlsReader(File file) {
        HSSFWorkbook myExcelBook = null;
        List<PersonModel> personModels = new ArrayList<PersonModel>();
        try {
            myExcelBook = new HSSFWorkbook(new FileInputStream(file));
            HSSFSheet myExcelSheet = myExcelBook.getSheet(myExcelBook.getSheetName(0));
            int from = myExcelSheet.getFirstRowNum() + 1;
            int to = myExcelSheet.getLastRowNum();
            for (int i = from; i < to; i++) {
                HSSFRow row = myExcelSheet.getRow(i);
                if (row.getCell(1).getCellType() == HSSFCell.CELL_TYPE_STRING) {
                    String name = row.getCell(1).getStringCellValue();
                    String[] personData = name.trim().split("\\s+");
                    if (personData.length > 0) {
                        PersonModel personModel = new PersonModel();
                        if (personData.length >= 1) {
                            personModel.setSerName(personData[0]);
                        }
                        if (personData.length >= 2) {
                            personModel.setName(personData[1]);
                        }
                        if (personData.length >= 3) {
                            personModel.setFirstName(personData[2]);
                        }
                        personModels.add(personModel);
                    }
                }
            }
            myExcelBook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personModels;
    }

    /**
     * Method show frame if persons data the same and waiting fo user answer
     *
     * @param file        it is a xls file for work
     * @param samePercent it is a percent of same data
     * @see Frames
     */
    public boolean startSearchSameSerName(File file, int samePercent) {
        List<PersonModel> people = xlsReader(file);
        for (int i = 0; i < people.size(); i++) {
            for (int j = i + 1; j < people.size(); j++) {
                if (samePercent <= isPersonsTheSame(people.get(i), people.get(j), samePercent)) {

                    new Frames().showSamePersons(people.get(i), people.get(j));
                    FLAG_STOP = true;
                }
                ;
                while (FLAG_STOP) {
                    Thread.yield();
                }

            }

        }
        return true;
    }
}
