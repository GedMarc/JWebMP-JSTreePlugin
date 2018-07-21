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
package com.jwebmp.plugins.jstree.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.core.plugins.ComponentInformation;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * This plugin makes it possible to add predefined types for groups of nodes, which means to easily control nesting rules and icon for each group.
 * <p>
 * To set a node's type you can use set_type or supply a type property with the node's data.
 * <p>
 * There are two predefined types:
 * <p>
 * # - represents the root of the tree, for example max_children would control the maximum number of root nodes.
 * <p>
 * default - represents the default node - any settings here
 * <p>
 * will be applied to all nodes that do not have a type specified.
 *
 * @author GedMarc
 * @version 1.0
 * @since 23 Dec 2016
 */
@ComponentInformation(name = "JS Tree Types Plugin",
		description = "This plugin makes it possible to add predefined types for groups of nodes, which means to easily control nesting rules and icon for each group.",
		url = "https://www.jstree.com/plugins/")
public class JSTreeTypesOptions<J extends JSTreeTypesOptions<J>>
		extends JavaScriptPart<J>
{

	private static final long serialVersionUID = 1L;

	/**
	 * a string - can be a path to an icon or a className, if using an image that is in the current directory use a ./ prefix, otherwise it will be detected as a class. Omit to use
	 * the default icon
	 * from your theme.
	 */
	private String icon;

	/**
	 * the maximum number of immediate children this node type can have. Do not specify or set to -1 for unlimited.
	 */
	@JsonProperty(value = "max_children")
	private Integer maxChildren;
	/**
	 * the maximum number of nesting this node type can have. A value of 1 would mean that the node can have children, but no grandchildren. Do not specify or set to -1 for
	 * unlimited.
	 */
	@JsonProperty(value = "max_depth")
	private Integer maxDepth;
	/**
	 * an array of node type strings, that nodes of this type can have as children. Do not specify or set to -1 for no limits.
	 */
	@JsonProperty(value = "valid_children")
	private List<String> validChildren;

	/**
	 * an object of values which will be used to add HTML attributes on the resulting LI DOM node (merged with the node's own data)
	 */
	@JsonProperty("li_atr")
	private String listItemAttributes;
	/**
	 * an object of values which will be used to add HTML attributes on the resulting A DOM node (merged with the node's own data)
	 */
	@JsonProperty("a_attr")
	private String linkAttributes;

	public JSTreeTypesOptions()
	{
		//No config required
	}

	/**
	 * Sets the icon
	 *
	 * @param icon
	 */
	public JSTreeTypesOptions(String icon)
	{
		this.icon = icon;
	}

	/**
	 * a string - can be a path to an icon or a className, if using an image that is in the current directory use a ./ prefix, otherwise it will be detected as a class. Omit to use
	 * the default icon
	 * from your theme.
	 *
	 * @return
	 */
	public String getIcon()
	{
		return icon;
	}

	/**
	 * a string - can be a path to an icon or a className, if using an image that is in the current directory use a ./ prefix, otherwise it will be detected as a class. Omit to use
	 * the default icon
	 * from your theme.
	 *
	 * @param icon
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setIcon(String icon)
	{
		this.icon = icon;
		return (J) this;
	}

	/**
	 * a string - can be a path to an icon or a className, if using an image that is in the current directory use a ./ prefix, otherwise it will be detected as a class. Omit to use
	 * the default icon
	 * from your theme.
	 *
	 * @param icon
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setIcon(Enum icon)
	{
		this.icon = icon.toString();
		return (J) this;
	}

	/**
	 * the maximum number of immediate children this node type can have. Do not specify or set to -1 for unlimited.
	 *
	 * @return
	 */
	public Integer getMaxChildren()
	{
		return maxChildren;
	}

	/**
	 * the maximum number of immediate children this node type can have. Do not specify or set to -1 for unlimited.
	 *
	 * @param maxChildren
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setMaxChildren(Integer maxChildren)
	{
		this.maxChildren = maxChildren;
		return (J) this;
	}

	/**
	 * the maximum number of nesting this node type can have. A value of 1 would mean that the node can have children, but no grandchildren. Do not specify or set to -1 for
	 * unlimited.
	 *
	 * @return
	 */
	public Integer getMaxDepth()
	{
		return maxDepth;
	}

	/**
	 * the maximum number of nesting this node type can have. A value of 1 would mean that the node can have children, but no grandchildren. Do not specify or set to -1 for
	 * unlimited.
	 *
	 * @param maxDepth
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setMaxDepth(Integer maxDepth)
	{
		this.maxDepth = maxDepth;
		return (J) this;
	}

	/**
	 * an array of node type strings, that nodes of this type can have as children. Do not specify or set to -1 for no limits.
	 *
	 * @return
	 */
	public List<String> getValidChildren()
	{
		if (validChildren == null)
		{
			validChildren = new ArrayList<>();
		}
		return validChildren;
	}

	/**
	 * an array of node type strings, that nodes of this type can have as children. Do not specify or set to -1 for no limits.
	 *
	 * @param validChildren
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setValidChildren(List<String> validChildren)
	{
		this.validChildren = validChildren;
		return (J) this;
	}

	/**
	 * an object of values which will be used to add HTML attributes on the resulting LI DOM node (merged with the node's own data)
	 *
	 * @return
	 */
	public String getListItemAttributes()
	{
		return listItemAttributes;
	}

	/**
	 * an object of values which will be used to add HTML attributes on the resulting LI DOM node (merged with the node's own data)
	 *
	 * @param listItemAttributes
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setListItemAttributes(String listItemAttributes)
	{
		this.listItemAttributes = listItemAttributes;
		return (J) this;
	}

	/**
	 * an object of values which will be used to add HTML attributes on the resulting A DOM node (merged with the node's own data)
	 *
	 * @return
	 */
	public String getLinkAttributes()
	{
		return linkAttributes;
	}

	/**
	 * an object of values which will be used to add HTML attributes on the resulting A DOM node (merged with the node's own data)
	 *
	 * @param linkAttributes
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setLinkAttributes(String linkAttributes)
	{
		this.linkAttributes = linkAttributes;
		return (J) this;
	}

}
