package org.fossify.calculator.helpers.parsing

import org.fossify.calculator.helpers.TokenType

class UnaryExpression(val operator: TokenType, val right: Expression) : Expression() {
    override fun calculate(): Double {
        return when (operator) {
            TokenType.MINUS -> -right.calculate()
            TokenType.PERCENT -> right.calculate() / 100
            else -> throw Exception("Unexpected Unary Operator")
        }
    }

    override fun fetchOperator(): TokenType? {
        return operator
    }
}
