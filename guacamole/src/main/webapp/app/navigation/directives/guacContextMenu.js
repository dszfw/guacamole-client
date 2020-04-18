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

/**
 * A directive which provides a context-driven menu containing options
 * appropriate to the context from which the menu was launched.
 */
angular.module('navigation').directive('guacContextMenu', [function guacContextMenu() {

    return {
        restrict: 'E',
        replace: true,
        scope: {

            /**
             * Array of actions which are specific to the context in which this
             * menu was launched.
             *
             * @type MenuAction[]
             */
            contextActions : '=',
            
            /**
             * Controls whether or not this context menu is displayed.
             * 
             * @type Boolean
             */
            showContextMenu : '=',
            
            /**
             * The title of this context menu.
             * 
             * @type String
             */
            title : '='

        },

        templateUrl: 'app/navigation/templates/guacContextMenu.html',
        controller: ['$scope', '$injector',
            function guacContextMenuController($scope, $injector) {

            // Get required services
            var $log = injector.get('$log');

            $scope.example = function example() {
                $log.debug('Example action.');
            }
                
            /**
             * Action which logs out the current user, redirecting them to back
             * to the login screen after logout completes.
             */
            var EXAMPLE_ACTION = {
                name      : 'USER_MENU.ACTION_EXAMPLE',
                className : 'example',
                callback  : $scope.example
            };

            /**
             * All available actions for the current user.
             */
            $scope.contextActions = [ EXAMPLE_ACTION ];

        }] // end controller

    };
}]);
