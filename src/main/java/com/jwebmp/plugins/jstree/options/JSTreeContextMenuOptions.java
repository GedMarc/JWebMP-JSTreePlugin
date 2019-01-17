/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.plugins.jstree.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.core.plugins.ComponentInformation;

import javax.validation.constraints.NotNull;

/**
 * This plugin makes it possible to right click nodes and shows a list of configurable actions in a menu.
 * <p>
 * You can find all the contextmenu plugin config options in the API.
 *
 * @author GedMarc
 * @version 1.0
 * @since 23 Dec 2016
 */
@ComponentInformation(name = "JS Tree Context Menu Plugin",
		description = "This plugin makes it possible to right click nodes and shows a list of configurable actions in a menu.",
		url = "https://www.jstree.com/plugins/")
public class JSTreeContextMenuOptions<J extends JSTreeContextMenuOptions<J>>
		extends JavaScriptPart<J>
{


	/**
	 * a boolean indicating if the node should be selected when the context menu is invoked on it. Defaults to true.
	 */
	@JsonProperty("select_node")
	private Boolean selectNode;
	/**
	 * a boolean indicating if the menu should be shown aligned with the node. Defaults to true, otherwise the mouse coordinates are used.
	 */
	@JsonProperty("show_at_node")
	private Boolean showAtNode;
	/**
	 * an object of actions, or a function that accepts a node and a callback function and calls the callback function with an object of actions available for that node (you can
	 * also return the items
	 * too).
	 */
	private JSTreeContextMenuItemsOptions<?> items;

	public JSTreeContextMenuOptions()
	{
		//Nothing Needed
	}

	/**
	 * a boolean indicating if the node should be selected when the context menu is invoked on it. Defaults to true.
	 *
	 * @return
	 */
	public Boolean getSelectNode()
	{
		return selectNode;
	}

	/**
	 * a boolean indicating if the node should be selected when the context menu is invoked on it. Defaults to true.
	 *
	 * @param selectNode
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSelectNode(Boolean selectNode)
	{
		this.selectNode = selectNode;
		return (J) this;
	}

	/**
	 * a boolean indicating if the menu should be shown aligned with the node. Defaults to true, otherwise the mouse coordinates are used.
	 *
	 * @return
	 */
	public Boolean getShowAtNode()
	{
		return showAtNode;
	}

	/**
	 * a boolean indicating if the menu should be shown aligned with the node. Defaults to true, otherwise the mouse coordinates are used.
	 *
	 * @param showAtNode
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setShowAtNode(Boolean showAtNode)
	{
		this.showAtNode = showAtNode;
		return (J) this;
	}

	/**
	 * an object of actions, or a function that accepts a node and a callback function and calls the callback function with an object of actions available for that node (you can
	 * also return the items
	 * too).
	 *
	 * @return never null
	 */
	public JSTreeContextMenuItemsOptions<?> getItems()
	{
		if (items == null)
		{
			items = new JSTreeContextMenuItemsOptions();
		}
		return items;
	}

	/**
	 * an object of actions, or a function that accepts a node and a callback function and calls the callback function with an object of actions available for that node (you can
	 * also return the items
	 * too).
	 *
	 * @param items
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setItems(JSTreeContextMenuItemsOptions<?> items)
	{
		this.items = items;
		return (J) this;
	}

}
