package org.fossify.calculator.helpers.parsing

import org.fossify.calculator.helpers.TokenType

class LiteralExpression(val value: Double): Expression() {
    override fun calculate(): Double {
        return value
    }

    override fun fetchOperator(): TokenType? {
        return null
    }
}
