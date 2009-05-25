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

package net.java.dev.designgridlayout.internal.util;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import net.java.dev.designgridlayout.internal.row.AbstractRow;

public final class RowHelper
{
	private RowHelper()
	{
	}
	
	static public void forEachConsecutive(List<AbstractRow> rows, RowPairWorker worker)
	{
		AbstractRow current = null;
		for (AbstractRow next: each(rows))
		{
			if (current != null)
			{
				worker.perform(current, next);
			}
			current = next;
		}
	}
	
	static public interface RowPairWorker
	{
		public void perform(AbstractRow current, AbstractRow next);
	}
	
	static public Iterable<AbstractRow> each(final List<AbstractRow> rows)
	{
		return new Iterable<AbstractRow>()
		{
			public Iterator<AbstractRow> iterator()
			{
				return new RowIterator(rows, false);
			}
		};
	}

	static public Iterable<AbstractRow> eachButLast(final List<AbstractRow> rows)
	{
		return new Iterable<AbstractRow>()
		{
			public Iterator<AbstractRow> iterator()
			{
				return new RowIterator(rows, true);
			}
		};
	}
	
	static final private class RowIterator implements Iterator<AbstractRow>
	{
		private RowIterator(List<AbstractRow> rows, boolean excludeLast)
		{
			_rows = (excludeLast ? allButLast(rows) : rows);
		}
		
		static private List<AbstractRow> allButLast(List<AbstractRow> rows)
		{
			// Reduce the list by removing the last non-empty row
			ListIterator<AbstractRow> iter = rows.listIterator(rows.size());
			while (iter.hasPrevious())
			{
				AbstractRow last = iter.previous();
				if (!last.isEmpty())
				{
					return rows.subList(0, iter.previousIndex());
				}
			}
			return Collections.emptyList();
		}
	
		public AbstractRow next()
		{
			int index = findNext();
			if (index != -1)
			{
				_index = index + 1;
				return _rows.get(index);
			}
			else
			{
				throw new NoSuchElementException();
			}
		}
	
		public boolean hasNext()
		{
			return findNext() != -1;
		}
	
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	
		private int findNext()
		{
			for (int i = _index; i < _rows.size(); i++)
			{
				AbstractRow row = _rows.get(i);
				if (!row.isEmpty())
				{
					return i;
				}
			}
			return -1;
		}
	
		private final List<AbstractRow> _rows;
		private int _index = 0;
	}
}