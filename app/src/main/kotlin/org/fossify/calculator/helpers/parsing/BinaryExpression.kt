package org.fossify.calculator.helpers.parsing

import org.fossify.calculator.helpers.TokenType
import kotlin.math.pow
import kotlin.math.sqrt

class BinaryExpression(val left: Expression, val operator: TokenType, val right: Expression): Expression() {
    override fun calculate(): Double {
        val leftDouble = left.calculate()
        val rightDouble = right.calculate()

        return when(operator) {
            TokenType.PLUS -> leftDouble + rightDouble
            TokenType.MINUS -> leftDouble - rightDouble
            TokenType.MULTIPLY -> leftDouble * rightDouble
            TokenType.DIVIDE -> leftDouble / rightDouble
            TokenType.POWER ->  leftDouble.pow(rightDouble)
            TokenType.ROOT -> leftDouble * sqrt(rightDouble)
            TokenType.PLUS_PERCENT -> leftDouble + leftDouble*rightDouble
            TokenType.MINUS_PERCENT -> leftDouble - leftDouble*rightDouble
            else -> throw Exception("Unexpected Binary Operand")
        }
    }

    override fun fetchOperator(): TokenType? {
        return operator
    }
}
