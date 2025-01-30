package org.fossify.calculator.helpers.parsing

import org.fossify.calculator.helpers.TokenType

abstract class Expression {
//    abstract override fun toString(): String
    abstract fun calculate(): Double
    abstract fun fetchOperator(): TokenType?
}
