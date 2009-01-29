//  Copyright 2009 Jason Aaron Osgood, Jean-Francois Poilpret
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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class SyncLayoutInvocationHandler implements InvocationHandler
{
	SyncLayoutInvocationHandler(SyncLayoutEngine sync, ILayoutEngine delegate)
	{
		_delegate = delegate;
		_sync = sync;
	}
	
	//CSOFF: IllegalThrowsCheck
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		_sync.setCurrentDelegate(_delegate);
		return method.invoke(_sync, args);
	}
	//CSON: IllegalThrowsCheck

	private final SyncLayoutEngine _sync;
	private final ILayoutEngine _delegate;
}
