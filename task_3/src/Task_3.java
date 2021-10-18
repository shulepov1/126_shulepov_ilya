public class Task_3 implements Task_3_base {
    @Override
    public int subtask_1_for(int n1, int n2, int a, int b) {
        // подсчитать, сколько чисел, кратных a, но не кратных b,
        // находится между числами n1 и n2 включительно
        int min, max, count = 0;
        if (n1 < n2) {
            min = n1;
            max = n2;
        }
        else {
            min = n2;
            max = n1;
        }

        for (int n = min; n <= max; n++) {
            if (n % a == 0 && n % b != 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int subtask_2_for(int num) {
        // Последовательность чисел строится следующим образом:
        // сначала идет одна единица,
        // потом две двойки,
        // потом три тройки,
        // ...
        // потом n раз число n
        // ...
        // Найти, какое число будет находиться в этой последовательности
        // на позиции num
        int a = num;
        int r = 1;
        int i;
        if (a == 1) return 1;
        for (i = 2; i <= num; i++) {
            for (int j = 0; j <= i; j++) {
                r += 1;
                if (r == num) return i;
            }
        }

        return num;
    }

    @Override
    public int subtask_3_for(int num, int d, int cnt) {
        // Дана последовательность
        // a(0) = num
        // a(n) = a(n - 1) * d + 1
        // Найти сумму первых cnt элементов последовательности
        int sum = 0;
        int a = num;
        for (int count = 0; count < cnt; count++) {
        sum = sum + a;
        a = a*d + 1;
        }
        return sum;

    }

    @Override
    public int subtask_4_for(int n) {
        // Вычислить сумму
        // S(n) = 1 + 1 * 2 + 1 * 2 * 3 + ... + n!
        // для заданного n
        // (n! - это n-факториал. Кто не знает - гуглите)
        int fact = 1;
        int sum = 0;
        int i, j;
        for (i = 1; i <= n; i++)
        {
            for (j = 1; j <= i; j++){
                fact = fact * j;
            }
            sum += fact;
            fact = 1;
        }
        return sum;
    }
}

