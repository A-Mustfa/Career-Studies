import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numberss = Arrays.asList(5, 2, 9, 4, 7, 6, 1, 8);

        // even numbers and sort ascending
        List<Integer> result = numberss.stream().filter(n -> n % 2 == 0).sorted().collect(Collectors.toList());
        System.out.println(result);


        // convert string to its length
        List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry");
        List<Integer> result2 = words.stream()
                                     .map(str -> str.length())
                                     .collect(Collectors.toList());
        System.out.println(result2);

        //start with A
        List<String> names = Arrays.asList("Ahmed", "Sara", "Amira", "Ali", "Mona", "Asmaa");
        List<String> result3 = names.stream()
                .filter(str -> str.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(result3);

        // *2 -> sum
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> result4 = numbers.stream()
                .map(n -> n*2).reduce((n,n1) -> {
                    return n+n1;
                });
        System.out.println(result4.get());


        //each number
        List<String> sentences = Arrays.asList("Hello World", "Java Streams");
        List<String> result5 =sentences.stream()
                .flatMap(x-> Arrays.stream(x.split(""))).collect(Collectors.toList());
        System.out.println(result5);

        String[] arr = sentences.get(0).split("");
        for(String str : arr){
            System.out.print(str+",");
        }


    }
}