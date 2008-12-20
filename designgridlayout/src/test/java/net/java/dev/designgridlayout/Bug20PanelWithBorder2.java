//  Copyright 2008 Jason Aaron Osgood, Jean-Francois Poilpret
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

public class Bug20PanelWithBorder2 extends AbstractBaseExample
{
	public static void main(String[] args)
	{
		Bug20PanelWithBorder2 example = new Bug20PanelWithBorder2();
		example.go(true);
	}

	@Override public void build(DesignGridLayout layout)
	{
		layout.row().grid(label("First Label"))	.add(field("field1"), field("field2"), field("field3"));
		layout.row().grid(label("Second Label")).add(field("field1"), field("field2"), field("field3"));
		layout.row().grid(label("Third Label"))	.add(field("field1"), field("field2"), field("field3"));
		layout.row().center().add(button());
	}
}