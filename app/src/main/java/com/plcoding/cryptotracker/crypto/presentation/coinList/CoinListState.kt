package com.plcoding.cryptotracker.crypto.presentation.coinList

import androidx.compose.runtime.Immutable
import com.plcoding.cryptotracker.crypto.presentation.models.CryptoCoinModel

@Immutable
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CryptoCoinModel> = emptyList(),
    val selectedCoin: CryptoCoinModel? = null,
)
