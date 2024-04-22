package org.example;

import java.util.List;
import java.util.Optional;

public class Trebuchet {

    public static void main(String[] args) {
        final List<String> list = FileUtils.readFile("/day1.txt");
        final int solve = solve(list);
        System.out.println(solve);
    }

    static int solve2(String in) {
        final String num = in.replaceAll("\\D", "");
        final int lastChar = num.length() - 1;
        return Integer.parseInt(num, 0, 1, 10)
            + Integer.parseInt(num, lastChar, lastChar + 1, 10);
    }

    static int solve(final List<String> in) {
        final Optional<Integer> reduce = in.stream()
            .map(Trebuchet::findDig)
            .reduce(Integer::sum);

        return reduce.orElse(0);
    }

    static int findDig(String str) {
        final char[] charArray = str.toCharArray();

        int x = -1, y = -1;
        for (int i = 0, j = charArray.length - 1; i <= j;) {

            if (x == -1) {
                final char head = charArray[i];
                if (Character.isDigit(head)) {
                    x = head - '0';
                } else {
                    i++;
                }
            }
            if (y == -1) {
                final char tail = charArray[j];
                if (Character.isDigit(tail)) {
                    y = tail - '0';
                } else {
                    j--;
                }
            }

            if (x != -1 && y != -1) { break;}
        }
        System.out.println(str + " -> produces -> " + (x+y));


        return Integer.parseInt(x + "" + y) ;
    }
}
