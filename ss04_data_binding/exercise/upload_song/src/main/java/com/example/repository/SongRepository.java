package com.example.repository;

import com.example.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SongRepository implements ISongRepository{
    private static List<Song> songList = new ArrayList<>();
    static {
        songList.add(new Song(1,"Cánh hông phai","Hoàng Yến Chibi","ballad",
                "C:\\Users\\Khanh Nhat\\Music\\Canh-Hong-Phai-Ke-Hoach-Doi-Chong-OST-Hoang-Yen-Chibi"));
        songList.add(new Song(2,"Chiều hôm ấy","Jaykii","ballad","C:\\Users\\Khanh Nhat\\Music\\Chieu-Hom-Ay-JayKii"));
        songList.add(new Song(3,"Đừng xin lỗi nữa","Erik, Min","ballad",
                "C:\\Users\\Khanh Nhat\\Music\\Dung-Xin-Loi-Nua-Lala-Hay-De-Em-Yeu-Anh-OST-ERIK-MIN"));
    }


    @Override
    public List<Song> showList() {
        return songList;
    }
}
