package com.jwebmp.plugins.jstree.interfaces;

import com.jwebmp.plugins.jstree.JSTreeList;
import com.jwebmp.plugins.jstree.JSTreeListItem;
import com.jwebmp.plugins.jstree.options.JSTreeNodeOptions;

import javax.validation.constraints.NotNull;

public interface IJSTreeList<J extends JSTreeList<J>>
{
	/**
	 * Adds a new item to the collection
	 *
	 * @param title
	 * @param options
	 *
	 * @return
	 */
	JSTreeListItem<? extends JSTreeListItem> addItem(String title, JSTreeNodeOptions<?> options);

	/**
	 * Adds a new static root object to the list
	 *
	 * @param root
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J addRoot(JSTreeListItem<?> root);
}
