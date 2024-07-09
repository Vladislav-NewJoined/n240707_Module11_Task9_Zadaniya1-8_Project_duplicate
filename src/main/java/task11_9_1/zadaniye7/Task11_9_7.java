package task11_9_1.zadaniye7;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import task11_9_1.zadaniye7.data_sources.ReceiverApiDataSource;
import task11_9_1.zadaniye7.domain.ReceiverService;

// с этого проекта, Draft_Module11_Task9_Zadaniya1-8_Project_part8, всё работает, осталось добавить только то,
// что в видео 08 (т.е. 2-ю часть)

public class Task11_9_7 {

    public static void main(String[] args) {
        System.out.println("""
                Задание:\s
                Модуль 11. Протокол “HTTP”. Задание №9, Проект:\s
                Цель задания: совершенствование  навыков работы с протоколом HTTP\s
                    Задание:
                    1. В ранее созданном проекте, в папке main  создайте New Package c названием models, далее
                       класс Receiver
                    2. В созданный класс Receiver вставляем  соответствующий код класса  из папки target из ранее
                       созданного проекта
                    3. В ранее созданном Package под названием models создаем класс с названием InRadiusDto, далее
                       копируем в него соответствующий код класса из папки target проекта созданного на предыдущих уроках
                    4. В папке main созданного ранее проекта создайте папку New Package с названием data_sources и
                       New Package с названием domain
                    5. В папке data_sources создайте класс ReceiverApiDataSource в него скопируйте содержимое
                       интерфейса ReceiversService из класса Main который содержится в папке target
                    6. В папке  domain создайте класс ReceiveService в нем сделайте
                       import data_sources.ReceiverApiDataSource и в созданном публичном классе реализуйте
                       получение экземпляра  receiverApiDataSource далее реализуйте метод fetch и перенесите
                       в него содержимое из класса  Main в находящегося в папке models, подставьте в
                       соответствующую строчку кода  receiverApiDataSource в исключении try реализуйте
                       возврат res.body, а в исключении catch возврат null
                    7. В классе Main находящегося в папке models создайте сервис и передайте в него ранее созданный
                       receiverApiDataSource
                    8. Реализуйте циклическую загрузку данных при вводе значения latitude и longitude
                \s""");

        System.out.println("""
                Решение по заданию 7, В классе Main находящегося в папке models создайте сервис и передайте в него ранее созданный
                       receiverApiDataSource:
                \s""");

        System.out.println("""
                Примечание: адрес веб-страницы 'https://github.com/google/gson' в настоящее время является
                недействительным, поэтому вместо него использован веб-сервис для тестирования и создания фейковых
                координат в ответ на запросы: 'https://jsonplaceholder.typicode.com' и, соответственно, названия папок
                были изменены на актуальные для этого ресурса.\s
                \s""");

        System.out.println("""
                Примеры получения ответов на запросы с использованием протокола 'HTTP':\s
                \s""");



//        Gson gson = new Gson();
//        PostModel post = new PostModel();
//        String json = gson.toJson(post);
//        System.out.println(json);
//        System.out.println(gson.fromJson(json,PostModel.class));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
//
        ReceiverApiDataSource receiverApiDataSource = retrofit.create(ReceiverApiDataSource.class);
        ReceiverService service = new ReceiverService(receiverApiDataSource);
        System.out.println(service.fetch());
    }
}
