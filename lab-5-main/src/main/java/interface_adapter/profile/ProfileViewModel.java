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
    public static final String ONE_QONE = "Question 1: What’s your favorite drink? A:Coffee B:Tea C:Coke D:Juice E: Alcohol";
    public static final String ONE_QTWO = "Question 2: How do you prefer to spend your weekends with a partner? A: Traveling B: Relaxing C: Hobbies D: Socializing E:other";
    public static final String ONE_QTHREE = "Question 3:What is your dating intention? A: Long-term relationship B: Casual dating C: Friendship D: Marriage E: Exploring options";
    public static final String ONE_QFOUR = "Question 4: What type of relationship are you looking for? A: Romantic B: Platonic C: Professional D: Open relationship E: Undecided";
    public static final String ONE_QFIVE = "Question 5: What kind of dates do you imagine having with your partner? A: Outdoor adventures B: Cozy movie nights C: Fancy dinners D: Shared hobbies E: Cultural experiences";

    public static final String SECTION_TWO = "Section 2";
    public static final String TWO_QONE = "Question 1: What are your religious beliefs? A: Christian B: Muslim C: Hindu D: Agnostic/Atheist E: Other";
    public static final String TWO_QTWO = "Question 2: What are your political beliefs? A: Liberal B: Conservative C: Moderate D: Apolitical E: Prefer not to say";
    public static final String TWO_QTHREE = "Question 3: What do you study? A: STEM B: Arts C: Business D: Engineering E: Other";
    public static final String TWO_QFOUR = "Question 4: What is your preferred language? A: English B: Spanish C: French D: Mandarin E: Other";
    public static final String TWO_QFIVE = "Question 5: What major do you want to date? A: STEM B: Arts C: Business D: Engineering E: Other";

    public static final String SECTION_THREE = "Section 3";
    public static final String THREE_QONE = "Question 1: How often do you drink? A: Never B: Rarely C: Occasionally D: Socially E: Regularly";
    public static final String THREE_QTWO = "Question 2: What’s a deal breaker for you in a partner? A: Dishonesty B: Lack of ambition C: Poor communication D: Different values E: Unkindness";
    public static final String THREE_QTHREE = "Question 3: What kind of lifestyle do you see yourself sharing with a partner? A: Adventurous B: Relaxed C: Balanced D: Ambitious E: Creative";
    public static final String THREE_QFOUR = "Question 4: What’s the most important quality you value in a partner? A: Trust B: Humor C: Empathy D: Intelligence E: Kindness";
    public static final String THREE_QFIVE = "Question 5: How often do you use drugs? A: Never B: Rarely C: Occasionally D: Socially E: Regularly";

    public static final String SECTION_FOUR = "Section 4";
    public static final String FOUR_QONE = "Question 1: Which type of communication style do you prefer in a partner? A: Direct B: Passive C: Assertive D: Empathetic E: Open" +
            " A: grade";
    public static final String FOUR_QTWO = "Question 2: What pace do you prefer for building a relationship? A: Fast B: Steady C: Slow D: Let it flow naturally E: Situational";
    public static final String FOUR_QTHREE = "Question 3:  How important is physical attraction in a partner? A: Very important B: Somewhat important C: Neutral D: Not important E: Prefer not to say";
    public static final String FOUR_QFOUR = "Question 4: How do you hope your partner supports you in life? A: Emotionally B: Financially C: Mentally D: Practically E: All of the above";
    public static final String FOUR_QFIVE = "Question 5:  What shared interests or values do you hope to have with a partner? A: Hobbies B: Life goals C: Cultural values D: Family values E: All of the above";

    public static final String SECTION_FIVE = "Section 5";
    public static final String FIVE_QONE = "Question 1: What’s your love language when it comes to a partner? A: Words of affirmation B: Acts of service C: Quality time D: Physical touch E: Gifts";
    public static final String FIVE_QTWO = "Question 2: How important is humor in a relationship? A: Very important B: Somewhat important C: Neutral D: Not important E: Prefer not to say";
    public static final String FIVE_QTHREE = "Question 3: How do you handle stress? A: Exercise B: Talking to a partner C: Relaxation techniques D: Avoidance E: Creative outlets";
    public static final String FIVE_QFOUR = "Question 4: What role does family play in your ideal partner’s life? A: Central role B: Balanced role C: Minimal role D: Not important E: Flexible";
    public static final String FIVE_QFIVE = "Question 5: How do you envision your partner’s social personality? A: Extroverted B: Introverted C: Balanced D: Adaptable E: Reserved";

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
