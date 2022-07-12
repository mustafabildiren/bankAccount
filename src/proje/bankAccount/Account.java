package proje.bankAccount;



public class Account {

    static int deposit(int accountAmount,int amountToAdd){
        return accountAmount+amountToAdd;
    }

    static int withDraw(int accountAmount,int withdrawAmount){
        return accountAmount-withdrawAmount;
    }

    public static String transferOtherUser(Users sendingUser, Users receivingUser, int transferAmount){
        if (transferAmount> sendingUser.accountNumber1){
            return "Sender is poor lol :)";
        }
        else {
            transferAmount-=(transferAmount/100)*2;
            sendingUser.amountAccount1-=transferAmount;
            receivingUser.amountAccount1+=transferAmount;
            return "Transaction is completed successfully";
        }
    }

    public static String trasferToOwnAccount(Users user,int transferAmount){
        if (transferAmount> user.amountAccount1){
            return "ou need more money dude";
        }
        else {
            transferAmount-=(transferAmount/100);
            user.amountAccount1-=transferAmount;
            user.amountAccount2+=transferAmount;
            return "Transaction is completed successfully";
        }
    }



}
