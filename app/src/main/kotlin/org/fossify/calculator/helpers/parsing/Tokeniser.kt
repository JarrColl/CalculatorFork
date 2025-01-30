package org.fossify.calculator.helpers.parsing

import org.fossify.calculator.helpers.TokenType

//TODO: handle the alternate variant of decimal = , instead of .
class Tokeniser {
    private var start = 0;
    private var current = 0;
    private var source: String = "";
    private var tokens: List<Token> = emptyList();

    fun tokenise(lSrc: String): List<Token> {
        resetTokeniser()
        source = lSrc;

        while (!isAtEnd()) {
            scanToken()
        }
        tokens += Token(TokenType.NULL, null)
        return tokens
    }

    private fun resetTokeniser() {
        start = 0
        current = 0
        tokens = emptyList()

    }

    private fun scanToken() {
        val c: Char = advance()

        when (c) {
            in '0'..'9' -> consumeNumber()
            '+' -> addToken(TokenType.PLUS)
            '-' -> addToken(TokenType.MINUS)
            '×' -> addToken(TokenType.MULTIPLY)
            '÷' -> addToken(TokenType.DIVIDE)
            '^' -> addToken(TokenType.POWER)
            '%' -> addToken(TokenType.PERCENT)
            '√' -> addToken(TokenType.ROOT)
            else -> throw Exception("Unknown Lexeme Found")
        }

    }

    private fun addToken(tokenType: TokenType) {
        addTokenWithLiteral(tokenType, null)
    }

    private fun addTokenWithLiteral(tokenType: TokenType, literal: Double?) {
        tokens += Token(tokenType, literal)
    }

    private fun consumeNumber() {
        start = current - 1

        while (peekCurrent()?.isDigit() == true) {
            advance()
        }

        if (peekCurrent() == '.' && peekNext()?.isDigit() == true) {
            advance() // consume the '.'
            while (peekCurrent()?.isDigit() == true) {
                advance()
            }
        }

        addTokenWithLiteral(TokenType.DIGIT, source.substring(start, current).toDouble())
    }

    private fun peekCurrent(): Char? {
        if (isAtEnd()) {
            return null
        }
        return source[current]
    }

    private fun peekNext(): Char? {
        if (current + 1 < source.length) {
            return source[current + 1]
        }
        return null;
    }

    private fun advance(): Char {
//        if (!isAtEnd()) {
        current++
        return source[current - 1]
//        }
//        return null;
    }


    private fun isAtEnd(): Boolean {
        if (current == source.length) {
            return true
        }
        return false
    }

}
