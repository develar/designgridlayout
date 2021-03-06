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

// Issue 25: multiple calls to pack() clears the effect of emptyRow()
public class Bug25InoperantEmptyRowIfPackTwice extends AbstractDesignGridExample
{
	public static void main(String[] args)
	{
		Bug25InoperantEmptyRowIfPackTwice example = new Bug25InoperantEmptyRowIfPackTwice();
		example.go(true);
	}

	@Override public void build(DesignGridLayout layout)
	{
		layout.row().grid().add(button(), button());
		layout.emptyRow();
		layout.row().grid().add(button(), button());
	}

	@Override protected void prePack()
	{
		_frame.pack();
	}
}
