//  Copyright 2005-2013 Jason Aaron Osgood, Jean-Francois Poilpret
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

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
