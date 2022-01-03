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
        int n = sc.nextInt();
        if (n == 1){
            System.out.println("Введите номер договора и дату");
            contractsList.addContract(sc.nextInt(), sc.nextInt());
            call(contractsList);
        }
        else if (n == 2){
            System.out.println("Введите сумму платежа, номер документа, тип документа(BankOrder или PaymentOrder, номер договора" +
                    " и дату");
            contractsList.registerDocument(sc.nextInt(), sc.nextInt(), DocType.valueOf(sc.next()), sc.nextInt(), sc.nextInt());
            call(contractsList);
        }
        else if (n == 3){
            System.out.println("Введите номер договора");
            System.out.println(contractsList.getContractsList().get(sc.nextInt()).getListOfPayments());
            System.out.println();
            call(contractsList);
        }
        else if (n == 4){
            System.out.println("Введите номер договора");
            System.out.println(contractsList.getContractsList().get(sc.nextInt()).getSumOfPayments());
            System.out.println();
            call(contractsList);
        }
        else if (n == 5){
            System.out.println("Введите номер договора и номер платежа");
            contractsList.getContractsList().get(sc.nextInt()).deletePayment(sc.nextInt());
            System.out.println("Платёж был успешно удалён");
            System.out.println();
            call(contractsList);
        }
        else if (n == 6){
            System.out.println(contractsList.getListOfContractsWithPayments());
            System.out.println();
            call(contractsList);
        }
        else if (n == 7){
            System.out.println(contractsList.getListOfAllPayments());
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
