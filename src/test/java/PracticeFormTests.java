import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @Test
    void successfulSubmitForm() {
        String firstName = "Привет";
        String lastName = "Привет";
        String email = "hello@guugle.com";
        String number = "1234567890";
        String address = "какой-то адрес";
        String subjectsMaths = "Maths";

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("[for='gender-radio-1']").scrollTo().click();
        $("#userNumber").setValue(number);
        $("#subjectsInput").setValue("M");
        $(byText(subjectsMaths)).click();
        $("[for='hobbies-checkbox-1']").click();
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $x("//*[@class='table-responsive']//*[text()='Student Name']/following::td").should(text(firstName + " " + lastName));
        $x("//*[@class='table-responsive']//*[text()='Student Email']/following::td").should(text(email));
        $x("//*[@class='table-responsive']//*[text()='Gender']/following::td").should(text("Male"));
        $x("//*[@class='table-responsive']//*[text()='Mobile']/following::td").should(text(number));
        $x("//*[@class='table-responsive']//*[text()='Date of Birth']/following::td").should(text("20 May,2021"));
        $x("//*[@class='table-responsive']//*[text()='Subjects']/following::td").should(text(subjectsMaths));
        $x("//*[@class='table-responsive']//*[text()='Hobbies']/following::td").should(text("Sports"));
        $x("//*[@class='table-responsive']//*[text()='Address']/following::td").should(text(address));
        $x("//*[@class='table-responsive']//*[text()='State and City']/following::td").should(text("NCR Delhi"));
    }
}
