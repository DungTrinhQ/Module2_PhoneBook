import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class LoadPhoneList {
    private static final String PHONE_FILE_NAME = "PhoneList.txt";

    public void write(List<Phone> phoneList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(PHONE_FILE_NAME));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(phoneList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }

    public List<Phone> read() {
        List<Phone> phoneList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(PHONE_FILE_NAME));
            ois = new ObjectInputStream(fis);
            phoneList = (List<Phone>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return phoneList;
    }

    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
