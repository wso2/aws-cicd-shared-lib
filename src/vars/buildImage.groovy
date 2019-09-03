#!/usr/bin/env groovy
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
import org.wso2.util.Constants

String call(Map config) {
    withEnv(["PRODUCT=${config.product}",
             "VERSION=${config.version}",
             "DEPLOYMENTPATTERN=${config.deploymentPattern}",
             "DBTYPE=${config.dbType}",
             "PACKER_REGION=${config.region}",
             "PACKER_JSON=${config.packerJson}",
             "PACKER_MANIFEST=${config.packerManifest}",
             "IMAGE_RESOURCES=${config.imageResources}",
             "AWS_CREDS_FILE=${config.awsCredsFile}"]) {
        int status = sh(
                script: """
                        export AWS_SHARED_CREDENTIALS_FILE=$AWS_CREDS_FILE 
                        packer build  -var "product=$PRODUCT" \
                        -var "version=$VERSION" \
                        -var "deploymentPattern=$DEPLOYMENTPATTERN" \
                        -var "dbType=$DBTYPE" \
                        -var "region=$PACKER_REGION" \
                        -var "image_resources=$IMAGE_RESOURCES" \
                        -var "manifest=$PACKER_MANIFEST" $PACKER_JSON
                        """,
                returnStatus: true
        )
        if (status != Constants.ControlConstants.STATUS_COMPLETED) {
            throw new Exception("AMI building is failed !")
        }
    }
    def packer_post = readJSON file: "${config.packerManifest}", text: ''
    def size = packer_post.builds.artifact_id.size()
    def ami_info = packer_post.builds.artifact_id[size - 1]
    def (value1, value2) = "$ami_info".tokenize(':')
    return value2
}
