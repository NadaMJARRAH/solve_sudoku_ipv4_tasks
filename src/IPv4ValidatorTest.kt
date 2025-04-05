fun main(){
    testIPv4AddressValidator(
        testName = "when IPv4 address achieves all the conditions then return true",
        result = isValidIPv4Address("192.158.1.1"),
        correctResult = true
    )

    testIPv4AddressValidator(
        testName = "when IPv4 address contains more than 4 segments and 3 dots '.' then return false",
        result = isValidIPv4Address("190.158.8.1.9"),
        correctResult = false
    )

    testIPv4AddressValidator(
        testName = "when IPv4 address contains less than 4 segments and 3 dots '.' then return false",
        result = isValidIPv4Address("190.158.8"),
        correctResult = false
    )

    testIPv4AddressValidator(
        testName = "when IPv4 address contains numbers outside of the range 0 to 255  then return false",
        result = isValidIPv4Address("256.200.300.190"),
        correctResult = false
    )

    testIPv4AddressValidator(
        testName = "when IPv4 address contains negative numbers then return false",
        result = isValidIPv4Address("-1.100.100.100"),
        correctResult = false
    )

    testIPv4AddressValidator(
        testName = "when IPv4 address starts or ends with dots '.' then return false",
        result = isValidIPv4Address(".192.168.1.9."),
        correctResult = false
    )

    testIPv4AddressValidator(
        testName = "when IPv4 address is empty then return false",
        result = isValidIPv4Address(""),
        correctResult = false
    )

    testIPv4AddressValidator(
        testName = "when IPv4 address contains empty segment return false",
        result = isValidIPv4Address("170.145..1"),
        correctResult = false
    )

    testIPv4AddressValidator(
        testName = "when IPv4 address segment has more than 3 numbers then return false",
        result = isValidIPv4Address("170.168.0.123456789"),
        correctResult = false
    )

    testIPv4AddressValidator(
        testName = "when IPv4 address contains special character or symbol then return false",
        result = isValidIPv4Address("170.%.168.two"),
        correctResult = false
    )

    testIPv4AddressValidator(
        testName = "when IPv4 address segment begins with zero then return false",
        result = isValidIPv4Address("9.130.05.009"),
        correctResult = false
    )

    testIPv4AddressValidator(
        testName = "when IPv4 address segments separated with any character or symbol other than dot '.' then return false",
        result = isValidIPv4Address("6*187,8>19"),
        correctResult = false
    )
}

fun testIPv4AddressValidator(testName: String, result: Boolean , correctResult: Boolean){
    if(result == correctResult){
        println("Success - $testName")
    }else {
        println("Failed - $testName")
    }
}