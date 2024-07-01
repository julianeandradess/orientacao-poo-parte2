package academy.dev.Test.Colecoes.Test;

import academy.dev.Test.Colecoes.Dominio.Consumidor;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapTest01 {
    public static void main(String[] args) {
        //NavigableMap é a mesma coisa só que pra chave
        //NavigableSet, obrigatoriamente precisa que aquela interface/classe precisa ter a complementação de Comparator ou Comparable
        //navigableMap, ordena pela chave
        Consumidor consumidor1 = new Consumidor("Julia");
        Consumidor consumidor2 = new Consumidor("Benicio");

        //usando <String, Consumidor> não causa excessão, no maximo deixa feio.
        //porem usando <Consumidor, Consumidor> sem passar no TreeMap oo comparator, dará uma excessão.
        NavigableMap<String, String> map = new TreeMap<>();
        map.put("A", "Letra A");
        map.put("B", "Letra B");
        map.put("C", "Letra C");
        map.put("D", "Letra D");
        map.put("E", "Letra E");

        for (Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey()+ " : "+ entry.getValue());
        }

        System.out.println(map.headMap("C")); //traz tudo que vem antes ou for de valor menor
        //System.out.println(map.headMap("C").remove("A")); remove a letra
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.headMap("C", true));//se quiser incluir a chave que está passando, ABC..
        System.out.println(map.ceilingKey("C")); //será o proprio c
        System.out.println(map.higherKey("C"));
        System.out.println(map.floorKey("C"));
        System.out.println(map.lowerKey("C"));

    }
}
