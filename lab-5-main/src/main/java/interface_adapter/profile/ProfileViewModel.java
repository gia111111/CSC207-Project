package interface_adapter.profile;

import interface_adapter.ViewModel;


public class ProfileViewModel extends ViewModel<ProfileState>{
    public static final String TITLE_LABEL = "Profile";
    public static final String BASIC_INFORMATION = "Basic Information";
    public static final String BQ_GENDER = "Please indicate the gender(s) you self-identify with: ";
    public static final String BQ_SEXUAL_ORIENTATION = "Please indicate your sexual orientation: ";
    public static final String BQ_AGE = "Please enter your age: ";

    public static final String SECTION_ONE = "Section 1";
    public static final String ONE_QONE = "Question 1 text: ";
    public static final String ONE_QTWO = "Question 2 text: ";
    public static final String ONE_QTHREE = "Question 3 text; ";
    public static final String ONE_QFOUR = "Question 4 text";
    public static final String ONE_QFIVE = "Question 5 text";
    public static final String ONE_QSIX = "Question 5 text: ";
    public static final String ONE_QSEVEN = "Question 6 text: ";
    public static final String ONE_QEIGHT = "Question 7 text: ";
    public static final String ONE_QNINE = "Question 9 text: ";
    public static final String ONE_QTEN = "Question 10 text: ";

    public static final String SECTION_TWO = "Section 2";
    public static final String TWO_QONE = "Question 1 text: ";
    public static final String TWO_QTWO = "Question 2 text: ";
    public static final String TWO_QTHREE = "Question 3 text: ";
    public static final String TWO_QFOUR = "Question 4 text: ";
    public static final String TWO_QFIVE = "Question 5 text: ";
    public static final String TWO_QSIX = "Question 6 text: ";
    public static final String TWO_QSEVEN = "Question 7 text: ";
    public static final String TWO_QEIGHT = "Question 8 text: ";
    public static final String TWO_QNINE = "Question 9 text: ";
    public static final String TWO_QTEN = "Question 10 text: ";

    public static final String SECTION_THREE = "Section 3";
    public static final String THREE_QONE = "Question 1 text: ";
    public static final String THREE_QTWO = "Question 2 text: ";
    public static final String THREE_QTHREE = "Question 3 text: ";
    public static final String THREE_QFOUR = "Question 4 text: ";
    public static final String THREE_QFIVE = "Question 5 text: ";
    public static final String THREE_QSIX = "Question 6 text: ";
    public static final String THREE_QSEVEN = "Question 7 text: ";
    public static final String THREE_QEIGHT = "Question 8 text: ";
    public static final String THREE_QNINE = "Question 9 text: ";
    public static final String THREE_QTEN = "Question 10 text: ";

    public static final String SECTION_FOUR = "Section 4";
    public static final String FOUR_QONE = "Question 1 text: ";
    public static final String FOUR_QTWO = "Question 2 text: ";
    public static final String FOUR_QTHREE = "Question 3 text: ";
    public static final String FOUR_QFOUR = "Question 4 text: ";
    public static final String FOUR_QFIVE = "Question 5 text: ";
    public static final String FOUR_QSIX = "Question 6 text: ";
    public static final String FOUR_QSEVEN = "Question 7 text: ";
    public static final String FOUR_QEIGHT = "Question 8 text: ";
    public static final String FOUR_QNINE = "Question 9 text: ";
    public static final String FOUR_QTEN = "Question 10 text: ";

    public static final String SECTION_FIVE = "Section 5";
    public static final String FIVE_QONE = "Question 1 text: ";
    public static final String FIVE_QTWO = "Question 2 text: ";
    public static final String FIVE_QTHREE = "Question 3 text: ";
    public static final String FIVE_QFOUR = "Question 4 text: ";
    public static final String FIVE_QFIVE = "Question 5 text: ";
    public static final String FIVE_QSIX = "Question 6 text: ";
    public static final String FIVE_QSEVEN = "Question 7 text: ";
    public static final String FIVE_QEIGHT= "Question 8 text: ";
    public static final String FIVE_QNINE = "Question 9 text: ";
    public static final String FIVE_QTEN = "Question 10 text: ";

    public static final String SAVE_BUTTON_LABEL = "Save";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    public static final String MC_A = "A";
    public static final String MC_B = "B";
    public static final String MC_C = "C";
    public static final String MC_D = "D";
    public static final String MC_E = "E";

    public static final String Q_WEIGHT = "Below, please indicate the percentage you place on each sections in" +
            "regards to compatibility ie. if I really value section 5, I would input a larger percentage" +
            "(Note: the total sum of all section weights must be 1";
    public static final String SECTION_WEIGHT = "Section Weight";

    public ProfileViewModel() {
        super("profile");

        setState(new ProfileState());
    }
}
