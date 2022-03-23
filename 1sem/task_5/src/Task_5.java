import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Task_5 implements Task_5_base {
    @Override
    public ArrayList<Integer> subtask_1_ArrayList(ArrayList<Integer> data, int k, int n) {
        // Выбрать из данного списка элементы, кратные k, но не кратные n
        // и сформировать из них новый список.
        // Вернуть новый список в качестве результата
        data.removeIf(a -> (a % n == 0));
        data.removeIf(a -> (a % k != 0));
        ArrayList<Integer> data2 = new ArrayList<>(data);
        return data2;
    }

    @Override
    public ArrayList<Integer> subtask_2_ArrayList(int size) {
        // сгенерировать и вернуть список размера size,
        // содержащий первые size элементов последовательности, описанной в
        // задаче subtask_2_for задания task_3
        ArrayList<Integer> arr = new ArrayList<>(size);
         for (int i = 1, j = 0; j < size; i++) {
            for (int k = 0; j < size && k < i; j++, k++) {
                arr.add(i);
            }
        }
        return arr;
    }

    @Override
    public HashSet<Integer> subtask_3_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите пересечение множеств s1 и s2
        s1.retainAll(s2);
        return s1;

    }

    @Override
    public HashSet<Integer> subtask_4_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите объединение множеств s1 и s2
        s1.addAll(s2);
        return s1;
    }

    @Override
    public HashSet<Integer> subtask_5_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите дополнение множества s1 до множества s2
        s2.removeAll(s1);
        return s2;
    }

    @Override
    public HashSet<Integer> subtask_6_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // постройте множество, содержащее элементы, содержащиеся либо только в s1,
        // либо только в s2, но не в обоих множествах одновременно
        HashSet<Integer> retained = new HashSet<>(s1);
        retained.retainAll(s2);

        s1.removeAll(retained);
        s2.removeAll(retained);

        HashSet<Integer> s1new = new HashSet<>(s1);
        HashSet<Integer> s2new = new HashSet<>(s2);

        s1new.addAll(s2new);

        return s1new;
    }


    @Override
    public HashMap<String, Double> subtask_7_HashMap(ArrayList<String> data) {
        // Дан список строк. Построить словарь, содержащий частоты слов
        // для данного списка в процентах
        HashMap<String, Double> map = new HashMap<>();
        for (String i: data) {
            map.put(i, (double) Collections.frequency(data, i) * 100 / data.size());
        }
        return map;
}

    @Override
    public HashMap<String, Double> subtask_8_HashMap(ArrayList<Double> data) {
        // Дан список чисел. Сформировать словарь, содержащий среднее,
        // максимальное и минимальное значения из данного списка. Ключи
        // словаря "mean", "max", "min" соответственно
        HashMap<String, Double> map = new HashMap<>();
        Double max = Collections.max(data);
        Double min = Collections.min(data);
        if (data.isEmpty()) {
            return null;
        }
        double sum = 0;
        for (Double dat : data) {
            sum = sum + dat;
        }
        Double mean = sum / data.size();

        map.put("max", max);
        map.put("min", min);
        map.put("mean", mean);

        return map;
    }
}
