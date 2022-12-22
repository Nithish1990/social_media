package application.authentication;

import application.Application;
import application.database.Database;
import application.utilities.constant.country.Country;
import application.utilities.helper.CustomScanner;
import sun.lwawt.macosx.CSystemTray;
import user.Viewer;



public class Authenticator {
    private Database database;
    public Viewer logIn(){
        String emailId = CustomScanner.scanString("Enter emailId"),password = CustomScanner.scanString("Enter password");
        Viewer viewer = database.getUser(emailId);
        if(viewer != null) {
            if (viewer.getPassword().equals(password)) {
                System.out.println("Success");
            }else {
                System.err.println("Wrong password");
            }
        }
        else{
            System.err.print("User not found ");
            System.out.println("Please signUp");
        }
        return viewer;
    }
    public Viewer signUp(){
        String name = CustomScanner.scanString("Enter your name");
        String emailId = CustomScanner.scanString("Enter your EmailId");
        emailId = Validation.checkEmailIdIsValid(emailId);
        String password = CustomScanner.scanString("Enter your password 8-20 char, atleast 1 uppercase, 1number,1 special char,1 lower case");
        password = Validation.checkPasswordIsValid(password);
        String number = CustomScanner.scanString("Enter your Phone number");
        number = Validation.validatePhoneNumber(number);
        String dob = CustomScanner.scanString("Enter your DOB dd/mm/yyyy");
        dob = Validation.validateDOB(dob);
        Viewer viewer = null;
        if(database.getUser(emailId)==null) {
            viewer = new Viewer(name, emailId, password, number, dob, Country.INDIA);
            database.addUser(viewer);
        }
        else {
            System.err.println("User already exits");
        }
        System.out.println(database.getViewerDB());
        return  viewer;
    }
    private void verification(){

    }

    public Authenticator(Database database){
        this.database = database;
    }
}
