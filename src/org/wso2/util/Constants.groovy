/*
*  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.util

/**
 * This class holds constants
 */
class Constants {
    class ControlConstants {
        static final int STATUS_COMPLETED = 0
        static final int STATUS_FAILED_WUM_UPDATE = 10
        static final int STATUS_FAILED_WUM_ADD = 11
        static final int STATUS_FAILED_INPLACE_UPDATES = 12
        static final int STATUS_FAILED_PUPPET_APPLY = 13
        static final int STATUS_FAILED_TO_MOVE_UPDATED_PRODUCT = 14
        static final int STATUS_FAILED_UNZIP = 15
        static final int STATUS_FAILED_RM_UNZIP = 16
        static final int STATUS_FAILED_ARTIFACT_APPLY = 17
        static final int STATUS_FAILED_WUM_INIT = 18
        static final int STATUS_FAILED_DOWNLOAD_PACK = 19
        static final int STATUS_FAILED_DOWNLOAD_PATCH_FILE=20
    }
    class Stages {
        static final String SETUP_ENV = "Setup Environment"
        static final String BUILD_PACK = "Build the pack"
        static final String BUILD_IMAGE = "Build the immutable image"
        static final String DEPLOY_DEV = "Deploy to Development"
        static final String APPROVE_STAGING = "Approve Staging"
        static final String DEPLOY_STAGING = "Deploy to Staging"
        static final String RUNNING_TESTS = "Running Tests"
        static final String APPROVE_PRODUCTION = "Approve Production"
        static final String DEPLOY_PRODUCTION = "Deploy to Production"
        static final String BUILD_ARTIFACTS = "Build artifacts"
        static final String DEPLOY_NETWORK = "Deploy Network Resources"

    }
    class Paths {
        static final String RESOURCES = "/home/jenkins/resources"
    }
}
