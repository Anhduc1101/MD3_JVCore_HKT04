package ra.model;

import java.util.Date;
import java.util.Scanner;

public class MusicManagement {

    static Scanner scanner = new Scanner(System.in);
    static Singer[] singers = new Singer[100];

    static {
        singers[0] = new Singer(0, "Taylor", 30, "China", false, "Pop");
        singers[1] = new Singer(1, "Maroon 5", 40, "America", true, "RnB");
        singers[2] = new Singer(2, "The Wall", 30, "Vietnam", true, "Rock");
    }

    static int indexSinger = 3;
    static Song[] songs = new Song[100];

    static {
        songs[0] = new Song("S301", "Shalala", "Top 10 MV", singers[0], "Swift", new Date(), true);
        songs[1] = new Song("S201", "SSSS", "Top 10 MV Châu Á", singers[1], "Sơn Tùng", new Date(), true);
        songs[2] = new Song("S311", "The bét", "Top 10 Billboard", singers[2], "Suzuki", new Date(), true);
    }

    static int indexSong = 3;


    public static void main(String[] args) {
        for (int i = 0; i < indexSinger; i++) {
            singers[i].displayData();
        }

        while (true) {
            System.out.println(" ************************MUSIC-MANAGEMENT************************* ");
            System.out.println(" 1. Quản lý ca sĩ");
            System.out.println(" 2. Quản lý bài hát");
            System.out.println(" 3. Tìm kiếm bài hát");
            System.out.println(" 4. Thoát");
            System.out.println("Nhập vào lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            handleChoice(choice);
        }
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                handleSingerManagement();
                break;
            case 2:
                handleSongManagement();
                break;
            case 3:
                handleSearchManagement();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Không có lựa chọn này !");
                System.exit(1);
                break;

        }
    }

    private static void handleSearchManagement() {
        while (true) {
            System.out.println(" ************************SEARCH-MANAGEMENT************************* ");
            System.out.println("1. Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại: ");
            System.out.println("2. Tìm kiếm ca sĩ theo tên hoặc thể loại: ");
            System.out.println("3. Hiển thị danh sách bài hát theo thứ tự tên tăng dần: ");
            System.out.println("4. Hiển thị 10 bài hát được đăng mới nhất: ");
            System.out.println("5. Thoát ");
            System.out.println("Mời nhập lựa chọn: ");
            int choiceSearch = Integer.parseInt(scanner.nextLine());
            if (choiceSearch ==5){
                return;
            }
            handlechoiceSearchManagement(choiceSearch);
        }
    }

    private static void handlechoiceSearchManagement(int choiceSearch) {
        switch (choiceSearch) {
            case 1:
                handleSearchSongBySingerNameOrByGenre();
                break;
            case 2:
                handleSearchSingerByNameOrByGenre();
                break;
            case 3:
                handleDisplaySort();
                break;
            case 4:
                handleDisplayTenNewestSong();
                break;
            case 5:
                return;
            default:
                System.out.println("Không có lựa chọn này!");
                break;

        }
    }

