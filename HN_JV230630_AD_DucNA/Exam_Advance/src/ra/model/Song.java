package ra.model;

import java.util.Date;
import java.util.Scanner;

public class Song {
    private String songId;
    private String songName;
    private String description;
    private Singer singer;
    private String songWriter;
    private Date createdDate = new Date();
    private boolean songStatus;

    public Song() {
    }

    public Song(String songId, String songName, String description, Singer singer, String songWriter, Date createdDate, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.description = description;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public void inputData(Singer[] singers, int indexSinger) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã bài hát: ");
        while (true) {
            this.songId = scanner.nextLine();
            if (this.songId.length() < 4) {
                System.out.println("Độ dài mã bài hát không được ngắn hơn 4 ký tự. Mời nhập lại: ");
            } else if (!this.songId.startsWith("S")) {
                System.out.println("Mã bài hát bắt buộc phải bắt đầu bằng ký tự S. Mời nhập lại: ");
            } else {
                break;
            }
        }

        System.out.println("Nhập tên bài hát: ");
        while (true) {
            this.songName = scanner.nextLine();
            if (this.songName.isEmpty()) {
                System.out.println("Tên bài hát không được để trống. Mời nhập lại: ");
            } else {
                break;
            }
        }

        System.out.println("Nhập mô tả: ");
        this.description = scanner.nextLine();

        System.out.println("Danh sách các ca sĩ, nhập id để lựa chọn: ");
        for (int i = 0; i < indexSinger; i++) {
            singers[i].displayData();
        }
        System.out.println("Nhập ID: ");
        boolean checkSinger=false;
        while (true) {
            int checkId = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < indexSinger; i++) {
                if (singers[i].getSingerId() == checkId) {
                    this.singer = singers[i];
                    checkSinger=true;
                    break;
                }
            }
            if(!checkSinger){
                System.out.println("Không có ca sĩ này. Nhập mới ca sĩ trước !");
                for (int i = 0; i < indexSinger; i++) {
                singers[i].inputData();
                }
            }
            break;
        }

        System.out.println("Nhập người sáng tác: ");
        while (true) {
            this.songWriter = scanner.nextLine();
            if (this.songWriter.isEmpty()) {
                System.out.println("Mô tả không được để trống. Mời nhập lại: ");
            } else {
                break;
            }
        }


        System.out.println("Nhập trạng thái bài hát: ");
        this.songStatus = Boolean.parseBoolean(scanner.nextLine());
    }


    public void displayData() {
        System.out.println("Song Info: {" +
                "songId='" + songId + '\'' +
                ", songName='" + songName + '\'' +
                ", description='" + description + '\'' +
                ", singer='" + singer.getSingerName() + '\'' +
                ", genre='" + singer.getGenre() + '\'' +
                ", songWriter='" + songWriter + '\'' +
                ", createdDate=" + createdDate +
                ", songStatus=" + songStatus +
                '}');
    }
}
