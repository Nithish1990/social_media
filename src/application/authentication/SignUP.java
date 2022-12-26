package application.authentication;

import application.user.ViewerProfile;
import application.utilities.helper.CustomScanner;
import user.Viewer;

public class SignUP {
    public static ViewerProfile signUP(){

        String name = CustomScanner.scanString("Enter your name");
        String emailId = CustomScanner.scanString("Enter your EmailId");
        emailId = Validation.checkEmailIdIsValid(emailId);
        String password = CustomScanner.scanString("Enter your password 8-20 char, atleast 1 uppercase, 1number,1 special char,1 lower case");
        password = Validation.checkPasswordIsValid(password);
        String number = CustomScanner.scanString("Enter your Phone number");
        number = Validation.validatePhoneNumber(number);
        String dob = CustomScanner.scanString("Enter your DOB dd/mm/yyyy");
        dob = Validation.validateDOB(dob);
        return new ViewerProfile(name,emailId,password,number,dob);
    }
}
