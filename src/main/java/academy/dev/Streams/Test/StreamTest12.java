package academy.dev.Streams.Test;

import academy.dev.Streams.Dominio.Category;
import academy.dev.Streams.Dominio.LightNovel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest12 {
    private static List<LightNovel> novelList7 = new ArrayList<>(List.of(
            new LightNovel("Xitake", 8.99, Category.FANTASY),
            new LightNovel("Cogumelo",3.99, Category.ROMANCE),
            new LightNovel("Chockito", 5.99, Category.DRAMA),
            new LightNovel("Kani", 2.99, Category.FANTASY),
            new LightNovel("Tare",5.99, Category.ROMANCE),
            new LightNovel("Chimegi", 1.99, Category.DRAMA),
            new LightNovel("Chimegi", 1.99, Category.FANTASY),
            new LightNovel("Xolo",4.00, Category.ROMANCE),
            new LightNovel("Rocco",6.99, Category.DRAMA)
    ));

    public static void main(String[] args) {
        //digamos que queremos agrupar por categoria:
        Map<Category, List<LightNovel>> categoryListMap = new HashMap<>();
        List<LightNovel> fantasy = new ArrayList<>();
        List<LightNovel> drama = new ArrayList<>();
        List<LightNovel> romance = new ArrayList<>();
        for (LightNovel lightNovel : novelList7) {
            switch (lightNovel.getCategory()){
                case DRAMA: drama.add(lightNovel); break;
                case FANTASY: fantasy.add(lightNovel); break;
                case ROMANCE: romance.add(lightNovel); break;
            }
        }
        categoryListMap.put(Category.DRAMA, drama);
        categoryListMap.put(Category.FANTASY, fantasy);
        categoryListMap.put(Category.ROMANCE, romance);
        System.out.println(categoryListMap);
        System.out.println("--");

        //usando stream, o que torna seu codigo muito mais fluido, é exatamente a mesma coisa
        Map<Category, List<LightNovel>> categoryListMap1 = novelList7.stream().collect(Collectors.groupingBy(LightNovel::getCategory));
        System.out.println(categoryListMap1);


    }
}
