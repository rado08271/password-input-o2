package sk.o2.android.figura.rado.assignement.password.util

class PasswordLengthError: Error("Password is too short")
class PasswordNoUppercaseError: Error("Password must include at least one uppercase character")
class PasswordNoNumberError: Error("Password must include at least one number")
class PasswordNoSpecialCharacterError: Error("Password must include at least one special character '? = # / %'")

class EmailFormatIsNotValid: Error("Email format is not valid 'email@email.com'")

@Throws(
    PasswordNoSpecialCharacterError::class, PasswordNoNumberError::class, PasswordLengthError::class, PasswordNoUppercaseError::class
)
fun passwordValidator (password: String): Boolean  {
    if (password.length < 8) {
        throw PasswordLengthError()
    }

    if (!password.contains(Regex("[A-Z]"))) {
        throw PasswordNoUppercaseError()
    }

    if (!password.contains(Regex("[0-9]"))) {
        throw PasswordNoNumberError()
    }

    if (!password.contains(Regex("[?=#/%]"))) {
        throw PasswordNoSpecialCharacterError()
    }

    return true
}

@Throws(
    EmailFormatIsNotValid::class
)
fun emailValidator (email: String): Boolean {
    if (!email.matches(Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$"))) {
        throw EmailFormatIsNotValid()
    }

    return true
}