package org.fossify.calculator.helpers.parsing

import org.fossify.calculator.helpers.TokenType

/*
1. DIGIT
2. OPERATOR
3. DIGIT

 */

class Parser() {
    private var tokeniser = Tokeniser()
    private var tokens: List<Token> = emptyList()
    private var current = 0

    private fun resetParser() {
        current = 0
    }

    private fun peekCurrent(): Token {
        return tokens[current]
    }

    private fun isAtEnd(): Boolean {
        return peekCurrent().tokenType == TokenType.NULL
    }

    private fun previous(): Token {
        return tokens[current - 1]
    }

    private fun advance(): Token {
        if (!isAtEnd()) {
            current++
        }
        return previous()
    }

    private fun checkTokenType(tokenType: TokenType): Boolean {
        if (isAtEnd()) {
            return false
        }

        return peekCurrent().tokenType == tokenType
    }

    private fun match(vararg tokenTypes: TokenType): Boolean {
        for (tokenType in tokenTypes) {
            if (checkTokenType(tokenType)) {
                return true
            }
        }
        return false
    }

    // TODO: THIS IS YUCKY FIX IT.
    private fun matchAdvance(vararg tokenTypes: TokenType): Boolean {
        if(match(*tokenTypes)) {
            advance()
            return true
        }
        return false
    }

    private fun primary(): Expression {
        if (matchAdvance(TokenType.DIGIT)) {
            return LiteralExpression(previous().literal!!) //TODO: Handle this null case??
        }

        throw Exception("Expected a primary expression") //TODO: Handle this?
    }

    private fun unarySuffix(): Expression {
        val expr = primary()
        if(matchAdvance(TokenType.PERCENT)) {
            return UnaryExpression(previous().tokenType, expr)
        }
        return expr
    }

    private fun unaryPrefix(): Expression {
        if (matchAdvance(TokenType.MINUS)) {
            val operator = previous().tokenType
            val right = primary()
            return UnaryExpression(operator, right)
        }

        return unarySuffix()
    }

    private fun operator(): Expression {
        val expr = unaryPrefix() //TODO: HANDLE expressions like 3% + 20

        if (matchAdvance(TokenType.PLUS, TokenType.MINUS, TokenType.MULTIPLY, TokenType.DIVIDE, TokenType.PERCENT, TokenType.POWER, TokenType.ROOT)) {
            var operator = previous().tokenType
            val right = unaryPrefix()
            if (right.fetchOperator() == TokenType.PERCENT) {
                operator = when(operator) {
                    TokenType.PLUS -> TokenType.PLUS_PERCENT
                    TokenType.MINUS -> TokenType.MINUS_PERCENT
                    else-> operator
                }
            }
            return BinaryExpression(expr, operator, right)
        }
        return expr
    }

    private fun parse(): Expression {
        return operator()
    }

    fun calculate(source: String): Double {
        resetParser()
        tokens = tokeniser.tokenise(source)
        val head = parse()
        return head.calculate()
    }
}
