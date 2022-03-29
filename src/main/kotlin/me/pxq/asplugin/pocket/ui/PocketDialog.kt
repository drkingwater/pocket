package me.pxq.asplugin.pocket.ui

import com.intellij.openapi.ui.DialogWrapper
import javax.swing.JComponent
import javax.swing.JPanel

class PocketDialog:DialogWrapper(true) {

    init {
        init()
        title = "Pocket"
    }

    override fun createCenterPanel(): JComponent {
        return JPanel()
    }
}