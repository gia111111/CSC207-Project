package data_access;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import com.google.firebase.cloud.FirestoreClient;
import entity.*;
import use_case.find.FindUserDataAccessInterface;
import use_case.change_password.ChangePasswordUserDataAccessInterface;
import use_case.createProfile.CreateProfileDataAccessInterface;
import use_case.editprofile.EditProfileInputData;
import use_case.editprofile.EditProfileUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.logout.LogoutUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class RemoteDataAccessObject implements SignupUserDataAccessInterface,
        LoginUserDataAccessInterface,
        ChangePasswordUserDataAccessInterface,
        CreateProfileDataAccessInterface,
        EditProfileUserDataAccessInterface,
        FindUserDataAccessInterface,
        LogoutUserDataAccessInterface {

    private final Firestore db;
    private String currentUsername;
    private String gender;
    private String sexualOrientation;
    private int age;
    private Map<String, List<String>> sectionAnswers = new HashMap<>();
    private Map<String, Integer> sectionWeights = new HashMap<>();
    private String contactMethod;
    private String contactInfo;
    private final ProfileFactory profileFactory;


    public RemoteDataAccessObject() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("/Users/kensleyzhou/IdeaProjects/Week9_login/CSC207-Project/lab-5-main/src/credential");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        FirebaseApp.initializeApp(options);
        db = FirestoreClient.getFirestore();
        this.profileFactory = new CommonProfileFactory();
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
        return this.currentUsername;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setSexualOrientation(String sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }

    @Override
    public void setAgeValue(int age) {
        this.age = age;
    }

    @Override
    public void setSectionAnswers(Map<String, List<String>> sectionAnswers) {
        this.sectionAnswers = sectionAnswers;
    }

    @Override
    public void setSectionWeights(Map<String, Integer> sectionWeights) {
        this.sectionWeights = sectionWeights;
    }

    @Override
    public String getGender() {
        return this.gender;
    }

    @Override
    public String getSexualOrientation() {
        return this.sexualOrientation;
    }

    @Override
    public int getAgeValue() {
        return this.age;
    }

    @Override
    public Map<String, List<String>> getSectionAnswers() {
        return this.sectionAnswers;
    }

    @Override
    public Map<String, Integer> getSectionWeights() {
        return this.sectionWeights;
    }

    @Override
    public void setContactMethod(String contactMethod) {
        this.contactMethod = contactMethod;
    }

    @Override
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String getContactMethod() {
        return this.contactMethod;
    }

    @Override
    public String getContactInfo() {
        return this.contactInfo;
    }

    @Override
    public void setCurrentUsername(String username) {
        this.currentUsername = username;
    }

    /**
     * Impelmentations of the save method in the CreateProfileDataAccessInterface.
     */
    @Override
    public void save(Profile profile) {
//        DocumentReference docRef = db.collection("profiles").document(profile.getName());
       // DocumentReference docRef = db.collection("profiles").document("test6");
//        System.out.println("age"+profile.getAge());
//        db.collection("users").document("test9").set(profile, SetOptions.merge());
        //docRef.set(profile);

        DocumentReference docRef = db.collection("profiles").document(profile.getName());
        docRef.set(profile);
        System.out.println("save" + profile.getAnswer());
        System.out.println("save" + profile.getWeights());

//        ArrayList<String> blub = new ArrayList<>();
//        blub.add("hello");
//        blub.add("bye");
//        ArrayList<String> blip = new ArrayList<>();
//        blip.add("murp");
//        blip.add("aur");
//        HashMap<String, List<String>> hi = new HashMap<>();
//        hi.put("section1", blub);
//        hi.put("section2", blip);
//
//        docRef.set(Map.of("name", profile.getName(), "age", profile.getAge(), "gender", profile.getGender(),
//                "sexual orientation", profile.getSexualOrientation(),"answers",hi,"weights", profile.getWeights()));





//        try {
//            DocumentSnapshot document = docRef.get().get();
//            if (document.exists()) {
//                String name = document.getString("name");
//                String age = document.get("age");
//                System.out.println("save"+age);
//                System.out.println("save"+name);
//            }
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }

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

//    @Override
//    public Profile getProfile(String username) {
//        DocumentReference docRef = db.collection("profiles").document(username);
//        try {
//            DocumentSnapshot document = docRef.get().get(); // Blocking call
//            if (document.exists()) {
//                return mapDocumentToProfile(document);
//            }
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//        return null; // Return null if profile not found or error occurred
//    }
//
//    @Override
//    public List<Profile> getAllProfiles() {
//        List<Profile> profiles = new ArrayList<>();
//        try {
//            QuerySnapshot snapshot = db.collection("profiles").get().get(); // Blocking call
//            for (DocumentSnapshot document : snapshot.getDocuments()) {
//                profiles.add(mapDocumentToProfile(document));
//            }
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//        return profiles;
//    }
//
//    private Profile mapDocumentToProfile(DocumentSnapshot document) {
//        String name = document.getString("name");
//        String gender = document.getString("gender");
//        String sexualOrientation = document.getString("SexualOrientation");
//        int age = document.getLong("age").intValue();
//        Map<String, Integer> weights = (Map<String, Integer>) document.get("weights");
//        Map<String, List<String>> answers = (Map<String, List<String>>) document.get("answers");
//        String contactInfo = document.getString("contactInfo");
//        String contactMethod = document.getString("contactMethod");
//
//        // Use the factory to create the profile
//        return profileFactory.create(name, gender, sexualOrientation, age, answers, weights, contactInfo, contactMethod);
//    }

    @Override
    public List<String> getNames() throws Exception {
        // Reference the specified collection
        CollectionReference collection = db.collection("profiles");

        // Fetch all documents in the collection
        ApiFuture<QuerySnapshot> future = collection.get();
        QuerySnapshot querySnapshot = future.get();

        // Extract and return document IDs
        List<String> documentNames = new ArrayList<>();
        for (DocumentSnapshot document : querySnapshot.getDocuments()) {
            documentNames.add(document.getId()); // Use document ID as username
        }
        System.out.println("getnames" + documentNames);
        return documentNames;
    }

    @Override
    public Profile getProfile(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username must be a non-empty string.");
        }

        // Reference the document with the given username in the "profiles" collection
        DocumentReference docRef = db.collection("profiles").document(username);

        try {
            // Fetch the document
            DocumentSnapshot document = docRef.get().get();

            // If the document exists, map its fields to a Profile object
            if (document.exists()) {
                String name = document.getString("name");
                String gender = document.getString("gender");
                String sexualOrientation = document.getString("SexualOrientation");
                int age = document.getLong("age").intValue();
                Map<String, Integer> weights = (Map<String, Integer>) document.get("weights");
                Map<String, List<String>> answers = (Map<String, List<String>>) document.get("answers");
                String contactInfo = document.getString("contactInfo");
                String contactMethod = document.getString("contactMethod");

                // Return the Profile object
                return profileFactory.create(name, gender, sexualOrientation, age, answers, weights, contactInfo, contactMethod);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace(); // Log any errors during the fetch
        }

        return null; // Return null if no profile is found or an error occurs
    }

//    @Override
//    public void saveMatch(String username, Matches matches) {
//        DocumentReference docRef = db.collection("matches").document(username);
//
//        try {
//            // Fetch existing matches
//            DocumentSnapshot document = docRef.get().get();
//            HashMap<String, List<String>> matches = new HashMap<>();
//
//            if (document.exists()) {
//                matches = (HashMap<String, List<String>>) document.get("matches");
//            }
//
//            // Add or update the match
//            matches.put(matchName, contactInfo);
//
//            // Save updated matches map back to Firestore
//            docRef.set(Map.of("matches", matches));
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public HashMap<String, List<String>> getMatches(String username) {
//        DocumentReference docRef = db.collection("matches").document(username);
//
//        try {
//            // Fetch user's matches
//            DocumentSnapshot document = docRef.get().get();
//            if (document.exists()) {
//                return (HashMap<String, List<String>>) document.get("matches");
//            }
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        // Return an empty map if no matches are found
//        return new HashMap<>();
//    }
//
//    @Override
//    public boolean matchExists(String username, String matchName) {
//        DocumentReference docRef = db.collection("matches").document(username);
//
//        try {
//            DocumentSnapshot document = docRef.get().get();
//            if (document.exists()) {
//                HashMap<String, List<String>> matches = (HashMap<String, List<String>>) document.get("matches");
//                return matches != null && matches.containsKey(matchName);
//            }
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }
}
