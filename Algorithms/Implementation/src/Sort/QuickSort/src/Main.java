import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static List<Integer> quickSort(List<Integer> arr){
        if(arr.size()<2){
            return arr;
        }
        Integer pivot=arr.get(0);
        List<Integer> less = arr.stream().skip(1).filter(el -> el <= pivot)
                .collect(Collectors.toList());
        List<Integer> greater = arr.stream().skip(1).filter(el -> el > pivot)
                .collect(Collectors.toList());
        return Stream.of(
                        quickSort(less).stream(),
                        Stream.of(pivot),
                        quickSort(greater).stream())
                .flatMap(Function.identity()).collect(Collectors.toList());

    }
    public static void main(String[] args) {
        List<Integer> arr=Arrays.asList(5,9,6,8,7);

        System.out.println(quickSort(arr));
    }
}