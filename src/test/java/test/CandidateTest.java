package test;

import context.ContextCandidate;
import org.testng.Assert;
import org.testng.annotations.Test;

import static context.ContextCandidate.getProfileNameAndLastName;

public class CandidateTest extends BaseTest{

    @Test(priority = 14)
    public void createCandidateProfile() throws InterruptedException {
//        LoginTest.loginZTest();
        String firstName = "Diana";
        String lastName = "Test";
        String phone = "0631233210";
        String emailToInput = "diankatestmail@gmail.com";
        ContextCandidate.createProfile(firstName, lastName, phone, emailToInput);
        Thread.sleep(2000);
        Assert.assertEquals(getProfileNameAndLastName(), firstName + " " + lastName);
        Thread.sleep(2000);
        ContextCandidate.deleteProfile();
    }

    @Test(priority = 15)
    public void editCandidateProfile() throws InterruptedException {
//        LoginTest.loginZTest();
        String firstName = "Diana";
        String lastName = "Test";
        String phone = "0631233210";
        String emailToInput = "diankatestmail@gmail.com";
        ContextCandidate.createProfile(firstName, lastName, phone, emailToInput);
        String firstNameEdit = "Anna";
        String lastNameEdit = "Void";
        String phoneEdit = "0631233214";
        String emailToInputEdit = "diankatestmail@gmail.com";
        ContextCandidate.editProfile(firstNameEdit, lastNameEdit, phoneEdit, emailToInputEdit);
        Thread.sleep(2000);
        Assert.assertEquals(getProfileNameAndLastName(), firstNameEdit + " " + lastNameEdit);
        Thread.sleep(2000);
        ContextCandidate.deleteProfile();
    }


}
