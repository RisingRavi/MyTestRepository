package com.javatpoint.server.main.helloworld;

import java.util.*;
import java.util.stream.Collectors;

public class HelloWorldBean {
    public String message;

    //constructor of HelloWorldBean
    public HelloWorldBean(String message) {
        this.message = message;
    }

    //generating getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
//generate toString
    public String toString() {
        return String.format("HelloWorldBean [message=%s]", message);
    }

    public static void main(String[] args) {

        String str = "10 ravi 43 asdf ddf 2";
        int sum = Arrays.stream(str.split(" ")).filter(s -> s.matches("\\d+"))
                .mapToInt(Integer::valueOf).sum();
        System.out.println("Sum is : " + sum);

        List<Integer> intList = Arrays.asList(1, 4, 77, 33, 99, 22, 9, 7, 17, 1, 4, 33);
        int secondLargest = intList.stream().sorted(Comparator.reverseOrder()).skip(2).findFirst().get();
        System.out.println("ThirdLargest :" + secondLargest);

        List<Integer> primeList = intList.stream().filter(HelloWorldBean::isPrime).collect(Collectors.toList());
        System.out.println("prime numbers :" + primeList);
        /**      */
        int[] arrList = {1, 4, 77, 33, 99, 22, 9, 7, 17, 9, 4};
        int first = arrList[0];
        int second = arrList[0];
        for (int i = 0; i < arrList.length; i++) {
            if (first < arrList[i]) {
                second = first;
                first = arrList[i];
            } else {
                if (arrList[i] > second && first != arrList[i]) {
                    second = arrList[i];
                }
            }
        }
        System.out.println("second largest number without sorting :" + second);
        String str1 = "rohit is bestman who can ball also rohit is ";
        List<Integer> duplicateIntValues = intList.stream().filter(i -> Collections.frequency(intList, i) > 1).distinct()
                .collect(Collectors.toList());
        System.out.println("duplicateIntValues : " + duplicateIntValues);
        char[] charArr = str1.toCharArray();
        List<String> strList = Arrays.asList("ravi", "ravi", "raj", "rohan", "rahul", "is", "is", "is");
        Map<String, Long> wordCount = strList.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println("wordCount : " + wordCount);
        LinkedHashMap<String, Long> sortWordsByValues = wordCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("sortWordsByValues : " + sortWordsByValues);

    }

    private static boolean isPrime(Integer number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}