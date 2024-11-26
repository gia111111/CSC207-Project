package interface_adapter.profile;

import interface_adapter.ViewModel;


public class ProfileViewModel extends ViewModel<ProfileState>{
    public static final String TITLE_LABEL = "Profile";
    public static final String BASIC_INFORMATION = "Basic Information";
    public static final String BQ_GENDER = "Please indicate the gender(s) you self-identify with: ";
    public static final String BQ_SEXUAL_ORIENTATION = "Please indicate your sexual orientation: ";
    public static final String BQ_AGE = "Please enter your age: ";
    public static final String CONTACT_METHOD = "Contact Method: ";
    public static final String CONTACT_INFO = "Contact Information (ie. username, ID): ";

    public static final String SECTION_ONE = "Section 1";
    public static final String ONE_QONE = "Question 1: What’s your ethnicity?";
    public static final String ONE_QTWO = "Question 2: Who do you want to date?";
    public static final String ONE_QTHREE = "Question 3:What is your dating intention?";
    public static final String ONE_QFOUR = "Question 4: What type of relationship are you looking for?";
    public static final String ONE_QFIVE = "Question 5: What kind of dates do you imagine having with your partner?";

    public static final String SECTION_TWO = "Section 2";
    public static final String TWO_QONE = "Question 1: What are your religious beliefs?";
    public static final String TWO_QTWO = "Question 2: What are your political beliefs?";
    public static final String TWO_QTHREE = "Question 3: What do you study?";
    public static final String TWO_QFOUR = "Question 4: What is your preferred language?";
    public static final String TWO_QFIVE = "Question 5: Which level of study you are in?";

    public static final String SECTION_THREE = "Section 3";
    public static final String THREE_QONE = "Question 1: How often do you drink?";
    public static final String THREE_QTWO = "Question 2: What’s a deal breaker for you in a partner?";
    public static final String THREE_QTHREE = "Question 3: What kind of lifestyle do you see yourself sharing with a partner?";
    public static final String THREE_QFOUR = "Question 4: What’s the most important quality you value in a partner?";
    public static final String THREE_QFIVE = "Question 5: How often do you use drugs?";

    public static final String SECTION_FOUR = "Section 4";
    public static final String FOUR_QONE = "Question 1: Which type of communication style do you prefer in a partner";
    public static final String FOUR_QTWO = "Question 2: What pace do you prefer for building a relationship?";
    public static final String FOUR_QTHREE = "Question 3:  How important is physical attraction in a partner?";
    public static final String FOUR_QFOUR = "Question 4: How do you hope your partner supports you in life?";
    public static final String FOUR_QFIVE = "Question 5:  What shared interests or values do you hope to have with a partner?";

    public static final String SECTION_FIVE = "Section 5";
    public static final String FIVE_QONE = "Question 1: What’s your love language when it comes to a partner?";
    public static final String FIVE_QTWO = "Question 2: How important is humor in a relationship?";
    public static final String FIVE_QTHREE = "Question 3: How do you handle stress?";
    public static final String FIVE_QFOUR = "Question 4: What role does family play in your ideal partner’s life?";
    public static final String FIVE_QFIVE = "Question 5: How do you envision your partner’s social personality?";

    public static final String SAVE_BUTTON_LABEL = "Save";

    public static final String MC_A = "A";
    public static final String MC_B = "B";
    public static final String MC_C = "C";
    public static final String MC_D = "D";
    public static final String MC_E = "E";

    public static final String Q_WEIGHT = "Below, please indicate the percentage you place on each sections in" +
            "regards to compatibility ie. if I really value section 5, I would input a larger number" +
            "(Note: the total sum of all section weights must be 100)";
    public static final String SECTION_WEIGHT = "Section Weight";

    public ProfileViewModel() {
        super("profile");

        setState(new ProfileState());
    }
}
