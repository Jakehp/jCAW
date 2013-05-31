package jhpservices.servehttp.com.parser;

/*
 *    Copyright 2011 JSON-SMART authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import static jhpservices.servehttp.com.parser.ParseException.ERROR_UNEXPECTED_EOF;

import java.io.IOException;
import java.io.InputStream;

/**
 * Parser for JSON text. Please note that JSONParser is NOT thread-safe.
 * 
 * @author Uriel Chemouni <uchemouni@gmail.com>
 */
class JSONParserInputStream extends JSONParserStream {
	private InputStream in;

	// len
	public JSONParserInputStream(int permissiveMode) {
		super(permissiveMode);
	}

	/**
	 * use to return Primitive Type, or String, Or JsonObject or JsonArray
	 * generated by a ContainerFactory
	 */
	public Object parse(InputStream in) throws ParseException {
		return parse(in, ContainerFactory.FACTORY_SIMPLE, ContentHandlerDumy.HANDLER);
	}

	/**
	 * use to return Primitive Type, or String, Or JsonObject or JsonArray
	 * generated by a ContainerFactory
	 */
	public Object parse(InputStream in, ContainerFactory containerFactory) throws ParseException {
		return parse(in, containerFactory, ContentHandlerDumy.HANDLER);
	}

	/**
	 * use to return Primitive Type, or String, Or JsonObject or JsonArray
	 * generated by a ContainerFactory
	 */
	public Object parse(InputStream in, ContainerFactory containerFactory, ContentHandler handler)
			throws ParseException {
		//
		this.in = in;
		this.pos = -1;
		return super.parse(containerFactory, handler);
	}

	protected void read() throws IOException {
		int i = in.read();
		c = (i == -1) ? (char) EOI : (char) i;
		pos++;
		//
	}

	protected void readS() throws IOException {
		sb.append(c);
		int i = in.read();
		if (i == -1) {
			c = EOI;
		} else {
			c = (char) i;
			pos++;
		}
	}

	protected void readNoEnd() throws ParseException, IOException {
		int i = in.read();
		if (i == -1)
			throw new ParseException(pos - 1, ERROR_UNEXPECTED_EOF, "EOF");
		c = (char) i;
		//
	}
}
