package lavsam.gb.testingl1

import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test

class EmailValidatorTest {
    @Test
    fun emailValidator_InvalidEmailNoDomain_ReturnsFalse() {
        TestCase.assertFalse(EmailValidator.isValidEmail("test@test."))
    }

    @Test
    fun emailValidator_InvalidEmailIncorrectSymbol_ReturnsFalse() {
        TestCase.assertFalse(EmailValidator.isValidEmail("test@test.2"))
    }

    @Test
    fun emailValidator_InvalidEmailRussianSymbol_ReturnsFalse() {
        TestCase.assertFalse(EmailValidator.isValidEmail("щи@test.ru"))
    }

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        TestCase.assertTrue(EmailValidator.isValidEmail("test@test.ru"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        TestCase.assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        TestCase.assertFalse(EmailValidator.isValidEmail("test@test"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        TestCase.assertFalse(EmailValidator.isValidEmail("user@test..ru"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        TestCase.assertFalse(EmailValidator.isValidEmail("@gmail.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        TestCase.assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        TestCase.assertFalse(EmailValidator.isValidEmail(null))
    }

    @Test
    fun emailValidator_NoDomain_ReturnsFalse() {
        TestCase.assertFalse(EmailValidator.isValidEmail("name@"))
    }

    @Test
    fun emailValidator_NoSplitNameAndDomain_ReturnsFalse() {
        TestCase.assertFalse(EmailValidator.isValidEmail("nameyandex.ru"))
    }

    @Test
    fun emailValidator_NoNameAndDomain_ReturnsFalse() {
        TestCase.assertFalse(EmailValidator.isValidEmail("@"))
    }

    @Test
    fun emailValidator_IncorrectEmailSubDomain_ReturnsFalse() {
        TestCase.assertFalse(EmailValidator.isValidEmail("name@email.co."))
    }

    @Test
    fun emailValidator_IncorrectSplitBetweenNameAndDomain_ReturnsFalse() {
        TestCase.assertFalse(EmailValidator.isValidEmail("name.email.ru"))
    }

    @Test
    fun emailValidator_IncorrectTypeOnlyNumbers_ReturnsFalse() {
        TestCase.assertFalse(EmailValidator.isValidEmail("1111.111"))
    }

    @Test
    fun emailValidator_EmailIsEqual_ReturnsTrue() {
        TestCase.assertEquals("test@test.ru", EmailValidator.checkEmail("test@test.ru"))
    }

    @Test
    fun emailValidator_EmailIsNotEqual_ReturnsTrue() {
        Assert.assertNotEquals("test@test.ru", EmailValidator.checkEmail("user@user.com"))
    }

    @Test
    fun emailValidator_EmailIsNull_ReturnsTrue() {
        TestCase.assertNull(EmailValidator.checkEmail(null))
    }

    @Test
    fun emailValidator_EmailIsNotNull_ReturnsTrue() {
        TestCase.assertNotNull(EmailValidator.checkEmail("user@user.com"))
    }

    @Test
    fun emailValidator_ArrayEmailEquals_ReturnsTrue() {
        Assert.assertArrayEquals(
            arrayOf("test@test.ru", "user@user.com"), EmailValidator.arrayOfEmail(
                arrayOf("test@test.ru", "user@user.com")
            )
        )
    }

    @Test
    fun emailValidator_EmailSame_ReturnsTrue() {
        val a = "user@user.com"
        val b = EmailValidator.arrayOfEmail(
            arrayOf("test@test.ru", "user@user.com")
        )
        TestCase.assertSame(a, b[1])
    }

    @Test
    fun emailValidator_ArrayEmailSame_ReturnsTrue() {
        val a = arrayOf("test@test.ru", "user@user.com")
        val b = EmailValidator.arrayOfEmail(a)
        TestCase.assertSame(a, b)
    }
}