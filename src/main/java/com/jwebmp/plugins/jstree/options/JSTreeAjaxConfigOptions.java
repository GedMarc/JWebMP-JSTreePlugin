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

import com.jwebmp.base.client.HttpMethodTypes;
import com.jwebmp.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.jstree.options.functions.JSTreeCoreDataFunction;

import javax.validation.constraints.NotNull;

/**
 * All the configuration options, this class should be the jquery ajax options class
 *
 * @author GedMarc
 * @version 1.0
 * @since 22 Dec 2016
 */
public class JSTreeAjaxConfigOptions<J extends JSTreeAjaxConfigOptions<J>>
		extends JavaScriptPart<J>
{

	private static final long serialVersionUID = 1L;
	/**
	 * The Ajax url to retrieve data from.
	 * <p>
	 * Usually SiteBinder.DataLocation set in tree PreConfig
	 */
	private String url;
	/**
	 * Data to be sent to the server. It is converted to a query string, if not already a string. It's appended to the url for GET-requests. See processData option to prevent this
	 * automatic
	 * processing. Object must be Key/Value pairs. If value is an Array, jQuery serializes multiple values with same key based on the value of the traditional setting (described
	 * below).
	 */
	private JSTreeCoreDataFunction<?> data;
	/**
	 * If set to false, it will force requested pages not to be cached by the browser. Note: Setting cache to false will only work correctly with HEAD and GET requests. It works by
	 * appending
	 * "_={timestamp}" to the GET parameters. The parameter is not needed for other types of requests, except in IE8 when a POST is made to a URL that has already been requested by
	 * a GET.
	 */
	private Boolean cache;
	/**
	 * The type of data that you're expecting back from the server. If none is specified, jQuery will try to infer it based on the MIME type of the response (an XML MIME type will
	 * yield XML, in 1.4
	 * JSON will yield a JavaScript object, in 1.4 script will execute the script, and anything else will be returned as a string). The available types (and the result passed as
	 * the first argument to
	 * your success callback) are:
	 */
	private String dataType;
	/**
	 *
	 */
	private HttpMethodTypes type;

	public JSTreeAjaxConfigOptions()
	{
		//Nothing Needed
	}

	/**
	 * The Ajax url to retrieve data from.
	 * <p>
	 * Usually SiteBinder.DataLocation set in tree PreConfig
	 *
	 * @return
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * The Ajax url to retrieve data from.
	 * <p>
	 * Usually SiteBinder.DataLocation set in tree PreConfig
	 *
	 * @param url
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setUrl(String url)
	{
		this.url = url;
		return (J) this;
	}

	/**
	 * Data to be sent to the server. It is converted to a query string, if not already a string. It's appended to the url for GET-requests. See processData option to prevent this
	 * automatic
	 * processing. Object must be Key/Value pairs. If value is an Array, jQuery serializes multiple values with same key based on the value of the traditional setting (described
	 * below).
	 *
	 * @return
	 */
	public JSTreeCoreDataFunction<?> getData()
	{
		return data;
	}

	/**
	 * Data to be sent to the server. It is converted to a query string, if not already a string. It's appended to the url for GET-requests. See processData option to prevent this
	 * automatic
	 * processing. Object must be Key/Value pairs. If value is an Array, jQuery serializes multiple values with same key based on the value of the traditional setting (described
	 * below).
	 *
	 * @param data
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setData(JSTreeCoreDataFunction<?> data)
	{
		this.data = data;
		return (J) this;
	}

	/**
	 * If set to false, it will force requested pages not to be cached by the browser. Note: Setting cache to false will only work correctly with HEAD and GET requests. It works by
	 * appending
	 * "_={timestamp}" to the GET parameters. The parameter is not needed for other types of requests, except in IE8 when a POST is made to a URL that has already been requested by
	 * a GET.
	 *
	 * @return
	 */
	public Boolean getCache()
	{
		return cache;
	}

	/**
	 * If set to false, it will force requested pages not to be cached by the browser. Note: Setting cache to false will only work correctly with HEAD and GET requests. It works by
	 * appending
	 * "_={timestamp}" to the GET parameters. The parameter is not needed for other types of requests, except in IE8 when a POST is made to a URL that has already been requested by
	 * a GET.
	 *
	 * @param cache
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setCache(Boolean cache)
	{
		this.cache = cache;
		return (J) this;
	}

	/**
	 * The type of data that you're expecting back from the server. If none is specified, jQuery will try to infer it based on the MIME type of the response (an XML MIME type will
	 * yield XML, in 1.4
	 * JSON will yield a JavaScript object, in 1.4 script will execute the script, and anything else will be returned as a string). The available types (and the result passed as
	 * the first argument to
	 * your success callback) are:
	 *
	 * @return
	 */
	public String getDataType()
	{
		return dataType;
	}

	/**
	 * The type of data that you're expecting back from the server. If none is specified, jQuery will try to infer it based on the MIME type of the response (an XML MIME type will
	 * yield XML, in 1.4
	 * JSON will yield a JavaScript object, in 1.4 script will execute the script, and anything else will be returned as a string). The available types (and the result passed as
	 * the first argument to
	 * your success callback) are:
	 *
	 * @param dataType
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDataType(String dataType)
	{
		this.dataType = dataType;
		return (J) this;
	}

	public HttpMethodTypes getType()
	{
		return type;
	}

	@SuppressWarnings("unchecked")
	@NotNull
	public J setType(HttpMethodTypes type)
	{
		this.type = type;
		return (J) this;
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