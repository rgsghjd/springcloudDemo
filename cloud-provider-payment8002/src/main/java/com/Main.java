package com;

public class Main {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(50));
    }

    static int nthUglyNumber(int n) {
        int num = 0;
        int sum = 0;
        while (true) {
            num++;
            if (isUgly(num)) {
                sum++;
            }
            if (sum == n) {
                return num;
            }
        }

    }

    static boolean isUgly(int num) {
        if (num == 3 || num == 2 || num == 5 || num == 1) return true;
        boolean flag = false;
        if (num % 2 == 0) return true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        if (flag == false) {
            return false;
        }
        for (int i = 5; i < num; i += 2) {
            if (num % i == 0 ) {
                return false;
            }
        }
        return true;
    }
}
