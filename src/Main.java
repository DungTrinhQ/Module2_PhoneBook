import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choose = null;
        boolean exit = false;
        PhoneManager phoneManager = new PhoneManager();
        String phoneNum;
        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    phoneManager.show();
                    break;
                case "2":
                    phoneManager.add();
                    System.out.println("Add completed!");
                    break;
                case "3":
                    System.out.println("Nhập tên cần chỉnh sửa: ");
                    String name = scanner.nextLine();
                    phoneManager.edit(name);
                    System.out.println("Edit completed!");
                    break;
                case "4":
                    System.out.println("Nhập số điện thoại cần xóa: ");
                    phoneNum = scanner.nextLine();
                    phoneManager.delete(phoneNum);
                    System.out.println("Deleted!");
                    break;
            }
        }

    }

    public static void showMenu() {
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7.Ghi vào file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng:");
    }
}
