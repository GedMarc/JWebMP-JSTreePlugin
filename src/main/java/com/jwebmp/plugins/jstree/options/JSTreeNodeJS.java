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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.plugins.jstree.JSTreeData;

import jakarta.validation.constraints.NotNull;

/**
 * A Tree Node
 *
 * @author GedMarc
 * @version 1.0
 * @since 22 Dec 2016
 */
public class JSTreeNodeJS<J extends JSTreeNodeJS<J>>
		extends JSTreeTypesOptions<J>
{


	/**
	 * The ID of the node
	 */
	private String id;
	/**
	 * The text to display for the node
	 */
	private String text;
	/**
	 * You can set the state on a node using the state property.
	 * <p>
	 * Use any combination of the following: opened, selected, disabled.
	 */
	private JSTreeNodeStateOptions<?> state;
	/**
	 * The type for the node
	 */
	@JsonProperty("type")
	private String typeName;

	/**
	 * All the child nodes, json ignored for ajax called rendering
	 */
	@JsonIgnore
	private JSTreeData<?> childNodes;

	/**
	 * Constructs an empty tree node
	 */
	public JSTreeNodeJS()
	{
		//No config required
	}

	/**
	 * Builds a tree node with the given information
	 *
	 * @param id
	 * 		The ID of the node (don't use default or '#')
	 * @param text
	 * 		The text for the node
	 * @param typeName
	 * 		The type of the node if specified
	 */
	public JSTreeNodeJS(String id, String text, String typeName)
	{
		this.id = id;
		this.text = text;
		this.typeName = typeName;
	}

	/**
	 * Builds a tree node with the given information
	 *
	 * @param id
	 * @param text
	 * @param state
	 */
	public JSTreeNodeJS(String id, String text, JSTreeNodeStateOptions<?> state)
	{
		this.id = id;
		this.text = text;
		this.state = state;
	}

	/**
	 * Builds a tree node with the given information
	 *
	 * @param id
	 * @param text
	 * @param state
	 * @param typeName
	 */
	public JSTreeNodeJS(String id, String text, JSTreeNodeStateOptions<?> state, String typeName)
	{
		this.id = id;
		this.text = text;
		this.state = state;
		this.typeName = typeName;
	}

	/**
	 * Constructs a new tree node
	 *
	 * @param id
	 * 		The id of the tree (don't use default or '#')
	 * @param text
	 * 		The text for the tree
	 */
	public JSTreeNodeJS(String id, String text)
	{
		this.id = id;
		this.text = text;
	}

	/**
	 * returns the json property
	 *
	 * @return
	 */
	@JsonProperty("children")
	public boolean hasChildren()
	{
		return !getChildNodes().getNodes()
		                       .isEmpty();
	}

	/**
	 * Returns the list of child nodes
	 *
	 * @return
	 */
	public JSTreeData<?> getChildNodes()
	{
		if (childNodes == null)
		{
			//noinspection rawtypes
			setChildNodes(new JSTreeData()
			{
				//Lazy Fetch child nodes
				@NotNull
				@Override
				public StringBuilder renderData()
				{
					return new StringBuilder();
				}

				@Override
				public StringBuilder renderMassLoad()
				{
					return new StringBuilder();
				}
			});
		}
		return childNodes;
	}

	/**
	 * Sets the list of child nodes
	 *
	 * @param childNodes
	 *
	 * @return
	 */
	public JSTreeNodeJS<?> setChildNodes(JSTreeData<?> childNodes)
	{
		this.childNodes = childNodes;
		return this;
	}

	/**
	 * The ID of the node
	 *
	 * @return
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * The ID of the node
	 *
	 * @param id
	 *
	 * @return
	 */
	public JSTreeNodeJS<?> setId(String id)
	{
		this.id = id;
		return this;

	}

	/**
	 * The text to display for the node
	 *
	 * @return
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * The text to display for the node
	 *
	 * @param text
	 *
	 * @return
	 */
	public JSTreeNodeJS<?> setText(String text)
	{
		this.text = text;
		return this;

	}

	/**
	 * You can set the state on a node using the state property.
	 * <p>
	 * Use any combination of the following: opened, selected, disabled.
	 *
	 * @return
	 */
	public JSTreeNodeStateOptions<?> getState()
	{
		if (state == null)
		{
			setState(new JSTreeNodeStateOptions<>());
		}
		return state;
	}

	/**
	 * You can set the state on a node using the state property.
	 * <p>
	 * Use any combination of the following: opened, selected, disabled.
	 *
	 * @param state
	 *
	 * @return
	 */
	public JSTreeNodeJS<?> setState(JSTreeNodeStateOptions<?> state)
	{
		this.state = state;
		return this;
	}

	/**
	 * The type name associated with the node
	 *
	 * @return
	 */
	public String getTypeName()
	{
		return typeName;
	}

	/**
	 * The type name associated with the node
	 *
	 * @param typeName
	 *
	 * @return
	 */
	public JSTreeNodeJS<?> setTypeName(String typeName)
	{
		this.typeName = typeName;
		return this;
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}
}
