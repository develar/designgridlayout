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

public class IndentRowsExample6 extends AbstractDesignGridExample
{
	public static void main(String[] args) throws Exception
	{
		IndentRowsExample6 example = new IndentRowsExample6();
		example.go(true);
	}

	@Override public void build(DesignGridLayout layout)
	{
//		layout.labelAlignment(LabelAlignment.LEFT);
		layout.labelAlignment(LabelAlignment.RIGHT);

		layout.row().left().add(label("Out of the canonical grid..."));
		layout.row().grid(label("Label 1:"));
		layout.row().grid(label("Label 2:")).indent(4).add(field("field 2"));
		layout.row().grid(label("Label 3:")).indent(4).add(field("field 3"));
	}
}
