s# CSC207-Project
### Group #6 

### Team Name: Code & Cupid 

### Team member: Abigail Chen, Giana Yang, Kensley Zhou, Victoria Chen 

### Domain: Dating App

## Table of Contents:
- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Contribution](#contribution)
- [License](#license)

## Introduction
This project is a dating app designed to help young people, especially university students who are busy with study to build meaningful, efficient, and romantic connections by providing them compatibility scores based on their preferences. The app allows users to create a detailed profile, specify their preferences, and interact with others who meet their criteria. It solves the problem of limited opportunities to meet compatible individuals by providing a convenient and personalized platform for discovering potential partners.

## Specifications 

Cathy is interested in having a romantic relationship. She accesses the dating program and creates an account. Then, she completes a questionnaire with questions regarding her interests, personality, and personal background as well as what she’s looking for in a relationship. She also chooses a compatibility level that she hopes she has with her candidates/matches. She gets a list of other users with which she has a compatibility level equal to or higher than the one she stated. She can “swipe” through these candidates and like the individuals she’s interested in getting to know better. If the other person is also interested in her and likes her, they will start chatting. 

## Features

- Account Management:
Users can create secure accounts with a username, password, and a security word for password recovery.

- Profile Creation:
Users complete a detailed questionnaire covering personal details, preferences, and romantic expectations.
The ability to weigh compatibility questions ensures personalized matching criteria.

- Compatibility-Based Searching and Matching:
Users are presented with a list of potential matches ranked by compatibility score.
The app ensures users only see candidates with compatibility levels equal to or higher than their set threshold.

- Interaction and Matching:
Users can "like" or "dislike" potential matches, initiating connections when mutual interest exists.
Matches allow users to access each other’s contact methods and start chatting in the way they prefer.

- Request Management:
Users receive and manage connection requests, sorted by compatibility levels.

- Logout:
Users can securely log out when done.

## User Stories

- Cathy is interested in having a romantic relationship. She creates an account with a username and password to access the app. She will also choose a security word so that she can use it to reset the password. **[Team’s Story] -> create account (username, password, security word)** 
- Cathy answers multiple choice questions regarding her basic information (age, self-recognized gender and sexual orientation), interests, personality, personal background, romantic preferences, and what she’s looking for in a relationship. She will also choose her preferred method of communication and provide her contact information. She can also weight the question sections with percentages with a higher percentage indicating that she values the compatibility of this section of questions more (Note: the total percentages must equal 100). She can change her profile and resubmit it afterward. **[Giana's Story] -> creating profile, providing contact information, weighting each group of questions** 
- Cathy can use her previously created account information to log into the account. **[Team Story] -> log in** 
- Cathy can reset her password if she forgets her account log in information. She will press the “reset password” button on the initial log in page. The app will ask her to enter the security word. Once she confirms her identity, she will reset her password. The app will return to the log in page. **[Team story] -> reset password**
- Cathy wants to date, but she doesn’t have many opportunities to meet people. She decides to get a dating app and meet people she is compatible. After creating her profile, she wants to see users with whom she has different compatibility levels with. She clicks the “compatibility” button on her home page and sees a list of users in order from the highest compatibility to lower compatibility. Each item in the list consists of the users profile picture, their name, and the compatibility score Cathy has with them. If she isn’t interested in one of the users, she selects the “dislike” button. If she is interested in one of the users, she selects the “like” button and it will send a request to the other user. She can leave it undecided, but once she has made a decision, the next time she logs in, she won’t see this person again.**[Kensley’s Story] -> manage compatibility list**
- Cathy “likes” Bob’s profile. Bob will get a request to view Cathy’s profile. He will click the “requests” button. The “requests” page will show a list of the users that have “liked” Bob’s profile in order from the highest compatibility with Bob (Bob’s weighting). Each item in the list consists of the users profile picture, their name, and their compatibility score with Bob. Bob can “like” or “dislike” each user or return to the requests page. Once he makes a decision, this user will no longer be in the list. **[Abigail's Story] -> manage requests**
- Cathy wants to message her added friend. She logs into the app with her password and her username previously generated. She goes to the menu bar in her home screen and selects "matches" to open a new window which has a list of all her matches (people she has “liked” and have “liked” her back) with their contact methods and contact information. She can contact them through this information. **[Victoria's Story] -> matches**
- Cathy is happy since she can chat with a cool person. She clicks the “log out” button to exit the app. **[Team Story] -> log out**  

## Entities for the Domain:  

User:
- String username 
- String password 
- String securityWord

Profile: 
- String name
- String gender
- String SexualOrientation
- int age
- Map<String, List<String>> answers
- Map<String, Integer> weights
- String contactInfo
- String contactMethod

Finds:
- HashMap<String, Boolean> finds

Requests:
- HashMap<String, Boolean> requests

Matches:
- HashMap<String, List<String>> matches;

## Installation

Before you begin, ensure you have the following software installed on your system:  
- Java Development Kit (JDK) 17:  
Download and install JDK 17 from the Oracle website.
Verify the installation by running java -version in your terminal. It should display the installed JDK version.
- Apache Maven 3.8.5 or later:  
Download and install Maven from the Maven website.
Verify the installation by running mvn -version in your terminal. It should display the installed Maven version.
- IntelliJ IDEA 2024.2.1:  
Download and install IntelliJ IDEA from the JetBrains website.
Ensure you have the latest version to avoid compatibility issues.
- Access to your own firestore database:
To run the program locally, you need to set up your own firestore database.
See the Firestore documentation https://firebase.google.com/docs/firestore for more information on setting up a Firestore database.
After downloading the credentials, add the credential file and replace the file path in the line #51 src/main/java/data_access/RemoteDataAccessObject.java with your own credentials file path.

## Usage

To run the program, follow the steps below:
1. Clone the repository to your local machine.
2. Open the project in IntelliJ IDEA.
3. Build the project by clicking Build > Build Project in the top menu.
4. Set up your Firestore database and replace the file path in the line #51 src/main/java/data_access/RemoteDataAccessObject.java with your own credentials file path.
5. Run the program by clicking the green play button in the top right corner.
6. Follow the on-screen instructions to create an account, complete your profile, and interact with other users.

## Contribution

We welcome contributions from the community. To contribute to this project, follow the steps below:
1. Fork the repository
2. Clone the repository
3. Create a branch
4. Make necessary changes and commit those changes. It is recommended to describe what each commit does individually in the commit message.
5. Push changes to GitHub
6. Create a pull request and comment on the issue with the pull request link
7. We will review your request and look into your code. If there are no conflicts, your pull request will be merged. If there are conflicts, we will contact with you.
8. Once your pull request is merged, you can delete your branch
9. If you have any questions, please let us know by contacting the email address below.

## Contact
If you have any questions or concerns, please contact us at
- Abigail Chen: abigail.chen@maio.utoronto.ca
- Giana Yang: qifanfan.yang@mail.utoronto.ca
- Kensley Zhou: kensley.zhou@mail.utoronto.ca
- Victoria Chen: victoriaj.chen@mail.utoronto.ca

## License
This project is licensed under the MIT License - see the LICENSE.md file for details.
