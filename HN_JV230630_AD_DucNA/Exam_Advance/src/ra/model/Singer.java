package ra.model;

import java.util.Scanner;

public class Singer {
    private int singerId = 4;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    static private int count = 0;

    public Singer() {
        this.singerId = count++;
    }

    public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = count++;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên ca sĩ: ");
        while (true) {
            this.singerName = scanner.nextLine();
            if (this.singerName.isEmpty()) {
                System.out.println("Tên ca sĩ không được để trống. Mời nhập lại: ");
            } else {
                break;
            }
        }

        System.out.println("Nhập tuổi: ");
        while (true) {
            this.age = Integer.parseInt(scanner.nextLine());
            if (this.age < 0) {
                System.out.println("Tuổi phải lớn hơn 0. Mời nhập lại: ");
            } else {
                break;
            }
        }

        System.out.println("Nhập quốc tịch: ");
        while (true) {
            this.nationality = scanner.nextLine();
            if (this.nationality.isEmpty()) {
                System.out.println("Quốc tịch không được để trống. Mời nhập lại: ");
            } else {
                break;
            }
        }

        System.out.println("Nhập giới tính: ");
        this.gender = Boolean.parseBoolean(scanner.nextLine());


        System.out.println("Nhập thẻ loại: ");
        while (true) {
            this.genre = scanner.nextLine();
            if (this.genre.isEmpty()) {
                System.out.println("Thể loại không được để trống. Mời nhập lại: ");
            } else {
                break;
            }
        }
    }


    public void displayData() {
        System.out.println("Singer Info: {" +
                "singerId=" + singerId +
                ", singerName='" + singerName + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", gender=" + gender +
                ", genre='" + genre + '\'' +
                '}');
    }
}

