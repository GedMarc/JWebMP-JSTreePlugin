/*
 * Copyright (C) 2017 Marc Magon
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
package com.jwebmp.plugins.jstree;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.jwebmp.base.servlets.interfaces.IDataComponent;
import com.jwebmp.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.jstree.options.JSTreeNodeJS;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author GedMarc
 * @version 1.0
 * @since 22 Dec 2016
 */
public abstract class JSTreeData<J extends JSTreeData<J>>
		extends JavaScriptPart<J>
		implements IDataComponent<JSTreeData>
{

	private static final long serialVersionUID = 1L;
	/**
	 * The list of nodes
	 */

	private List<JSTreeNodeJS<?>> nodes;

	/**
	 * Constructs a new instance of tree data
	 *
	 * @throws RuntimeException
	 * 		If tree is null
	 */
	public JSTreeData()
	{
		//Nothing Needed
	}

	/**
	 * Used for when mass loading lazy children and state is enabled
	 *
	 * @return
	 */
	public abstract StringBuilder renderMassLoad();

	/**
	 * Returns all the nodes currently associated with this tree
	 *
	 * @return
	 */
	@JsonRawValue
	@JsonValue
	public List<JSTreeNodeJS<?>> getNodes()
	{
		if (nodes == null)
		{
			setNodes(new ArrayList<>());
		}
		return nodes;
	}

	/**
	 * Sets the nodes currently associated with this tree
	 *
	 * @param nodes
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setNodes(List<JSTreeNodeJS<?>> nodes)
	{
		this.nodes = nodes;
		return (J) this;
	}

	public JSTreeNodeJS findNode(String id)
	{
		JSTreeNodeJS found;
		found = findNode(getNodes(), id);
		return found;
	}

	/**
	 * Goes through the list and retrieves the node with the given id
	 *
	 * @param nodes
	 * @param id
	 *
	 * @return
	 */
	protected JSTreeNodeJS<?> findNode(List<JSTreeNodeJS<?>> nodes, String id)
	{
		JSTreeNodeJS<?> found;
		for (JSTreeNodeJS<?> next : nodes)
		{
			if (next.getId()
			        .equals(id))
			{
				return next;
			}
			if ((found = next.getChildNodes()
			                 .findNode(id)) != null)
			{
				return found;
			}
		}
		return null;
	}
}
