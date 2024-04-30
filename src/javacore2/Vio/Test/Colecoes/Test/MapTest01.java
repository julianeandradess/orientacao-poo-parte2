package javacore2.Vio.Test.Colecoes.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest01 {
    public static void main(String[] args) {
        //tecnicamente map não é uma collections
        //Map < K, V > k representa a chave, v valor
        //se tem hash no nome, sabemos que irá ordenar as chaves baseados no hash. Não usa valores duplicados
        //se quisermos manter a ordem de inserção:
        //Map<String , String> map = new LinkedHashMap<>();
        Map<String , String> map = new HashMap<>();
        map.put("tekclado", "teclado"); //adicionar valor
        map.put("mouze", "mouse");
        map.put("vc","você");
        map.put("vc", "você3"); //irá substituir o valor dado acima, pelo você3
        map.putIfAbsent("vc6", "você2"); //só vai adicionar caso não exista, de acordo com a key
        map.put("vc4", "você4");
        System.out.println(map);

        System.out.println("---- via chave ----");
        //para navegar pelo map temos 2 opções, usando via chave ou utilizando via valor.
        //a chave (K key), são elementos unicos por isso são um set
        //for (String key : map.keySet())  //ou for(String values : map.values), pode ter valores duplicados, chaves diferentes exatamente com o mesmo valor
        for (String key : map.keySet()){
            System.out.println(key + " : " + map.get(key)); //mostrará todas as chaves(key), map.get(key) valor
        }
        System.out.println("---- via valor ----");
        for (String valor : map.values()){
            System.out.println(valor);
        }

        System.out.println("---- chave e valor juntos ----");
        for (Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey()+ " : "+ entry.getValue());
        }
    }
}
