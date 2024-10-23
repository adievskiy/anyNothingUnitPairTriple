fun main() {
    val testString1 = "{([])}"
    val testString2 = "{([))}"
    val testString3 = "{{[])}"

    println(isValidBrackets(testString1))
    println(isValidBrackets(testString2))
    println(isValidBrackets(testString3))

    val array = intArrayOf(1,2,3)
    permutations(array.toList())
}

fun isValidBrackets(s: String): Boolean {
    val stack = mutableListOf<Char>()
    val bracketsMap = mutableMapOf('(' to ')', '{' to '}', '[' to ']')

    for (char in s) {
        if (bracketsMap.keys.contains(char)) {
            stack.add(char)
        } else if (bracketsMap.values.contains(char)) {
            if (stack.isEmpty() || bracketsMap[stack.removeAt(stack.lastIndex)] != char) {
                return false
            }
        }
    }
    return stack.isEmpty()
}

fun <T> permutations(array: List<T>, prefix: List<T> = emptyList()) {
    if (array.isEmpty()) {
        println(prefix)
    } else {
        for (i in array.indices) {
            val remaining = array.take(i) + array.drop(i + 1)
            permutations(remaining, prefix + array[i])
        }
    }
}