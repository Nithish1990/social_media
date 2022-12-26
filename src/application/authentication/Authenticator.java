package application.authentication;

import application.Application;
import application.user.ViewerProfile;
import application.utilities.constant.country.Country;
import user.Viewer;
import java.util.Map;


public class Authenticator {
    public Viewer logIn(String emailId, String password, Map<String, ViewerProfile> db){
        ViewerProfile viewer = db.getOrDefault(emailId,null);
        if(viewer != null) {
            if (viewer.getPassword().equals(password)) {
                System.out.println("Success");
                return new Viewer(viewer);
            }else {
                System.err.println("Wrong password");
            }
        }
        else{
            System.err.print("User not found ");
            System.out.println("Please signUp");
        }
        return null;

    }
    public Viewer signUp(ViewerProfile viewerProfile, Map<String,ViewerProfile>db){
        Viewer viewer = null;
        if(db.getOrDefault(viewerProfile.getUserEmailID(),null)==null) {
            db.put(viewerProfile.getUserEmailID(),viewerProfile);
            viewer = new Viewer(viewerProfile);
        }
        else {
            System.err.println("User already exits");
        }
        return  viewer;
    }
    private void verification(){

    }

    public Authenticator(Application application){// application will be deleted

        // for testing
        //application.getDatabase().addUser(new Viewer("Test","Test1234@gmail.com","Test1234@gmail.com","9876543210","11/12/2001",Country.INDIA,application));
    }
}
