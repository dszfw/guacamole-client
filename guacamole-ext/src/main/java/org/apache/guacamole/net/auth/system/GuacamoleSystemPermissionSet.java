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

import java.util.Collections;
import java.util.Set;
import org.apache.guacamole.GuacamoleException;
import org.apache.guacamole.net.auth.permission.SystemPermission;
import org.apache.guacamole.net.auth.permission.SystemPermissionSet;

/**
 *
 * @author nick_couchman
 */
public class GuacamoleSystemPermissionSet implements SystemPermissionSet {

    @Override
    public boolean hasPermission(SystemPermission.Type permission)
            throws GuacamoleException {
        // System always has permissions.
        return true;
    }

    @Override
    public void addPermission(SystemPermission.Type permission)
            throws GuacamoleException {
        // System has all permissions; do nothing.
    }

    @Override
    public void removePermission(SystemPermission.Type permission)
            throws GuacamoleException {
        // System has all permissions; do nothing.
    }

    @Override
    public Set<SystemPermission> getPermissions() throws GuacamoleException {
        // System has administrative permissions.
        return Collections.singleton(
                new SystemPermission(SystemPermission.Type.ADMINISTER));
    }

    @Override
    public void addPermissions(Set<SystemPermission> permissions)
            throws GuacamoleException {
        // System has all permissions; do nothing.
    }

    @Override
    public void removePermissions(Set<SystemPermission> permissions)
            throws GuacamoleException {
        // System has all permissions; do nothing.
    }
    
}
