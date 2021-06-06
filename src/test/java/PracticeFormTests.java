import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class PracticeFormTests {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    Faker fakerRu = new Faker(new Locale("ru"));
    Faker fakerEng = new Faker();

    String firstName = fakerRu.name().firstName();
    String lastName = fakerRu.name().lastName();
    String email = fakerEng.internet().emailAddress();
    String number = fakerRu.number().digits(10);
    String address = fakerRu.address().fullAddress();
    String state = "NCR";
    String city = "Delhi";
    String math = "Maths";
    String male = "Male";
    String hobbiesSport = "Sport";
    String hobbiesReading = "Reading";
    String hobbiesMusic = "Music";

    @Test
    void successfulSubmitForm() {
        practiceFormPage.openFormPage();
        practiceFormPage.setNameStudent(firstName, lastName);
        practiceFormPage.setEmail(email);
        practiceFormPage.chooseGenderMale();
        practiceFormPage.setMobileNumber(number);
        practiceFormPage.chooseSubject(math);
        practiceFormPage.chooseHobbies();
        practiceFormPage.setCurrentAddress(address);
        practiceFormPage.choseStateAndCity(state, city);
        practiceFormPage.submitForm();

        practiceFormPage.assertStudentFullName(firstName, lastName);
        practiceFormPage.assertStudentEmail(email);
        practiceFormPage.assertGender(male);
        practiceFormPage.assertMobNumber(number);
        practiceFormPage.assertSubject(math);
        practiceFormPage.assertHobbies(hobbiesSport, hobbiesReading, hobbiesMusic);
        practiceFormPage.assertCurrentAddress(address);
        practiceFormPage.assertStateAndCity(state, city);

    }
}
