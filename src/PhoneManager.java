import java.util.List;
import java.util.Scanner;

public class PhoneManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<Phone> phoneList;
    private LoadPhoneList loadPhoneList;

    public PhoneManager() {
        loadPhoneList = new LoadPhoneList();
        phoneList = loadPhoneList.read();
    }

    public void add() {
        String phoneNumber = inputPhoneNumber();
        System.out.println("PhoneNumber = " + phoneNumber);
        String group = inputGroup();
        String name = inputName();
        String gender = inputGender();
        String address = inputAddress();
        Phone phone = new Phone(phoneNumber, group, name, gender, address);
        phoneList.add(phone);
        loadPhoneList.write(phoneList);
    }

    public void edit(String name) {
        boolean isExisted = false;
        int size = phoneList.size();
        for (int i = 0; i < size; i++) {
            if (phoneList.get(i).getName().equals(name)) {
                isExisted = true;
                phoneList.get(i).setPhoneNumber(inputPhoneNumber());
                phoneList.get(i).setGroup(inputGroup());
                phoneList.get(i).setGender(inputGender());
                phoneList.get(i).setAddress(inputAddress());
                phoneList.get(i).setDateOfBirth(inputDateOfBirth());
                phoneList.get(i).setEmail(inputEmail());
                break;
            }
        }
        if (!isExisted) {
            System.out.println("Name not existed");
        } else {
            loadPhoneList.write(phoneList);
        }
    }

    public void delete(String phoneNumber) {
        Phone phone = null;
        int size = phoneList.size();
        for (int i = 0; i < size; i++) {
            if (phoneList.get(i).getPhoneNumber().equals(phoneNumber)) {
                phone = phoneList.get(i);
                break;
            }
        }
        if (phone != null) {
            phoneList.remove(phone);
            loadPhoneList.write(phoneList);
        } else {
            System.out.println("Phone number not existed");
        }
    }

    public void show() {
        for (Phone phone : phoneList) {
            System.out.println("Name: " + phone.getName());
            System.out.println("Phone number: " + phone.getPhoneNumber());
            System.out.println("Group: " + phone.getGroup());
            System.out.println("Gender: " + phone.getGender());
            System.out.println("Address: " + phone.getAddress());
            System.out.println("Date of birth: " + phone.getDateOfBirth());
            System.out.println("Email: "+ phone.getEmail());
        }
    }


    public String inputPhoneNumber() {
        System.out.println("Input phonenumber: ");
        return scanner.nextLine();
    }

    private String inputName() {
        System.out.println("Input name: ");
        return scanner.nextLine();
    }

    private String inputAddress() {
        System.out.println("Input address: ");
        return scanner.nextLine();
    }

    private String inputGroup() {
        System.out.println("Input group: ");
        return scanner.nextLine();
    }

    private String inputGender() {
        System.out.println("Input gender: ");
        return scanner.nextLine();
    }

    private String inputDateOfBirth() {
        System.out.println("Input date of birth: ");
        return scanner.nextLine();
    }

    private String inputEmail() {
        System.out.println("Input email: ");
        return scanner.nextLine();
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }
}
