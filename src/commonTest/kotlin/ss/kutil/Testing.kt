package ss.kutil

import kotlin.reflect.KClass
import kotlin.test.fail

fun <T : Exception> assThrows(block: () -> Unit) {
    val errorMessageFunction: () -> String = { "Expected to throw exception" }
    try {
        block()
        fail(errorMessageFunction())
    } catch (e: Throwable) {
        //ok
    }
}

fun <T : Exception> assThrows(expectedExceptionType: KClass<T>, block: () -> Unit) {
    val errorMessageFunction: () -> String =
        { "Expected to throws exception of type: ${expectedExceptionType.qualifiedName}" }
    try {
        block()
        fail(errorMessageFunction())
    } catch (e: Throwable) {
        val actual = e::class
        if (actual != expectedExceptionType) {
            fail(errorMessageFunction())
        }
    }
}

fun <T : Exception> assThrows(expectedExceptionType: KClass<T>, expectedExceptionMessage: String, block: () -> Unit) {
    val m1: () -> String = { "Expected to throw exception of type[${expectedExceptionType.qualifiedName}]" }
    val m2: () -> String = { "Expected to throw exception  with message[$expectedExceptionMessage]" }
    try {
        block()
        fail(m1())
    } catch (e: Throwable) {
        val actualExceptionType = e::class
        if (actualExceptionType != expectedExceptionType) {
            fail(m1())
        }
        val actualMessage = e.message
        if (actualMessage != expectedExceptionMessage) {
            fail(m2())
        }
    }
}