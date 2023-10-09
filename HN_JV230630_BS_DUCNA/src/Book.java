import java.util.Scanner;

public class Book {
    private int bookId=4;
    private String bookName;
    private String author;
    private String description;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus = true;
    static private int count = 0;

    public Book() {
        this.bookId = count++;
    }

    public Book(int bookId, String bookName, String author, String description, double importPrice, double exportPrice, float interest, boolean bookStatus) {
        this.bookId = count++;
        this.bookName = bookName;
        this.author = author;
        this.description = description;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        interest= (float) (exportPrice-importPrice);
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sách: ");
        while (true) {
            this.bookName = scanner.nextLine();
            if (this.bookName.isEmpty()) {
                System.out.println("Tên sách không được để trống. Mời nhập lại: ");
            } else {
                break;
            }
        }

        System.out.println("Nhập tên tác giả: ");
        while (true) {
            this.author = scanner.nextLine();
            if (this.author.isEmpty()) {
                System.out.println("Tên tác giả không được để trống. Mời nhập lại: ");
            } else {
                break;
            }
        }

        System.out.println("Nhập mô tả: ");
        while (true) {
            this.description = scanner.nextLine();
            if (this.description.isEmpty()) {
                System.out.println("Mô tả không được để trống. Mời nhập lại: ");
            } else if (this.description.length() < 10) {
                System.out.println("Mô tả ít nhất phải 10 ký tự trở lên. Mời nhập lại: ");
            } else {
                break;
            }
        }

        System.out.println("Giá nhập vào: ");
        while (true) {
            this.importPrice = Double.parseDouble(scanner.nextLine());
            if (this.importPrice < 0) {
                System.out.println("Giá nhập vào phải lớn hơn 0. Mời nhập lại: ");
            } else {
                break;
            }
        }

        System.out.println("Giá bán ra: ");
        while (true) {
            this.exportPrice = Double.parseDouble(scanner.nextLine());
            if (this.exportPrice < (this.importPrice * 1.2)) {
                System.out.println("Giá bán ra phải lớn hơn 1.2 lần giá nhập vào. Mời nhập lại: ");
            } else {
                break;
            }
        }
    }

    public void displayData(){
        System.out.println("Book Info: {" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", interest=" + getInterest() +
                ", bookStatus=" + bookStatus +
                '}');
    }
}
