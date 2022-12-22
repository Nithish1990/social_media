package application.authentication;

import application.utilities.helper.CustomScanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation{

    public static String validate(String input,String regex,String name){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if(matcher.matches()){
            return input;
        }else{
            return validate(CustomScanner.scanString("Please enter valid "+name),regex,name);
        }
    }
    public static String checkEmailIdIsValid(String email){
        return validate(email,"^(.+)@(.+)$","Email-ID");
    }
    public static String validatePhoneNumber(String number){
        return validate(number,"(0/91)?[7-9][0-9]{9}","PhoneNumber");
    }
    public static String validateDOB(String dob){
        return dob;
    }
    public static String checkPasswordIsValid(String password){
        return validate(password,"^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$","Password");
    }
}
/*

//    public static String checkPasswordIsValid(String password) {
//        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(password);
//        if (matcher.matches()) {
//            return password;
//        } else {
//            return checkPasswordIsValid(CustomScanner.scanString("Password is not met criteria Enter password again"));
//        }
//    }
//    public static String checkEmailIdIsValid(String emailId){
//        String regex = "^(.+)@(.+)$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(emailId);
//        if(matcher.matches())
//            return emailId;
//        else
//            return checkEmailIdIsValid(CustomScanner.scanString("Invalid emailId please try another"));
//    }
//    public static String validatePhoneNumber(String phoneNumber){
//        String regex = "(0/91)?[7-9][0-9]{9}";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(phoneNumber);
//        if(matcher.matches()){
//            return phoneNumber;
//        }else{
//            return validatePhoneNumber(CustomScanner.scanString("Please enter valid phone number"));
//        }
//    }
//
//    public static String validateDOB(String dob){
//        return dob;
//    }
 */