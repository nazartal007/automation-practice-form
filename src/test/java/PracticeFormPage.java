import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    SelenideElement
            firstNameStudent = $("#firstName"),
            lastNameStudent = $("#lastName"),
            email = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            stateField = $("#state"),
            submitButton = $("#submit"),
            genderMale = $("[for='gender-radio-1']"),
            telNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesSports = $("[for='hobbies-checkbox-1']"),
            hobbiesReading = $("[for='hobbies-checkbox-2']"),
            hobbiesMusic = $("[for='hobbies-checkbox-3']"),
            cityField = $("#city"),
            studentNameModal = $x("//*[@class='table-responsive']//*[text()='Student Name']/following::td"),
            genderModal = $x("//*[@class='table-responsive']//*[text()='Gender']/following::td"),
            phoneModal = $x("//*[@class='table-responsive']//*[text()='Mobile']/following::td"),
            dateOfBirdModal = $x("//*[@class='table-responsive']//*[text()='Date of Birth']/following::td"),
            subjectsModal = $x("//*[@class='table-responsive']//*[text()='Subjects']/following::td"),
            hobbiesModal = $x("//*[@class='table-responsive']//*[text()='Hobbies']/following::td"),
            addressModal = $x("//*[@class='table-responsive']//*[text()='Address']/following::td"),
            stateAndCityModal = $x("//*[@class='table-responsive']//*[text()='State and City']/following::td"),
            studentEmailModal = $x("//*[@class='table-responsive']//*[text()='Student Email']/following::td");

    public void openFormPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    public void setNameStudent(String firstName, String lastName) {
        firstNameStudent.setValue(firstName);
        lastNameStudent.setValue(lastName);
    }

    public void setEmail(String userEmail) {
        email.setValue(userEmail);
    }

    public void chooseGenderMale() {
        genderMale.scrollTo().click();

    }

    public void setMobileNumber(String number) {
        telNumberInput.setValue(number);
    }

    public void chooseSubject(String name) {
        subjectsInput.setValue(name);
        $$(byText(name)).get(1).click();
    }

    public void chooseHobbies() {
        hobbiesSports.click();
        hobbiesReading.click();
        hobbiesMusic.click();
    }

    public void setCurrentAddress(String address) {
        currentAddress.setValue(address);
    }

    public void choseStateAndCity(String stateName, String cityName) {
        stateField.click();
        $(byText(stateName)).click();
        cityField.click();
        $(byText(cityName)).click();
    }

    public void submitForm() {
        submitButton.click();
    }

    public void assertStudentFullName(String firstName, String lastName) {
        studentNameModal.shouldHave(text(firstName + " " + lastName));
    }

    public void assertStudentEmail(String email) {
        studentEmailModal.shouldHave(text(email));
    }

    public void assertGender(String gender) {
        genderModal.shouldHave(text(gender));
    }

    public void assertMobNumber(String number) {
        phoneModal.shouldHave(text(number));
    }

    public void assertDateBird(String dateBird) {
        dateOfBirdModal.shouldHave(text(dateBird));
    }

    public void assertSubject(String subject) {
        subjectsModal.shouldHave(text(subject));
    }

    public void assertHobbies(String ...hobbies) {
        for (String oneHobbies : hobbies) {
            hobbiesModal.shouldHave(text(oneHobbies));
        }
    }

    public void assertCurrentAddress(String address) {
        addressModal.shouldHave(text(address));
    }

    public void assertStateAndCity(String state, String city) {
        stateAndCityModal.shouldHave(text(state + " " + city));
    }

    public void assertStudentMail(String mail) {
        studentEmailModal.shouldHave(text(mail));
    }
}
