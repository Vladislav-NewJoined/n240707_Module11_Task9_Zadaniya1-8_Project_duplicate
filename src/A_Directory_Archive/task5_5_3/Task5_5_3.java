package task5_5_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

abstract class SongLyrics {
    protected abstract String getLyrics(String song);
}

public class Task5_5_3 {
    public static void main(String[] args) throws IOException {
        System.out.println("""
                Задание:\s
                Модуль 5. Интерфейсы, абстрактные классы, статические методы. Задание №5:\s
                    3. Создайте наследника - DirectorySongLyrics, который ищет в папке файл с
                       названием песни, и если находит - возвращает текст песни\s

                Решение:\s""");
        System.out.println("Ищем тексты песен в файлах в директории src/task5_5_3/DirectorySongLyrics.\n");

        DirectorySongLyrics directorySongLyrics = new DirectorySongLyrics();
        String song = "Venus";

        String lyrics = directorySongLyrics.getLyrics(song);
        System.out.println("Выводим текст песни '" + song + "':\n" + lyrics);
    }
}

class DirectorySongLyrics extends SongLyrics {
    private static final String DIRECTORY_PATH = "src/task5_5_3/DirectorySongLyrics";

    @Override
    protected String getLyrics(String song) {
        StringBuilder lyrics = new StringBuilder();
        boolean foundSong = false;

        File directory = new File(DIRECTORY_PATH);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().equalsIgnoreCase(song + ".txt")) {
                        foundSong = true;
                        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                            String line;
                            boolean isFirstLine = true;
                            while ((line = br.readLine()) != null) {
                                if (!isFirstLine) {
                                    lyrics.append(line).append("\n");
                                }
                                isFirstLine = false;
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            }
        }

        if (foundSong) {
            return lyrics.toString();
        } else {
            return "Песня не найдена";
        }
    }
}





//// ПРИМЕР 3
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//
//abstract class SongLyrics {
//    protected abstract String getLyrics(String song);
//}
//
//public class Task5_5_3 {
//    public static void main(String[] args) throws IOException {
//        System.out.println("""
//                Задание:\s
//                Модуль 5. Интерфейсы, абстрактные классы, статические методы. Задание №5:\s
//                    3. Создайте наследника - DirectorySongLyrics, который ищет в папке файл с
//                       названием песни, и если находит - возвращает текст песни\s
//
//                Решение:\s""");
//        System.out.println("В файл src/task5_5_2/SongLyrics.txt в тестовом режиме записаны" +
//                " названия и тексты трёх песен. Ищем в файле песни по названию.\n");
//        FileSongLyrics fileSongLyrics = new FileSongLyrics();
//        String song = "Life is life";
//
//        String lyrics = fileSongLyrics.getLyrics(song);
//        System.out.println("Выводим текст песни '" + song + "':\n" + lyrics);
//    }
//}
//
//class FileSongLyrics extends SongLyrics {
//    @Override
//    protected String getLyrics(String song) {
//        StringBuilder lyrics = new StringBuilder();
//        boolean foundSong = false;
//
//        try (BufferedReader br = new BufferedReader(new FileReader("src/task5_5_3/SongLyrics3.txt"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                if (line.trim().equals(song)) {
//                    foundSong = true;
//                    continue;
//                }
//                if (foundSong) {
//                    if (line.trim().isEmpty()) {
//                        break;
//                    }
//                    lyrics.append(line);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        if (foundSong) {
//            return lyrics.toString();
//        } else {
//            return "Песня не найдена";
//        }
//    }
//}
//// КОНЕЦ ПРИМЕРА 3




//// ПРИМЕР 2
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//abstract class SongLyrics {
//    protected abstract String getLyrics(String song);
//}
//
//public class Task5_5_2 {
//    public static void main(String[] args) throws IOException {
//        System.out.println("""
//                Задание:\s
//                Модуль 5. Интерфейсы, абстрактные классы, статические методы. Задание №5:\s
//                    2. Создайте файл в формате: Название песни: текст песни, и так много песен
//                       (можете разделять разные песни пустыми строками, или другим способом)
//                       Создайте наследника - FileSongLyrics, который ищет в файле по названию
//                        песни, и если находит, возвращает текст песни.\s
//
//                Решение:\s""");
//
//        FileSongLyrics lyricsDownloader = new FileSongLyrics();
//        String song = "Lose yourself";
//
//        String lyrics = lyricsDownloader.getLyrics(song);
//        System.out.println("Выводим текст песни '" + song + "', исполнителя 'Eminem':\n" + lyrics);
//    }
//}
//
//class FileSongLyrics extends SongLyrics {
//
//    @Override
//    protected String getLyrics(String song) {
//        StringBuilder response = new StringBuilder();
//
//        try {
//            HttpURLConnection connection = (HttpURLConnection) new URL(getURL("Eminem", song)).openConnection();
//            connection.setRequestMethod("GET");
//
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    response.append(line);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String lyrics = response.toString().split("\"lyrics\":\"")[1].split("\"")[0];
//        return lyrics;
//    }
//
//    private String getURL(String artist, String song) {
//        return "https://api.lyrics.ovh/v1/" + artist + "/" + song.replace(" ", "%20");
//    }
//}
//// КОНЕЦ ПРИМЕРА 2