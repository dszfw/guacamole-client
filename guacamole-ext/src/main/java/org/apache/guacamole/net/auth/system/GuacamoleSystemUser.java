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

import org.apache.guacamole.GuacamoleException;
import org.apache.guacamole.net.auth.AbstractAuthenticatedUser;
import org.apache.guacamole.net.auth.AuthenticationProvider;
import org.apache.guacamole.net.auth.Credentials;
import org.apache.guacamole.net.auth.Permissions;
import org.apache.guacamole.net.auth.permission.ObjectPermissionSet;
import org.apache.guacamole.net.auth.permission.SystemPermissionSet;

/**
 * This is an implementation of an AuthenticatedUser that represents
 * Guacamole's internal, system-level permissions to interact with itself.
 * This provides the necessary framework for Guacamole to accomplish certain
 * tasks within the various authentication extension modules that may be
 * loaded.
 */
public class GuacamoleSystemUser extends AbstractAuthenticatedUser
        implements Permissions {
    
    /**
     * The SystemPermissionSet that represents Guacamole's system-level
     * permissions to interact with objects that are handled by the
     * various installed authentication providers.
     */
    private static final GuacamoleSystemPermissionSet SYSTEM_PERMISSIONS =
            new GuacamoleSystemPermissionSet();
    
    /**
     * The ObjectPermissionSet that represents Guacamole's system-level
     * permissions associated with all of the various object types handled
     * by installed authentication providers.
     */
    private static final GuacamoleSystemObjectPermissionSet OBJECT_PERMISSIONS =
            new GuacamoleSystemObjectPermissionSet();
    
    @Override
    public AuthenticationProvider getAuthenticationProvider() {
        // Part of the system, not any authentication provider.
        return null;
    }

    @Override
    public Credentials getCredentials() {
        // This user does not have any credentials.
        return null;
    }

    @Override
    public ObjectPermissionSet getActiveConnectionPermissions()
            throws GuacamoleException {
        return OBJECT_PERMISSIONS;
    }

    @Override
    public ObjectPermissionSet getConnectionGroupPermissions()
            throws GuacamoleException {
        return OBJECT_PERMISSIONS;
    }

    @Override
    public ObjectPermissionSet getConnectionPermissions()
            throws GuacamoleException {
        return OBJECT_PERMISSIONS;
    }

    @Override
    public ObjectPermissionSet getSharingProfilePermissions()
            throws GuacamoleException {
        return OBJECT_PERMISSIONS;
    }

    @Override
    public SystemPermissionSet getSystemPermissions()
            throws GuacamoleException {
        return SYSTEM_PERMISSIONS;
    }

    @Override
    public ObjectPermissionSet getUserPermissions()
            throws GuacamoleException {
        return OBJECT_PERMISSIONS;
    }

    @Override
    public ObjectPermissionSet getUserGroupPermissions()
            throws GuacamoleException {
        return OBJECT_PERMISSIONS;
    }
    
}
