//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

}

const val SIZE = 9
const val SUBGRID = 3

// Arrays to track used numbers
lateinit var rowUsed: Array<BooleanArray>
lateinit var colUsed: Array<BooleanArray>
lateinit var boxUsed: Array<BooleanArray>
lateinit var board: Array<CharArray>

// Main function to check and solve the sudoku game
fun isValidSudokuGame(sudokuArray: Array<CharArray>): Boolean {
    // Check if the board is empty or any of its cells is empty
    if (sudokuArray.isEmpty() || sudokuArray.any { it.isEmpty() }) {
        return false // Return false if the board is empty
    }

    // Count the number of filled cells by iterating through the 2D array
    val filledCells = sudokuArray.sumOf { row -> row.count { it != '-' } }

    // If there are fewer than 17 numbers, return false (not enough to solve the Sudoku)
    if (filledCells < 17) {
        return false
    }

    // Check if the board is not a 9x9 grid or the count of column/row does not match each other
    if (sudokuArray.size != 9 || sudokuArray.any { it.size != 9 }) {
        return false // If the board size is not 9x9, return false
    }

    // Initialize board and tracking arrays
    board = sudokuArray
    rowUsed = Array(SIZE) { BooleanArray(SIZE) }  // Array to track used numbers in rows
    colUsed = Array(SIZE) { BooleanArray(SIZE) }  // Array to track used numbers in columns
    boxUsed = Array(SIZE) { BooleanArray(SIZE) }  // Array to track used numbers in subgrids

    // Check validity and mark used digits
    for (row in 0 until SIZE) {          // Loop through each row
        for (col in 0 until SIZE) {      // Loop through each column
            val ch = board[row][col]      // Get the current character in the cell
            if (ch != '-' && ch in '1'..'9') {  // If the cell is not empty and contains a valid number
                val num = ch.digitToInt() - 1    // Convert the character to an integer (0-8)
                val subgridIndex = getSubgridIndex(row, col)


                // Check if the number is already used in the same row, column, or subgrid
                if (rowUsed[row][num] || colUsed[col][num] || boxUsed[subgridIndex][num]) {
                    return false  // If the number is already used, return false (invalid board)
                }

                // Mark the number as used in the row, column, and subgrid
                rowUsed[row][num] = true
                colUsed[col][num] = true
                boxUsed[subgridIndex][num] = true
            }
        }
    }

    // Try solving the Sudoku with backtracking
    return backtrack(0, 0)  // Start solving from the first cell (0, 0)
}

// Check if it's valid to place a number in a specific cell
fun isValidCell(row: Int, col: Int, num: Int): Boolean {
    val subgridIndex = getSubgridIndex(row, col)
    // Return true if the number is not used in the row, column, or subgrid
    return !rowUsed[row][num] && !colUsed[col][num] && !boxUsed[subgridIndex][num]
}

// Mark or unmark a number as used in the row, column, and subgrid
fun markUsed(row: Int, col: Int, num: Int, used: Boolean) {
    val subgridIndex = getSubgridIndex(row, col)
    rowUsed[row][num] = used  // Mark the number as used or unused in the row
    colUsed[col][num] = used  // Mark the number as used or unused in the column
    boxUsed[subgridIndex][num] = used  // Mark the number as used or unused in the subgrid
}

// Backtracking Algorithm with early pruning
fun backtrack(row: Int, col: Int): Boolean {
    if (row == SIZE) return true  // If we've filled all rows, we've successfully solved the Sudoku

    // Calculate the next row and column (moving to the next cell)
    val nextRow = if (col == SIZE - 1) row + 1 else row
    val nextCol = if (col == SIZE - 1) 0 else col + 1

    // If the current cell is already filled (not empty), move to the next cell
    if (board[row][col] != '-') {
        return backtrack(nextRow, nextCol)
    }

    // Try placing each number (from 0 to 8, which represents 1-9)
    for (num in 0 until SIZE) {
        if (isValidCell(row, col, num)) {  // If the number is valid for this cell
            board[row][col] = (num + 1).digitToChar()  // Place the number in the cell
            markUsed(row, col, num, true)  // Mark the number as used

            // Recursively try to solve the next cell
            if (backtrack(nextRow, nextCol)) return true  // If successful, return true

            // Backtrack: undo the previous step if it didn't lead to a solution
            board[row][col] = '-'  // Empty the cell
            markUsed(row, col, num, false)  // Unmark the number as used
        }
    }

    return false  // If no valid number can be placed, return false (dead end)
}

/**
 * Calculate the subgrid index based on the row and column
 * This formula is used to map a (row, col) pair into the appropriate subgrid (0-8)
 * Example: For a 9x9 Sudoku, the grid is divided into 9 subgrid (3x3)
 * For (row=4, col=5), the subgridIndex is calculated as follows:
 * (row / 3) = 1 and (col / 3) = 1, so (1 * 3 + 1) = 4
 * This means the cell (4, 5) is in the subgrid with index 4 (top middle subgrid)
 */
fun getSubgridIndex(row: Int, col: Int): Int {
    return (row / SUBGRID) * SUBGRID + (col / SUBGRID)
}

// Main function to check IPv4 Validation
fun isValidIPv4Address(ip:String) : Boolean{
    //split the address in to segments using dot character
    val segments = ip.split(".")

    // ensure the address consist of 4 segments
    if (segments.size != 4) {
        return false
    }

    for (segment in segments) {
        //ensure that this given IPv4 is not empty
        if (segment.isEmpty()) {
            return false
        }

        // ensure that the segment contains only numbers
        if (!segment.all { it.isDigit() }) {
            return false
        }

        // convert the segment in to number to ensure that the number in the range of 0 to 255 and does not begin with zero
        val number = segment.toInt()

        if (number < 0 || number > 255) {
            return false
        }

        // ensure that the segment does not begin with zero
        if (segment != number.toString()) {
            return false
        }
    }

    return true
}





