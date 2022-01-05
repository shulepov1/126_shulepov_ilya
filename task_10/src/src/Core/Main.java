package Core;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContractManager contractsList = ContractManager.create();
        call(contractsList);
    }

    public static void call(ContractManager contractsList){
        Scanner sc = new Scanner(System.in);
        callMenu();
        try {
            int n = sc.nextInt();
            if (n == 1) {
                System.out.println("Введите номер договора и дату (дата состоит из 8 цифр подряд ГГГГММДД)");
                try {
                    contractsList.addContract(sc.nextInt(), sc.nextInt());
                } catch (Exception e) {
                    System.out.println("Формат введённых данных неверен");
                }
                System.out.println();
                call(contractsList);
            } else if (n == 2) {
                try {
                    System.out.println("Введите сумму платежа, номер документа, тип документа(BankOrder или PaymentOrder, номер договора" +
                            " и дату");
                    contractsList.registerDocument(sc.nextInt(), sc.nextInt(), DocType.valueOf(sc.next()), sc.nextInt(), sc.nextInt());
                } catch (Exception e) {
                    System.out.println("Формат введённых данных неверен");
                }
                System.out.println();
                call(contractsList);
            } else if (n == 3) {
                try {
                    System.out.println("Введите номер договора");
                    System.out.println(contractsList.getContractsList().get(sc.nextInt()).getListOfPayments());
                } catch (Exception e) {
                    System.out.println("Формат введённых данных неверен");
                }
                System.out.println();
                call(contractsList);
            } else if (n == 4) {
                try {
                    System.out.println("Введите номер договора");
                    System.out.println(contractsList.getContractsList().get(sc.nextInt()).getSumOfPayments());
                } catch (Exception e) {
                    System.out.println("Формат введённых данных неверен");
                }
                System.out.println();
                call(contractsList);
            } else if (n == 5) {
                try {
                    System.out.println("Введите номер договора и номер платежа");
                    contractsList.getContractsList().get(sc.nextInt()).deletePayment(sc.nextInt());
                } catch (Exception e) {
                    System.out.println("Формат введённых данных неверен");
                }
                System.out.println();
                call(contractsList);
            } else if (n == 6) {
                try {
                    System.out.println(contractsList.getListOfContractsWithPayments());
                } catch (Exception e) {
                    System.out.println("Формат введённых данных неверен");
                }
                System.out.println();
                call(contractsList);
            } else if (n == 7) {
                try {
                    System.out.println(contractsList.getListOfAllPayments());
                } catch (Exception e) {
                    System.out.println(contractsList.getListOfAllPayments());
                }
                System.out.println();
                call(contractsList);
            } else {
                System.out.println("Введенные данные неверны");
                System.out.println();
                call(contractsList);
            }
        }
        catch (Exception e){
            System.out.println("Формат введённых данных неверен");
            System.out.println();
            call(contractsList);
        }
    }
    public static void callMenu(){
        System.out.println("Система учёта платежей по договорам");
        System.out.println("1. Заключить договор");
        System.out.println("2. Добавить документ");
        System.out.println("3. Получить список всех платежей по номеру договора");
        System.out.println("4. Получить сумму всех осуществлённых платежей по договору");
        System.out.println("5. Удалить платёж");
        System.out.println("6. Получить список всех договоров с их суммармными платежами");
        System.out.println("7. Получить список всех платежей");
    }
}
