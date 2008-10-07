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

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

//TODO improve to make superclass matches optional
// => will need also adaptation of ClassBasedHeightGrowPolicy and subclasses
class HeightGrowPolicyMapper implements HeightGrowPolicy
{
	public HeightGrowPolicyMapper addPolicy(ClassBasedHeightGrowPolicy policy)
	{
		return addPolicy(policy.getComponentClass(), policy);
	}
	
	public HeightGrowPolicyMapper addPolicy(
		Class<? extends Component> componentClass, HeightGrowPolicy policy)
	{
		_policies.put(componentClass, policy);
		return this;
	}
	
	public boolean canGrowHeight(Component component)
	{
		Class<? extends Component> clazz = component.getClass();
		while (true)
		{
			HeightGrowPolicy policy = _policies.get(component.getClass());
			if (policy != null)
			{
				return policy.canGrowHeight(component);
			}
			if (clazz == Component.class)
			{
				return false;
			}
			clazz = clazz.getSuperclass().asSubclass(Component.class);
		}
	}

	protected final Map<Class<? extends Component>, HeightGrowPolicy> _policies =
		new HashMap<Class<? extends Component>, HeightGrowPolicy>();
}