fun main(){
    testSudokuGameValidator(
        testName = "when the board is empty then return false",
        result = isValidSudokuGame(emptyArray()),
        correctResult = false
    )

    testSudokuGameValidator(
        testName = "when the board full of empty cells and does not contain 17 numbers at least to solve the game then return false",
        result = isValidSudokuGame(
            arrayOf(
                charArrayOf('-', '-', '-', '-', '-', '-', '-', '-', '-') ,
                charArrayOf('1', '-', '-', '-', '-', '-', '-', '-', '-') ,
                charArrayOf('-', '-', '-', '-', '-', '-', '-', '-', '-') ,
                charArrayOf('-', '-', '-', '-', '-', '-', '-', '-', '-') ,
                charArrayOf('-', '-', '-', '-', '-', '-', '-', '-', '-') ,
                charArrayOf('-', '-', '-', '-', '-', '-', '-', '-', '-') ,
                charArrayOf('-', '-', '-', '-', '-', '-', '-', '-', '-') ,
                charArrayOf('-', '-', '-', '-', '-', '-', '-', '-', '-') ,
                charArrayOf('-', '-', '-', '-', '-', '-', '-', '-', '2') ,
            )
        ),
        correctResult = false
    )

    testSudokuGameValidator(
        testName = "when the number is duplicated in the same row/column then return false",
        result = isValidSudokuGame(
            arrayOf(
                charArrayOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
                charArrayOf('6', '-', '-', '1', '9', '9', '-', '-', '-'), // number 9 duplicated in the 2 row and 6 column
                charArrayOf('0', '9', '8', '-', '-', '-', '-', '6', '-'),
                charArrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                charArrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                charArrayOf('7', '6', '-', '-', '2', '-', '-', '-', '6'),
                charArrayOf('-', '-', '-', '-', '-', '-', '2', '8', '-'),
                charArrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
                charArrayOf('-', '-', '-', '-', '-', '-', '-', '7', '9'),
            )
        ),
        correctResult = false
    )

    testSudokuGameValidator(
        testName = "when the number is duplicated in the subgrid(3×3) then return false",
        result = isValidSudokuGame(
            arrayOf(
                charArrayOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
                charArrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                charArrayOf('3', '9', '8', '-', '-', '-', '-', '6', '-'), // the number 3 duplicated in the subgrid
                charArrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                charArrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                charArrayOf('7', '6', '-', '-', '2', '-', '-', '-', '6'),
                charArrayOf('-', '-', '-', '-', '-', '-', '2', '8', '-'),
                charArrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
                charArrayOf('-', '-', '-', '-', '-', '-', '-', '7', '9'),
            )
        ),
        correctResult = false
    )

    testSudokuGameValidator(
        testName = "when the numbers outside the range 1 to 9 then return false",
        result = isValidSudokuGame(
            arrayOf(
                charArrayOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
                charArrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                charArrayOf('0', '9', '8', '-', '-', '-', '-', '6', '-'),
                charArrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                charArrayOf('4', '-', '-', '8', '-', '0', '-', '-', '1'), // the cell (5,6) its zero (outside the range)
                charArrayOf('7', '6', '-', '-', '2', '-', '-', '-', '6'),
                charArrayOf('-', '-', '-', '-', '-', '-', '2', '8', '-'),
                charArrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
                charArrayOf('-', '-', '-', '-', '-', '-', '-', '7', '9'),
            )
        ),
        correctResult = false
    )

    testSudokuGameValidator(
        testName = "when the board contains any character or symbol other than numbers then return false",
        result = isValidSudokuGame(
            arrayOf(
                charArrayOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
                charArrayOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                charArrayOf('0', '9', '8', '-', '*', '-', '-', '6', '-'), // the cell(3,5) contains * char
                charArrayOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                charArrayOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                charArrayOf('7', '6', '-', '-', '2', '-', '-', '-', '6'),
                charArrayOf('-', '-', '-', '-', '-', '-', '2', '8', '-'),
                charArrayOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
                charArrayOf('-', '-', '$', '-', '-', '-', '-', '7', '9'), //the cell(9,3) contains $ char
            )
        ),
        correctResult = false
    )

    testSudokuGameValidator(
        testName = "when the count of column/row does not match each other then return false",
        result = isValidSudokuGame(
            arrayOf(
                charArrayOf('5', '3', '-', '-', '7', '-', '-'),
                charArrayOf('6', '-', '-', '1', '9', '5', '-'),
                charArrayOf('0', '9', '8', '-', '-', '-', '-'),
                charArrayOf('8', '-', '-', '-', '6', '-', '-'),
                charArrayOf('4', '-', '-', '8', '-', '3', '-'),
                charArrayOf('7', '6', '-', '-', '2', '-', '-'),
                charArrayOf('-', '-', '-', '-', '-', '-', '2'),
                charArrayOf('-', '-', '-', '4', '1', '9', '-'), // the board is 8*7

            )
        ),
        correctResult = false
    )



}

fun testSudokuGameValidator(testName: String, result: Boolean , correctResult: Boolean){
    if(result == correctResult){
        println("Success - $testName")
    }else {
        println("Failed - $testName")
    }
}