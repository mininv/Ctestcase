import java.util.*;
import java.util.stream.Collectors;

public class Main {
    /**
     * 1.
     * имеется массив чисел, получить список вида {число, количество вхождений числа в массив}, список
     * должен быть отсортирован по количеству вхождений, внутри по возрастания числа. Использовать
     * можно любой алгоритмический язык.
     * @param arr
     */
    public static Set<?> sortAndOrderArray(Integer[] arr){
        Map<Integer, Integer> map = new HashMap();

        for (Integer integer: arr){
            if(map.keySet().contains(integer)){
                map.computeIfPresent(integer, (a,b) -> b+1);
            }else {
                map.put(integer,1);
            }
        }
        TreeSet<NumberCounter> set = new TreeSet<>();
        map.keySet().stream().forEach(key ->set.add(new NumberCounter(key, map.get(key))));
        Set<NumberCounter> collect = set.stream().collect(Collectors.toSet());
        return collect;
    }

    /**
     * 2.
     * написать алгоритм проверки корректности регулярного выражения, которое включает [,],(,)
     * т.е., например ([][[]()]) - правильно, ([][]()]) – неправильно
     * @param str
     * @return
     */
    public static boolean isLoopMatch(String str) {
        Map<Character, Character> openClosePair = new HashMap();
        openClosePair.put(')', '(');
        openClosePair.put('}', '{');
        openClosePair.put(']', '[');
        Stack<Character> stack = new Stack();
        for(char ch : str.toCharArray()) {
            if(openClosePair.containsKey(ch)) {
                if(stack.pop() != openClosePair.get(ch)) {
                    return false;
                }
            } else if(openClosePair.values().contains(ch)) {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
    /**
     * 3.
     * написать алгоритм, как в целом числе самый правый ноль превратить в единицу не используя
     * циклы и рекурсию.
     * @param value
     */
    public static int changeLastZeroBit(int value){
        if(value%2 ==0 ) {
            value ^= 1;
        }
        return value;
    }

    /**
     *
     * @param value
     * @param size
     */
    public static void printBinary(int value,int size){
        System.out.print(value +" - ");
        for(int i = size - 1; i >= 0; i--){
            long mask = 1L << i;
            long l= mask & value;
            long result = l >> i;
            System.out.print(result);
        }
        System.out.println();
    }


}
class NumberCounter implements Comparable<NumberCounter> {
    private int number=0;
    private int  iteration = 0;

    public NumberCounter() {
    }

    public NumberCounter(int number) {
        this.number = number;
    }

    public NumberCounter(int number, int iteration) {
        this.number = number;
        this.iteration = iteration;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getIteration() {
        return iteration;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    @Override
    public int compareTo(NumberCounter o) {
        return this.number - o.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberCounter that = (NumberCounter) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "NumberCounter{" +
                "number=" + number +
                ", iteration=" + iteration +
                '}';
    }
}