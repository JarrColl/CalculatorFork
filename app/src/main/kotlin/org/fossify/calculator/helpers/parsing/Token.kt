package org.fossify.calculator.helpers.parsing

import org.fossify.calculator.helpers.TokenType

data class Token(val tokenType: TokenType, val literal: Double?) {
}
