package task;

public class Task_9 {
    public Class<?> subtask_1_GenericClassProgramming() {
        /*
        *   Создать в пакете task обобщенный класс согласно описанию:
        * -------------------------------------------------------------------------------------------
        *   Название: DoubleLinkedListItem
        *   Смысл: элемент двусвязного списка
        *   Конструктор: принимающий аргумент данных generic типа
        *   Методы:
        *       getNext - возвращает ссылку на следующий элемент
        *       getPrev - возвращает ссылку на предыдущий элемент
        *       getData - возвращает ссылку на объект данных
        *       setNext - устанавливает ссылку на следующий элемент
        *       setPrev - устанавливает ссылку на предыдущий элемент
        *       setData - устанавливает ссылку на элемент данных
        *   Дополнение:
        *       - generic параметр должэен быть сравниваемым
        * ------------------------------------------------------------------------------------------
        */

        try {
            return Class.forName("task.DoubleLinkedListItem");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
    public Class<?> subtask_2_GenericClassProgramming() {
        /*
         *   Создать в пакете task обобщенный класс согласно описанию:
         * -------------------------------------------------------------------------------------------
         *   Название: DoubleLinkedList
         *   Смысл: двусвязный список
         *   Конструктор: не принимает аргументов
         *   Методы:
         *       findFirstItem    - возвращает первый элемент с указанным значением
         *       findLastItem     - возвращает последний элемент с указанным значением
         *       insertAfter      - размещает элемент с указанным ЗНАЧЕНИЕМ после заданного. 
		 *  						Первым аргументом идет элемент списка, вторым данные.
         *       insertBefore     - размещает элемент с указанным ЗНАЧЕНИЕМ перед заданным
		 *  						Первым аргументом идет элемент списка, вторым данные.
         *       remove           - удаляет переданный элемент из списка
         *       getSize          - возвращает размер списка
         *       getFirst         - возвращает первый элемент списка
         *       getLast          - возвращает последний элемент списка
         *   Дополнение:
         *       - generic параметр должен быть сравниваемым
         * ------------------------------------------------------------------------------------------
         */

        try {
            return Class.forName("task.DoubleLinkedList");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
    public Class<?> subtask_3_GenericClassProgramming() {
        /*
         *   Создать в пакете task класс согласно описанию:
         * -------------------------------------------------------------------------------------------
         *   Название: DoubleLinkedListSorter
         *   Смысл: сортировщик двусвязного списка
         *   Конструктор: не принимает аргументов
         *   Статические методы:
         *      sort - generic метод, принимающий список и сортирующий его
         *   Дополнение:
         *       - generic параметр должен быть сравниваемым
         * ------------------------------------------------------------------------------------------
         */

        try {
            return Class.forName("task.DoubleLinkedListSorter");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
