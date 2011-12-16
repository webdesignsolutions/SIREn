/**
 * Copyright (c) 2009-2011 National University of Ireland, Galway. All Rights Reserved.
 *
 * Project and contact information: http://www.siren.sindice.com/
 *
 * This file is part of the SIREn project.
 *
 * SIREn is a free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * SIREn is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with SIREn. If not, see <http://www.gnu.org/licenses/>.
 */
package org.sindice.siren.qparser.tuple.query.builders;

import org.apache.lucene.messages.MessageImpl;
import org.apache.lucene.queryParser.core.QueryNodeException;
import org.apache.lucene.queryParser.core.messages.QueryParserMessages;
import org.apache.lucene.queryParser.core.nodes.MatchNoDocsQueryNode;
import org.apache.lucene.queryParser.core.nodes.QueryNode;
import org.apache.lucene.queryParser.standard.parser.EscapeQuerySyntaxImpl;
import org.sindice.siren.search.SirenBooleanQuery;
import org.sindice.siren.search.SirenCellQuery;

/**
 * Builds an empty {@link SirenCellQuery} object from a
 * {@link MatchNoDocsQueryNode} object.
 */
public class MatchNoDocsQueryNodeBuilder implements ResourceQueryBuilder {

  public MatchNoDocsQueryNodeBuilder() {
    // empty constructor
  }

  public SirenBooleanQuery build(final QueryNode queryNode) throws QueryNodeException {

    // validates node
    if (!(queryNode instanceof MatchNoDocsQueryNode)) {
      throw new QueryNodeException(new MessageImpl(
          QueryParserMessages.LUCENE_QUERY_CONVERSION_ERROR, queryNode
              .toQueryString(new EscapeQuerySyntaxImpl()), queryNode.getClass()
              .getName()));
    }

    return new SirenBooleanQuery();

  }

}
