package net.sourceforge.guacamole.net.basic.xml.user_mapping;

/*
 *  Guacamole - Clientless Remote Desktop
 *  Copyright (C) 2010  Michael Jumper
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import net.sourceforge.guacamole.net.basic.xml.TagHandler;
import net.sourceforge.guacamole.protocol.GuacamoleConfiguration;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * TagHandler for the "protocol" element.
 * 
 * @author Mike Jumper 
 */
public class ProtocolTagHandler implements TagHandler {

    /**
     * The GuacamoleConfiguration which will be populated with data from
     * the tag handled by this tag handler.
     */
    private GuacamoleConfiguration config;
    
    /**
     * Creates a new handler for a "protocol" tag having the given
     * attributes.
     * 
     * @param config The GuacamoleConfiguration to update with the data parsed
     *               from the "protocol" tag.
     * @throws SAXException If the attributes given are not valid.
     */
    public ProtocolTagHandler(GuacamoleConfiguration config) throws SAXException {
        this.config = config;
    }

    @Override
    public TagHandler childElement(String localName, Attributes attributes) throws SAXException {
        throw new SAXException("The 'protocol' tag can contain no elements.");
    }

    @Override
    public void complete(String textContent) throws SAXException {
        config.setProtocol(textContent);
    }
   
}
