package org.fossify.calculator.helpers

enum class TokenType {
    NULL,
    DIGIT,
    EQUALS,
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE,
    PERCENT,
    POWER,
    ROOT,
    DECIMAL,
    CLEAR,
    // Additional Non-token, Parser operator types
    PLUS_PERCENT,
    MINUS_PERCENT,
}
//const val Operations.EQUALS: Int = "equals"
//const val Operations.PLUS: Int = "plus"
//const val MINUS = "minus"
//const val MULTIPLY = "multiply"
//const val DIVIDE = "divide"
//const val PERCENT = "percent"
//const val POWER = "power"
//const val ROOT = "root"
//const val DECIMAL = "decimal"
//const val CLEAR = "clear"
//const val RESET = "reset"
//
//const val NAN = "NaN"
//const val ZERO = "zero"
//const val ONE = "one"
//const val TWO = "two"
//const val THREE = "three"
//const val FOUR = "four"
//const val FIVE = "five"
//const val SIX = "six"
//const val SEVEN = "seven"
//const val EIGHT = "eight"
//const val NINE = "nine"

const val DOT = "."
const val COMMA = ","

// shared prefs
const val USE_COMMA_AS_DECIMAL_MARK = "use_comma_as_decimal_mark"
const val CONVERTER_UNITS_PREFIX = "converter_last_units"

// calculator state
const val RES = "res"
const val PREVIOUS_CALCULATION = "previousCalculation"
const val LAST_KEY = "lastKey"
const val LAST_OPERATION = "lastOperation"
const val BASE_VALUE = "baseValue"
const val SECOND_VALUE = "secondValue"
const val INPUT_DISPLAYED_FORMULA = "inputDisplayedFormula"
const val CALCULATOR_STATE = "calculatorState"

// converter state
const val TOP_UNIT = "top_unit"
const val BOTTOM_UNIT = "bottom_unit"
const val CONVERTER_VALUE = "converter_value"
const val CONVERTER_STATE = "converter_state"
