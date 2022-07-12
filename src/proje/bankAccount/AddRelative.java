package proje.bankAccount;

public class AddRelative {
    String fullname;
    String age;

    public AddRelative(String fullName , String age){
        this.fullname = fullName;
        boolean res= relativeAgeChecker(age);
        if(res==true){
            this.age = age;
        }else{
            this.age = "0";
        }
    }
    public boolean relativeAgeChecker(String relativeAge){
        String result = Users.checkAge(relativeAge);
        if(result.equals("You can get a credit card")){
            return true;
        }
        return false;
    }




}
