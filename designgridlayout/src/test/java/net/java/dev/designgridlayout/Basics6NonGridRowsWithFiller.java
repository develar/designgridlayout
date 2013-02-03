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

import javax.swing.JSeparator;

public class Basics6NonGridRowsWithFiller extends AbstractDesignGridExample
{
	public static void main(String[] args)
	{
		Basics6NonGridRowsWithFiller example = new Basics6NonGridRowsWithFiller();
		example.go(true);
	}

	@Override public void build(DesignGridLayout layout)
	{
		layout.row().left().fill().add(new JSeparator());
		layout.row().left().fill().add(label("Hello"), new JSeparator());
		layout.row().center().fill().add(new JSeparator());
		layout.row().center().fill().add(new JSeparator(), label("Hello"), new JSeparator());
		layout.row().right().fill().add(new JSeparator());
		layout.row().right().fill().add(new JSeparator(), label("Hello"));
	}
}
