package context;

import page.*;

import static test.BaseTest.driver;

public class ContextCandidate {

    public static MainPage mainPage = new MainPage(driver);
    public static LoginPage loginPage = new LoginPage(driver);
    public static ProfilePage profilePage = new ProfilePage(driver);
    public static SearchPage searchPage =  new SearchPage(driver);
    public static CandidatePage candidatePage =  new CandidatePage(driver);

    public static void createProfile(String firstName, String lastName, String phone, String emailToInput) {

        mainPage.openProfileMenu();
        mainPage.clickCandidateLink();
        candidatePage.openCandidateProfileTab();
        candidatePage.clickEditProfileBtn();
        candidatePage.setFirstName(firstName);
        candidatePage.setLastName(lastName);
        candidatePage.setPhone(phone);
        candidatePage.setEmail(emailToInput);
        candidatePage.selectYearOfBirth();
        candidatePage.clickSubmitBtn();
    }

    public static void deleteProfile() { candidatePage.deleteProfile(); }

    public static void editProfile(String firstName, String lastName, String phone, String emailToInput) {

//        mainPage.openProfileMenu();
//        mainPage.clickCandidateLink();
//        candidatePage.clickAcceptInfoMsgBtn();
//        candidatePage.openCandidateProfileTab();
        candidatePage.clickEditProfileBtn();
        candidatePage.setFirstName(firstName);
        candidatePage.setLastName(lastName);
        candidatePage.setPhone(phone);
        candidatePage.setEmail(emailToInput);
        candidatePage.selectYearOfBirth();
        candidatePage.clickSubmitBtn();
    }

    public static String getProfileNameAndLastName() { return candidatePage.getNameAndLastName();}
    public static String getProfileNameAndLastNameAtr() { return candidatePage.getNameAndLastNameAtr(); }

}
