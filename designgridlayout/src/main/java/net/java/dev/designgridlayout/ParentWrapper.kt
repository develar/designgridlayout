package net.java.dev.designgridlayout

import java.awt.Component
import java.awt.Container

import javax.swing.JComponent

internal class ParentWrapper<out T : Container>(val parent: T) {
  private var addChild = false

  fun checkParent(parent: Container) {
    if (parent !== parent) {
      throw IllegalArgumentException("Must use layout instance with original parent container")
    }
  }

  fun add(child: Component) {
    try {
      addChild = true
      parent.add(child)
    }
    finally {
      addChild = false
    }
  }

  fun checkAddedComponent(component: JComponent) {
    var parent: Container? = component
    while (parent != null) {
      if (parent === this.parent) {
        throw IllegalArgumentException("Do not add the same component twice")
      }
      parent = parent.parent
    }
  }

  fun checkAdd() {
    if (!addChild) {
      throw IllegalArgumentException("Do not use this method")
    }
  }
}
