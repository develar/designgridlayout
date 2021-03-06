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

public class Basics1SimpleGrid extends AbstractDesignGridExample
{
	public static void main(String[] args)
	{
		Basics1SimpleGrid example = new Basics1SimpleGrid();
		example.go(true);
	}

	@Override public void build(DesignGridLayout layout)
	{
		// You can add components one line at a time
		IRow row = layout.row().grid();
		row.add(button());
		row.add(button());

		// Or using method chaining
		layout.row().grid().add(button()).add(button());

		// Or, even better, using variable arguments
		layout.row().grid().add(button(), button());
	}
}
