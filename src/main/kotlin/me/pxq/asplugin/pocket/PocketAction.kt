package me.pxq.asplugin.pocket

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import me.pxq.asplugin.pocket.datasource.PocketDatasource
import me.pxq.asplugin.pocket.model.Card
import me.pxq.asplugin.pocket.ui.PocketDialog
import me.pxq.asplugin.pocket.utils.Log

class PocketAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        Log.i("actionPerformed")
        PocketDatasource.loadCards().forEach {
            Log.i("show $it")
        }
        if (PocketDialog().showAndGet()) {
            PocketDatasource.addCard(Card("futu", "soft.oa"))
        }

    }
}