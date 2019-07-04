package br.com.android.victorcs.domain.business

import java.io.Serializable
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.*

/**
 * Money transform and setup value to maney object structure.
 * @author victorcs
 */
class Money() : Comparable<Money>, Serializable {

    sealed class Currency(val formatter: NumberFormat) : Serializable {
        class BRL : Currency(NumberFormat.getCurrencyInstance(Locale("pt", "BR")))
        class USD : Currency(DecimalFormat("'US$'#.#######").apply {
            isDecimalSeparatorAlwaysShown = true
            decimalFormatSymbols = DecimalFormatSymbols(Locale.US)
        })
    }

    private var amount = BigDecimal.ZERO
    private var currency: Currency = Currency.BRL()

    init {
        amount = amount.setScale(2, RoundingMode.HALF_UP)
    }

    constructor(value: Double, currency: Currency = Currency.BRL()) : this() {
        amount = BigDecimal(value)
        this.currency = currency
    }

    constructor(value: BigDecimal, currency: Currency = Currency.BRL()) : this() {
        amount = value
        this.currency = currency
    }

    fun prettyPrint() = currency.formatter.format(amount).replace("$", "$ ")

    override fun compareTo(other: Money): Int {
        return amount.compareTo(other.amount)
    }

    fun subtract(otherMoney: Money?): Money {
        otherMoney?.let {
            val newAmount: BigDecimal = amount.subtract(otherMoney.amount)
            return Money(newAmount)
        }
        return this
    }

    fun add(otherMoney: Money?): Money {
        otherMoney?.let {
            val newAmount: BigDecimal = amount.add(otherMoney.amount)
            return Money(newAmount)
        }
        return this
    }

    fun greaterThan(otherMoney: Money): Boolean {
        return compareTo(otherMoney) == 1
    }

    fun lessThan(otherMoney: Money): Boolean {
        return compareTo(otherMoney) == -1
    }

    override fun toString(): String {
        return amount.toDouble().toString()
    }

    fun toDouble(): Double {
        return amount.toDouble()
    }

    fun toFloat(): Float {
        return amount.toFloat()
    }

    fun toInt(): Int {
        return amount.toInt()
    }

    fun toIntRoundUp() = amount.setScale(0, RoundingMode.CEILING).toInt()
    fun toIntRoundDown() = amount.setScale(0, RoundingMode.FLOOR).toInt()

}
