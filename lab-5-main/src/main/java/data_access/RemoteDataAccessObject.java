package data_access;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.cloud.firestore.Firestore;

import com.google.firebase.cloud.FirestoreClient;
import entity.CommonUser;
import entity.Profile;
import entity.User;
import use_case.change_password.ChangePasswordUserDataAccessInterface;
import use_case.createProfile.CreateProfileDataAccessInterface;
import use_case.editprofile.EditProfileInputData;
import use_case.editprofile.EditProfileUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.logout.LogoutUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class RemoteDataAccessObject implements SignupUserDataAccessInterface,
        LoginUserDataAccessInterface,
        ChangePasswordUserDataAccessInterface,
        CreateProfileDataAccessInterface,
        EditProfileUserDataAccessInterface,
        LogoutUserDataAccessInterface {

    private final Firestore db;

    public RemoteDataAccessObject() throws IOException {
        // FileInputStream serviceAccount = new FileInputStream("/Users/chenxiaoping/IdeaProjects/yangqif7/CSC207-Project/lab-5-main/src/credential.json");
        FileInputStream serviceAccount = new FileInputStream("/Users/abigail/IdeaProjects/CSC207-Project/lab-5-main/src/credential.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        FirebaseApp.initializeApp(options);
        db = FirestoreClient.getFirestore();
    }

    /**
     * Impelmentations of the existsByName,changePassword, save and get method in the ChangePasswordUserDataAccessInterface.
     * Impelmentations of the existsByName and save method in the SignupUserDataAccessInterface.
     */
    @Override
    public void changePassword(User user) {
        DocumentReference docRef = db.collection("users").document(user.getName());
        docRef.update("password", user.getPassword());
    }

    @Override
    public boolean existsByName(String username) {
        DocumentReference docRef = db.collection("users").document(username);
        try {
            DocumentSnapshot document = docRef.get().get();
            return document.exists();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User get(String username) {
        DocumentReference docRef = db.collection("users").document(username);
        try {
            DocumentSnapshot document = docRef.get().get();
            if (document.exists()) {
                String name = document.getString("name");
                String password = document.getString("password");
                String securityWord = document.getString("securityWord");
                return new CommonUser(name, password, securityWord);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(User user) {
        DocumentReference docRef = db.collection("users").document(user.getName());
        docRef.set(user);
    }

    /**
     * Impelmentations of the existsByName, save, getCurrentUsername and setCurrentUsername method in the LoginUserDataAccessInterface.
     */
    @Override
    public String getCurrentUsername() {
        return "";
    }

    @Override
    public void setCurrentUsername(String username) {

    }

    /**
     * Impelmentations of the save method in the CreateProfileDataAccessInterface.
     */
    @Override
    public void save(Profile profile) {
        DocumentReference docRef = db.collection("profiles").document(profile.getName());
        docRef.set(profile);
    }

    /**
     * Impelmentations of the save method in the LogoutUserDataAccessInterface.
     */
    @Override

    public void save(EditProfileInputData editProfileInputData) {
        DocumentReference docRef = db.collection("profiles").document(editProfileInputData.getName());
        docRef.update("name", editProfileInputData.getName());
        docRef.update("gender", editProfileInputData.getGender());
        docRef.update("SexualOrientation", editProfileInputData.getSexualOrientation());
        docRef.update("age", editProfileInputData.getAge());
        docRef.update("answers", editProfileInputData.getAnswers());
        docRef.update("weights", editProfileInputData.getWeights());
    }
}
