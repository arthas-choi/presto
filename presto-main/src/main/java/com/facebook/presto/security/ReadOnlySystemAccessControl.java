/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.security;

import com.facebook.presto.spi.CatalogSchemaName;
import com.facebook.presto.spi.CatalogSchemaTableName;
import com.facebook.presto.spi.ConnectorSession;
import com.facebook.presto.spi.SchemaTableName;
import com.facebook.presto.spi.security.Identity;
import com.facebook.presto.spi.security.SystemAccessControl;
import com.facebook.presto.spi.security.SystemAccessControlFactory;

import java.security.Principal;
import java.util.Map;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;

public class ReadOnlySystemAccessControl
        implements SystemAccessControl
{
    public static final String NAME = "read-only";

    private static final ReadOnlySystemAccessControl INSTANCE = new ReadOnlySystemAccessControl();

    public static class Factory
            implements SystemAccessControlFactory
    {
        @Override
        public String getName()
        {
            return NAME;
        }

        @Override
        public SystemAccessControl create(Map<String, String> config)
        {
            requireNonNull(config, "config is null");
            checkArgument(config.isEmpty(), "This access controller does not support any configuration properties");
            return INSTANCE;
        }
    }

    @Override
    public void checkCanSetUser(Principal principal, String userName)
    {
    }

    @Override
    public void checkCanSetSystemSessionProperty(Identity identity, String propertyName)
    {
    }

    @Override
    public void checkCanAccessCatalog(Identity identity, String catalogName)
    {
    }

    @Override
    public void checkCanSelectFromTable(ConnectorSession session, CatalogSchemaTableName table)
    {
    }

    @Override
    public void checkCanSelectFromView(ConnectorSession session, CatalogSchemaTableName view)
    {
    }

    @Override
    public void checkCanSetCatalogSessionProperty(Identity identity, String catalogName, String propertyName)
    {
    }

    @Override
    public void checkCanCreateViewWithSelectFromTable(ConnectorSession session, CatalogSchemaTableName table)
    {
    }

    @Override
    public void checkCanCreateViewWithSelectFromView(ConnectorSession session, CatalogSchemaTableName view)
    {
    }

    @Override
    public Set<String> filterCatalogs(ConnectorSession session, Set<String> catalogs)
    {
        return catalogs;
    }

    @Override
    public Set<String> filterSchemas(ConnectorSession session, String catalogName, Set<String> schemaNames)
    {
        return schemaNames;
    }

    @Override
    public Set<SchemaTableName> filterTables(ConnectorSession session, String catalogName, Set<SchemaTableName> tableNames)
    {
        return tableNames;
    }

    @Override
    public void checkCanShowSchemas(ConnectorSession session, String catalogName)
    {
    }

    @Override
    public void checkCanShowTablesMetadata(ConnectorSession session, CatalogSchemaName schema)
    {
    }
}
