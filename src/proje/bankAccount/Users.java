package proje.bankAccount;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Users {
    String name;
    String password;
    String dateOfBirth;
    String marriageStatus;
    String relativeName;
    String relativeAge;
    String isTransferedSuceesfully;

    int accountNumber1;
    int amountAccount1;
    int accountNumber2;
    int amountAccount2;

    static int randomNumberCreader() {
        return (int) (Math.random() * (99999999 - 10000000 + 1) + 10000000);
    }

    public Users(String name, String password, String dateOfBirth, String marriageStatus, int amountAccount1, int amountAccount2) {
        this.name = name;
        this.password = password;
        this.dateOfBirth = checkAge(dateOfBirth);
        this.marriageStatus = CheckMariageStatus(marriageStatus);
        this.amountAccount1 = amountAccount1;
        this.amountAccount2 = amountAccount2;
        this.accountNumber1 = randomNumberCreader();
        this.accountNumber2 = randomNumberCreader();
    }

    //    public static String checkAge(String dateofBirth){
//        LocalDate bugun= LocalDate.now();
//        LocalDate verilen=LocalDate.parse(dateofBirth);
//        if (bugun.getYear()-verilen.getYear()>18){
//            return "You can get a credit card";
//        }
//        else {
//            return "You should be at least 18 years old to get a credit card.";
//        }
//    }
    public static String checkAge(String age) {

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
        String text = date.format(formatters);
        LocalDate today = LocalDate.parse(text, formatters);

        LocalDate myAge = LocalDate.parse(age, formatters);

        int num = today.compareTo(LocalDate.parse(age, formatters));

        String result = "";

        if (num > 18) {

            result = "You can get a credit card";

        }
        else if (num < 18) {

            result = "You should be at least 18 years old to get a credit card.";

        }
        else if (num == 18) {

            if (today.getMonthValue() > myAge.getMonthValue()) {

                result = "You can get a credit card";

            }
            else if (today.getMonthValue() < myAge.getMonthValue()) {

                result = "You should be at least 18 years old to get a credit card.";

            }
            else if (today.getMonthValue() == myAge.getMonthValue()) {

                if (today.getDayOfMonth() > myAge.getDayOfMonth()) {

                    result = "You can get a credit card";

                }
                else {

                    result = "You should be at least 18 years old to get a credit card.";
                }
            }
        }

        return result;

    }

    String CheckMariageStatus(String marriageStatus) {
        Scanner read = new Scanner(System.in);
        String r = "";
        if (marriageStatus.equals("married")) {
            System.out.println("Do you want to add your relative?");
            String evli = read.nextLine();
            if (evli.equals("yes")) {
                System.out.println("What is your relative name?");
                String name = read.nextLine();
                System.out.println("Date of birth relative?");
                String dateofbirth = read.nextLine();
                AddRelative d = new AddRelative(name, dateofbirth);
                this.relativeName = name;
                this.relativeAge = dateofbirth;
                if (relativeAge.equals("0")) {
                    relativeName = "Relative should be more then 18 years old";
                    relativeAge = "Relative should be more then 18 years old";
                    r = "Relative should be more then 18 years old";
                }
                else {
                    r = "Transaction done successfully";
                }
            }
        }
        return r;
    }

    public void transfer(Users u1, Users u2) {
        Scanner read = new Scanner(System.in);
        Scanner readInt = new Scanner(System.in);
        System.out.println("Do you want to transfer between your accounts or different user");
        String cevap = read.nextLine();
        int miktar;
        int miktar2;
        if (cevap.equals("own")) {
            System.out.print("miktar = ");
            miktar = readInt.nextInt();
            Account.trasferToOwnAccount(u1, miktar);
        }
        else {
            System.out.print("miktar = ");
            miktar2 = readInt.nextInt();
            Account.transferOtherUser(u1, u2, miktar2);
        }
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' + "\n" +
                        "password='" + password + '\'' + "\n" +
                        "dateOfBirth='" + dateOfBirth + '\'' + "\n" +
                        "marriageStatus='" + marriageStatus + '\'' + "\n" +

                        "accountNumber1=" + accountNumber1 + "\n" +
                        "amountAccount1=" + amountAccount1 + "\n" +
                        "accountNumber2=" + accountNumber2 + "\n" +
                        "amountAccount2=" + amountAccount2 + '\'' + "\n" +
                        "relativeName='" + relativeName + '\'' + "\n" +
                        "relativeAge='" + relativeAge + "\n"
                ;
    }
}