    private static void handleDisplayTenNewestSong() {
        System.out.println("Danh sách 10 bài hát mới nhất : ");
        for (int i = 0; i < indexSong - 1; i++) {
            for (int j = 0; j < indexSong - 1; j++) {
                if (songs[j].getCreatedDate().compareTo(songs[j + 1].getCreatedDate()) < 0) {
                    Song temp = songs[j];
                    songs[j] = songs[j + 1];
                    songs[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i <10; i++) {
            if(songs[i]!=null){
                songs[i].displayData();
            }
        }
    }

    private static void handleDisplaySort() {
        System.out.println("Thứ tự trước khi sắp xếp :");
        handleDisplaySong();
        for (int i = 0; i < indexSong - 1; i++) {
            for (int j = 0; j < indexSong - 1; j++) {
                if (songs[j].getSongName().compareTo(songs[j + 1].getSongName()) > 0) {
                    Song temp = songs[j];
                    songs[j] = songs[j + 1];
                    songs[j + 1] = temp;
                }
            }
        }
        System.out.println("Thứ tự tăng dần sau khi được sắp xếp là:");
        handleDisplaySong();
        System.out.println(" ------------------ ---------------------");
    }

    private static void handleSearchSingerByNameOrByGenre() {
        handleDisplaySinger();
        System.out.println("Nhập tên hoặc thể loại để tìm ca sĩ: ");
        String inputSearch = scanner.nextLine();
        for (int i = 0; i < indexSinger; i++) {
            if (singers[i].getSingerName().toLowerCase().contains(inputSearch.toLowerCase()) ||
                    singers[i].getGenre().toLowerCase().contains(inputSearch.toLowerCase())) {
                singers[i].displayData();
            }
        }
        System.out.println("------------------------------------------");
    }

    private static void handleSearchSongBySingerNameOrByGenre() {
        handleDisplaySong();
        System.out.println("Nhập tên ca sĩ hoặc thể loại để tìm bài hát: ");
        String inputFindBySingerNameOrGenre = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < indexSong; i++) {
            if (songs[i].getSinger().getSingerName().toLowerCase().contains(inputFindBySingerNameOrGenre.toLowerCase()) ||
                    songs[i].getSinger().getGenre().toLowerCase().contains(inputFindBySingerNameOrGenre.toLowerCase())) {
                songs[i].displayData();
                check = true;
                System.out.println("Search Done !");
                break;
            }
        }
        if (!check) {
            System.out.println("Không có dữ liệu bạn cần tìm ! ");
        }
    }

    private static void handleSongManagement() {
        while (true) {
            System.out.println(" ************************SONG-MANAGEMENT************************* ");
            System.out.println("1. Nhập tên bài hát: ");
            System.out.println("2. Hiển thị danh sách bài hát: ");
            System.out.println("3. Thay đổi thông tin bài hát: ");
            System.out.println("4. Xóa bài hát: ");
            System.out.println("5. Thoát ");
            System.out.println("Mời nhập lựa chọn: ");
            int choiceSong = Integer.parseInt(scanner.nextLine());
            if(choiceSong==5){
                return;
            }
            handlechoiceSongManagement(choiceSong);
        }
    }

    private static void handlechoiceSongManagement(int choiceSong) {
        switch (choiceSong) {
            case 1:
                handleAddSong();
                break;
            case 2:
                handleDisplaySong();
                break;
            case 3:
                handleEditSong();
                break;
            case 4:
                handleDeleteSong();
                break;
            case 5:
                return;
            default:
                System.out.println("Không có lựa chọn này!");

                break;

        }
    }

    private static void handleDeleteSong() {
        handleDisplaySong();
        System.out.println("Nhập mã bài hát mà bạn muốn xóa: ");
        String deleteStr = scanner.nextLine();
        for (int i = 0; i < indexSong; i++) {
            if (songs[i].getSongId().toLowerCase().equals(deleteStr.toLowerCase())) {
                for (int j = 0; j < indexSong; j++) {
                    songs[j] = songs[j + 1];
                }
            }
            indexSong--;
            return;
        }
        System.out.println("Delete Done !");
    }

    private static void handleEditSong() {
        handleDisplaySong();
        System.out.println("Nhập vào mã bài hát bạn muốn sửa: ");
        String editStr = scanner.nextLine();
        for (int i = 0; i < indexSong; i++) {
            if (songs[i].getSongId().toLowerCase().equals(editStr.toLowerCase())) {
                songs[i].displayData();
                songs[i].inputData(singers, indexSinger);
            }
        }
        System.out.println("Change Done !");
    }

    private static void handleDisplaySong() {
        System.out.println("Danh sách bài hát: ");
        for (int i = 0; i < indexSong; i++) {
            songs[i].displayData();
        }
        System.out.println("Displayed Done !");
    }

    private static void handleAddSong() {
        System.out.println("Nhập vào số lượng bài hát: ");
        int inputNumberSong = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < inputNumberSong; i++) {
            System.out.println("Nhập thông tin bài hát: ");
            Song song = new Song();
            song.inputData(singers, indexSinger);
            songs[indexSong++] = song;
        }
    }

    private static void handleSingerManagement() {
        while (true) {
            System.out.println(" ************************SINGER-MANAGEMENT************************* ");
            System.out.println("1. Nhập ca sĩ: ");
            System.out.println("2. Hiển thị danh sách ca sĩ: ");
            System.out.println("3. Thay đổi thông tin ca sĩ: ");
            System.out.println("4. Xóa ca sĩ: ");
            System.out.println("5. Thoát ");
            System.out.println("Mời nhập lựa chọn: ");
            int choiceSinger = Integer.parseInt(scanner.nextLine());
            if(choiceSinger==5){
                return;
            }
            handlechoiceSingerManagement(choiceSinger);
        }
    }

    private static void handlechoiceSingerManagement(int choiceSinger) {
        switch (choiceSinger) {
            case 1:
                handleAddNewSinger();
                break;
            case 2:
                handleDisplaySinger();
                break;
            case 3:
                handleEditSinger();
                break;
            case 4:
                handleDeleteSinger();
                break;
            case 5:

            default:
                System.out.println("Không có lựa chọn này");
                break;

        }
    }

    private static void handleDeleteSinger() {
        System.out.println("Nhập mã ca sĩ muốn xóa: ");
        int deleteId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < indexSong; i++) {
            if (songs[i].getSinger().getSingerId() == deleteId) {
                System.out.println("ca sĩ có bài hát. Không được xóa !");
                return;
            }
        }

        for (int i = 0; i < indexSinger; i++) {
            if (singers[i].getSingerId() == deleteId) {
                for (int j = 0; j < indexSinger; j++) {
                    singers[j] = singers[j + 1];
                }
            }
            indexSinger--;
            return;
        }
        System.out.println("Không tìm thấy ca sĩ cần xóa !");
    }

    private static void handleEditSinger() {
        System.out.println("Nhập ID của ca sĩ cần sửa: ");
        int editId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < indexSinger; i++) {
            if (singers[i].getSingerId() == editId) {
                singers[i].displayData();
                singers[i].inputData();
            }
        }
        System.out.println("Edited Done !");
    }

    private static void handleDisplaySinger() {
        for (int i = 0; i < indexSinger; i++) {
            singers[i].displayData();
        }
    }

    private static void handleAddNewSinger() {
        System.out.println("Nhập số lượng ca sĩ cần thêm mới: ");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập thông tin ca sĩ mới: ");
            Singer singer = new Singer();
            singer.inputData();
            singers[indexSinger++] = singer;
        }
        System.out.println("Added Done !");
    }
}
