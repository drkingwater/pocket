package me.pxq.asplugin.pocket.datasource

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil
import me.pxq.asplugin.pocket.model.CardWrapper
import me.pxq.asplugin.pocket.utils.Log

@State(name = "PocketProvider", storages = [Storage("pxq_pocket.xml")])
class PocketProvider : PersistentStateComponent<CardWrapper> {

    var cardWrapper = CardWrapper()

    override fun getState(): CardWrapper {
        Log.i("getState")
        return cardWrapper
    }

    override fun loadState(state: CardWrapper) {
        Log.i("loadState")
        cardWrapper = state
    }
}