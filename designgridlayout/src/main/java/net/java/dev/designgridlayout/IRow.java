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

package net.java.dev.designgridlayout;

import javax.swing.*;

/**
 * Any row created by {@link DesignGridLayout} implements this minimal
 * interface. Through this interface you can add components to the row.
 * <p/>
 * Subsequent calls to methods that add components result in adding components
 * left to right, i.e. the last added component is positioned to the right of
 * the previously last added component.
 * <p/>
 * Note that {@code DesignGridLayout} methods will return more specific
 * interfaces (that extend {@code IRow}).
 * 
 * @author Jean-Francois Poilpret
 */
public interface IRow extends IHideable
{
	/**
	 * Adds components to this row; each component has its own "column" in the
	 * row. Components are added left to right, in the same order as they appear
	 * in the arguments list.
	 * 
	 * @param children components to add to this row
	 * @return {@code this} row (to allow chaining other methods for the current 
	 * row)
	 */
        IRow add(JComponent... children);

        /**
	 * Add one indentation space (size is platform-dependent) before the left-most
	 * component of the row.
	 * <p/>
	 * <b>IMPORTANT!</b> For grid rows, indentation is visible only when the
	 * label column uses {@link LabelAlignment#LEFT left alignment} (see 
	 * {@link DesignGridLayout#labelAlignment}).
	 * 
	 * @return {@code this} row (to allow chaining other methods for the current 
	 * row)
	 */
        IRow indent();
	
	/**
	 * Add some indentation space (size is platform-dependent) before the left-most
	 * component of the row. To obtain visually correct layouts, you should ensure
	 * that, if you use {@code n > 1} for the current row, there is another row,
	 * above the current one, which is indented with a level of {@code n - 1}.
	 * <p/>
	 * If this method is called several times for the same row, only the last call
	 * takes effect.
	 * <p/>
	 * <b>IMPORTANT!</b> For grid rows, indentation is visible only when the
	 * label column uses {@link LabelAlignment#LEFT left alignment} (see 
	 * {@link DesignGridLayout#labelAlignment}).
	 * 
	 * @param n the number of indentation levels required; has no effect if {@code n < 0}.
	 * @return {@code this} row (to allow chaining other methods for the current 
	 * row)
	 */
        IRow indent(int n);
}
