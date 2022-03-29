package me.pxq.asplugin.pocket.datasource

import com.intellij.openapi.application.ApplicationManager
import me.pxq.asplugin.pocket.model.Card
import me.pxq.asplugin.pocket.model.CardWrapper

object PocketDatasource {

    private val cardWrapper: CardWrapper by lazy {
        ApplicationManager.getApplication().getService(PocketProvider::class.java).cardWrapper
    }

    fun loadCards() = cardWrapper.cards

    fun addCard(card: Card) {
        cardWrapper.cards.add(card)
    }

}