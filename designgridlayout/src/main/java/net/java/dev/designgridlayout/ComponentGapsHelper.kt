package net.java.dev.designgridlayout

import java.awt.Container
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.LayoutStyle
import javax.swing.LayoutStyle.ComponentPlacement
import javax.swing.SwingConstants

internal class ComponentGapsHelper(private val style: LayoutStyle = LayoutStyle.getInstance()) {
  val horizontalIndent by lazy {
    val label1 = JLabel("Top label")
    val label2 = JLabel("Bottom label")
    style.getPreferredGap(label1, label2, ComponentPlacement.INDENT, SwingConstants.SOUTH, null)
  }

  fun getVerticalGap(component1: JComponent, component2: JComponent, type: ComponentPlacement, parent: Container): Int {
    return style.getPreferredGap(component1, component2, type, SwingConstants.SOUTH, parent)
  }

  fun getHorizontalGap(component1: JComponent, component2: JComponent, type: ComponentPlacement, parent: Container): Int {
    return style.getPreferredGap(component1, component2, type, SwingConstants.EAST, parent)
  }

  fun getNorthContainerGap(component: JComponent, parent: Container): Int {
    return style.getContainerGap(component, SwingConstants.NORTH, parent)
  }

  fun getSouthContainerGap(component: JComponent, parent: Container): Int {
    return style.getContainerGap(component, SwingConstants.SOUTH, parent)
  }

  fun getWestContainerGap(component: JComponent, parent: Container): Int {
    return style.getContainerGap(component, SwingConstants.WEST, parent)
  }

  fun getEastContainerGap(component: JComponent, parent: Container): Int {
    return style.getContainerGap(component, SwingConstants.EAST, parent)
  }
}
