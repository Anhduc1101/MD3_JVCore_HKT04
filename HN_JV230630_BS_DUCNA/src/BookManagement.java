import java.util.Scanner;

public class BookManagement {
    static Scanner scanner = new Scanner(System.in);
    static Book[] books = new Book[100];

    static {
        books[0] = new Book(0, "Số đỏ", "Vũ Trọng Phụng", "Truyện ngắn", 1000, 1500, 0, true);
        books[1] = new Book(1, "Làng", "Kim Lân", "Truyện vừa", 2000, 3500, 0, true);
        books[2] = new Book(2, "Số đỏ", "Vũ Trọng Phụng", "Truyện dài", 3000, 4000, 0, true);
    }

    static int index = 3;

    public static void main(String[] args) {
        for (int i = 0; i < index; i++) {
            books[i].displayData();
        }
        while (true) {
            System.out.println("****** JAVA-HACKATHON-05-BASIC-MENU ******");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp theo lợi nhuận tăng dần");
            System.out.println("4. Xóa theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.println("******************************************");
            System.out.println("Mời nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            handlechoice(choice);
        }
    }

    private static void handlechoice(int choice) {
        switch (choice) {
            case 1:
                handleAdd();
                break;
            case 2:
                handleDisplayAllBooksInfo();
                break;
            case 3:
                handleSort();
                break;
            case 4:
                handleDelete();
                break;
            case 5:
                handleSearch();
                break;
            case 6:
                handleChangeBookInfoByBookId();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Không có lựa chọn bạn vừa nhập !");
                System.exit(1);
                break;

        }
    }

    private static void handleChangeBookInfoByBookId() {
        System.out.println("Nhập vào mã sách bạn cần thay đổi thông tin: ");
        int changeId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < index; i++) {
            if (books[i].getBookId() == changeId) {
                books[i].displayData();
                books[i].inputData();
            }
        }
        handleDisplayAllBooksInfo();
        System.out.println(" Change Done !");
    }

    private static void handleSearch() {
        System.out.println("Nhập vào tên sách hoặc mô tả bạn cần tìm: ");
        String inputSearch = scanner.nextLine();
        for (int i = 0; i < index; i++) {
            if (books[i].getBookName().toLowerCase().contains(inputSearch.toLowerCase()) ||
                    books[i].getDescription().toLowerCase().contains(inputSearch.toLowerCase())) {
                books[i].displayData();
            }
        }
        System.out.println("Search Done !");
    }

    private static void handleDelete() {
        System.out.println("Nhập vào mã sách bạn muốn xóa: ");
        int deleteId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < index; i++) {
            if (books[i].getBookId() == deleteId) {
                for (int j = 0; j < index; j++) {
                    books[j] = books[j + 1];
                }
            }
            index--;
            System.out.println(" Deleted Done !");
            System.out.println("Danh sách sách sau khi bị xóa :");
            handleDisplayAllBooksInfo();
            return;
        }
    }

    private static void handleSort() {
        System.out.println("Thứ tự sắp xếp theo lợi nhuận tăng dần là: ");
        for (int i = 0; i < index - 1; i++) {
            for (int j = 0; j < index - 1; j++) {
                if (books[j].getInterest() > books[j + 1].getInterest()) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
        handleDisplayAllBooksInfo();
        System.out.println(" Sorted Done !");
    }

    private static void handleDisplayAllBooksInfo() {
        System.out.println("Thông tin tất cả các sách: ");
        for (int i = 0; i < index; i++) {
            books[i].displayData();
        }
        System.out.println(" Display Done !");
    }

    private static void handleAdd() {
        System.out.println("Nhập só lượng sách cần thêm mới: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sách: ");
            Book book = new Book();
            book.inputData();
            books[index] = book;
            index++;
        }
        System.out.println(" Add Done! ");
    }
}
