package lavsam.gb.testingl1

import junit.framework.TestCase
import org.junit.Test

class EmailValidatorTest {
    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        TestCase.assertTrue(EmailValidator.isValidEmail("test@test.ru"))
    }
}