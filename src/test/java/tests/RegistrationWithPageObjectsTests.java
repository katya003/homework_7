package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class RegistrationWithPageObjectsTests extends TestBase {

    private  final RegistrationPage registrationPage = new RegistrationPage();
    private  final RandomUtils randomUtils = new RandomUtils();
    String firstName = randomUtils.getFirstName();
    String lastName = randomUtils.getLastName();
    String userEmail = randomUtils.getUserEmail();
    String gender = randomUtils.getGender();
    String userNumber = randomUtils.getUserNumber();
    String dayOfBirth = randomUtils.gerDayOfBirth();
    String monthOfBirth = randomUtils.getMonthBirth();
    String yearOfBirth = randomUtils.getYearOfBirth();
    String subjectsOne = randomUtils.getSubjectsOne();
    String hobbiesOne = randomUtils.getHobbiesOne();
    String pictureName = "test.jpg";
    String address = randomUtils.getAddress();
    String state = randomUtils.getState();
    String city = randomUtils.getCity(state);



    @Test
    public void registrationWithPageObjectsTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subjectsOne)
                .setHobby(hobbiesOne)
                .uploadPicture(pictureName)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjectsOne)
                .checkResult("Hobbies", hobbiesOne)
                .checkResult("Picture", pictureName)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    public void registrationWithPageObjectsRequiredFieldsTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber);
    }

    @Test
    public void registrationWithPageObjectsNegativeTest() {
        registrationPage.openPage()
                .removeBanner()
                .clickSubmit();

        registrationPage.checkNegativeResult();
    }
}
