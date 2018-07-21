package com.jwebmp.plugins.jstree;

import com.jwebmp.core.base.html.List;
import com.jwebmp.core.base.html.interfaces.children.ListChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.plugins.jstree.enumerations.JSTreeAttributes;
import com.jwebmp.plugins.jstree.interfaces.IJSTreeList;
import com.jwebmp.plugins.jstree.interfaces.JSTreeChildren;
import com.jwebmp.plugins.jstree.options.JSTreeNodeOptions;

import javax.validation.constraints.NotNull;

public class JSTreeList<J extends JSTreeList<J>>
		extends List<ListChildren, JSTreeAttributes, GlobalEvents, J>
		implements JSTreeChildren, com.jwebmp.plugins.jstree.interfaces.IJSTreeList<J>
{
	public JSTreeList()
	{
		this(null);
	}

	/**
	 * Creates a new JS Tree List to hold nodes
	 */
	public JSTreeList(String rootName)
	{
		super(false);
		setText(rootName);
	}

	/**
	 * Adds a new item to the collection
	 *
	 * @param title
	 * @param options
	 *
	 * @return
	 */
	@Override
	public JSTreeListItem<? extends JSTreeListItem> addItem(String title, JSTreeNodeOptions<?> options)
	{
		JSTreeListItem<?> item = new JSTreeListItem<>();
		item.setText(title);
		if (options != null)
		{
			item.setOptions(options);
			item.addAttribute(JSTreeAttributes.Data_JsTree.toString(), options.toString(true));
		}
		add(item);
		return item;
	}

	/**
	 * Adds a new static root object to the list
	 *
	 * @param root
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J addRoot(JSTreeListItem<?> root)
	{
		add(root);
		return (J) this;
	}

	/**
	 * A cleaner version of me
	 *
	 * @return
	 */
	public IJSTreeList<J> asMe()
	{
		return this;
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}
}
