# CSC207-Project
### Group #6 

### Team Name: Code & Cupid 

### Domain: Dating App  

## Software Specifications: 

Cathy is interested in having a romantic relationship. She accesses the dating program and creates an account. Then, she completes a questionnaire with questions regarding her interests, personality, and personal background as well as what she’s looking for in a relationship. She also chooses a compatibility level that she hopes she has with her candidates/matches. She gets a list of other users with which she has a compatibility level equal to or higher than the one she stated. She can “swipe” through these candidates and like the individuals she’s interested in getting to know better. If the other person is also interested in her and likes her, they will start chatting. 

## User Stories:  

- Cathy is interested in having a romantic relationship. She creates an account with a username and password to access the app. She will also choose a security word. **[Team’s Story] -> create account (username, password, security word)** 
- Cathy answers multiple choice questions regarding her interests, personality, personal background, romantic preferences, and what she’s looking for in a relationship. She will also choose her preferred method of communication and provide her contact information. She can also weight the question sections with percentages with a higher percentage indicating that she values the compatibility of this section of questions more (Note: the total percentages must equal 100). **[Team Story] -> creating profile, providing contact information, weighting each group of questions** 
- Cathy can use her previously created account information to log into the account. **[Team Story] -> log in** 
- Cathy can reset her password if she forgets her account log in information. She will press the “reset password” button on the initial log in page. The app will ask her to choose her security question and answer. Once she confirms her identity, she will reset her password. The app will return to the log in page. **[Team story] -> reset password**
- A few weeks after registration and setting up a profile, Cathy logs into the app and feels slightly disappointed that only a few people texts her. She thinks it might be probably because she says in the profile that she is a computer science student, so others might feel that she is too busy to date. She clicks the “edit profile” button and changes the information about her major in the profile from "computer science" to “don’t want to share”. She clicks the save button to save her changes of her profile. **[Giana’s Story] -> update profile** 
- Cathy wants to date but she doesn’t have many opportunities to meet people. She decides to get a dating app and meet people she is compatible. After creating her profile, she wants to see users with whom she has different compatibility levels with. She clicks the “compatibility” button on her home page and sees a list of users in order from highest compatibility to lower compatibility. Each item in the list consists of the users profile picture, their name, and the compatibility score Cathy has with them. **[Victoria’s Story] -> compatibility list**
- Within the “Compatibility” page, Cathy can click on each user to see portions of their profile (not including contact information). If she isn’t interested in one of the users, she selects the “dislike” button. If she is interested in one of the users, she selects the “like” button. She can also press the “return” button if she doesn’t want to make a decision. Once she makes a decision regarding a user, the app will automatically return her to the “compatibility” page. She can change her decision regarding this person in this log-in session, but once she has made a decision, the next time she logs in, she won’t see this person again. **[Abigail’s Story] -> swipe for matches**
- Cathy “likes” Bob’s profile. Bob will get a request to view Cathy’s profile. He will click the “requests” button. The “requests” page will show a list of the users that have “liked” Bob’s profile in order from highest compatibility with Bob (Bob’s weighting). Each item in the list consists of the users profile picture, their name, and their compatibility score with Bob. Bob can click on each user and see their profile (not including contact information). Bob can “like” or “dislike” each user or return to the requests page. Once he makes a decision, the app will return to the requests page, and this user will no longer be in the list. When Bob has new requests since the time he last accessed the ‘requests’ page, the red card next to the ‘requests’ button will indicate it. **[Team Story] -> requests** 
- If both Bob and Cathy “like” each other, they will get access to the others contact card with information on how to contact them. These contact cards can be found in the “matches” page. When Cathy has new matches since the time she last accessed the ‘match’ page, the red card next to the ‘match’ button will indicate it. **[Team Story] -> approval + contact sharing**
- Cathy wants to message her added friend. She logs into the app with her password and her username previously generated. She goes to the menu bar in her home screen and selects "matches" to open a new window which has a list of all her matches (people she has “liked” and have “liked” her back). She clicks on one individuals and sees their contact information. She can contact them through this information. **[Kensley’s Story] -> matches**
- Cathy is happy since she is chatting with a cool person. She clicks the “log out” button to exit the app. **[Team Story] -> log out**  

## Proposed Entities for the Domain:  

User:  
- String userId 
- String username 
- String password 
- String gender 
- String pronouns 
- String sexualOrientation 
- LocalDate dateOfBirth 

Profile: 
- List<String> interest 
- List<String> personality 
- List<String> lookingFor 
- List<String> profilePhoto 

Compatibility:
- User user1 
- User user2 
- Float compatibility 

Match:
- User user1 
- Float preferredCompatibility 
- List<String> matches 

Swipe:
- String userFrom 
- String userTo

ContactCard:
- String platform
- String profileId

## Proposed API for the project: 

https://cloudinary.com/  
- Image storage API for profile pictures 
https://documentation.onesignal.com/reference/rest-api-overview 
- For push notifications, messaging, and create, store, and update users.
https://www.postman.com/cloudy-astronaut-813156/csc207-grade-apis-demo/overview 
- For log-in, log-out, password change, data storage 

## Scheduled Meeting Times + Mode of Communication:  

Meeting Time: Thursday at 8pm  

Mode of Communication: Text Message, Zoom  

 
