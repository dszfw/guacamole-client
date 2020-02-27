/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.guacamole.net.auth.system;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import org.apache.guacamole.GuacamoleException;
import org.apache.guacamole.net.auth.permission.ObjectPermission;
import org.apache.guacamole.net.auth.permission.ObjectPermissionSet;

/**
 *
 * @author nick_couchman
 */
public class GuacamoleSystemObjectPermissionSet implements ObjectPermissionSet {

    @Override
    public boolean hasPermission(ObjectPermission.Type permission, String identifier) throws GuacamoleException {
        // System always has permissions
        return true;
    }

    @Override
    public void addPermission(ObjectPermission.Type permission, String identifier) throws GuacamoleException {
        // Do nothing; system has all permissions
    }

    @Override
    public void removePermission(ObjectPermission.Type permission, String identifier) throws GuacamoleException {
        // Do nothing; system has all permissions
    }

    @Override
    public Collection<String> getAccessibleObjects(Collection<ObjectPermission.Type> permissions, Collection<String> identifiers) throws GuacamoleException {
        // System has all permissions, so just return the provided identifiers
        return identifiers;
    }

    @Override
    public Set<ObjectPermission> getPermissions() throws GuacamoleException {
        // Return an empty set - system has ADMINISTER permissions.
        return Collections.emptySet();
    }

    @Override
    public void addPermissions(Set<ObjectPermission> permissions) throws GuacamoleException {
        // Do nothing; system has all permissions
    }

    @Override
    public void removePermissions(Set<ObjectPermission> permissions) throws GuacamoleException {
        // Do noting; system has all permissions
    }
    
}
