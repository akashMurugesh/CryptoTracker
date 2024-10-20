package com.plcoding.cryptotracker.crypto.presentation.models

import androidx.annotation.DrawableRes
import com.plcoding.cryptotracker.crypto.domain.CryptoCoin
import com.plcoding.cryptotracker.core.presentation.util.getDrawableIdForCoin
import java.text.NumberFormat
import java.util.Locale

data class CryptoCoinModel(
    val id: String,
    val rank: Int,
    val name: String,
    @DrawableRes val iconRes: Int,
    val symbol: String,
    val marketCapUsd: DisplayableNumber,
    val priceUsd: DisplayableNumber,
    val changPercent24Hr: DisplayableNumber,
)

data class DisplayableNumber(
    val value: Double,
    val formatted: String,
)

fun CryptoCoin.toCryptoCoinModel(): CryptoCoinModel {
    return CryptoCoinModel(
        id = id,
        rank = rank,
        name = name,
        iconRes = getDrawableIdForCoin(symbol),
        symbol = symbol,
        marketCapUsd = marketCapUsd.toDisplayableNumber(),
        priceUsd = priceUsd.toDisplayableNumber(),
        changPercent24Hr = changePercent24Hr.toDisplayableNumber(),
    )
}

fun Double.toDisplayableNumber(): DisplayableNumber {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }
    return DisplayableNumber(
        value = this,
        formatted = formatter.format(this)
    )
}
