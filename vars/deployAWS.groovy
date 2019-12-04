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
def call(Map config) {
    def WSO2InstanceType = "WSO2InstanceType=${config.wso2InstanceType}"
    def KeyPairName = "KeyPairName=${config.keyPairName}"
    def CertificateName = "CertificateName=${config.certName}"
    def DBType = "DBType=${config.dbType}"
    def AMIId = "AMIid=${config.amiID}"
    def Product = "Product=${config.product}"
    def Version = "Version=${config.version}"
    def Environment = "Environment=${config.environment}"
    def IAMRole = "IAMRole=${config.iamRole}"
    def NetworkStackName = "NetworkStackName=${config.networkStackName}"
    def VPCID = "VPCID=${config.vpcId}"
    withCredentials([[$class            : 'UsernamePasswordMultiBinding',
                      credentialsId     : "${config.dbCredID}",
                      usernameVariable  : 'DBUsername',
                      passwordVariable  : 'DBPassword']]) {
        def DBUsername = "DBUsername=$DBUsername"
        def DBPassword = "DBPassword=$DBPassword"
        withAWS(role:"${config.iamRole}", region: "${config.region}") {
            def outputs = cfnUpdate(stack: "${config.stackName}", file: "${config.cf}",
                    params: [IAMRole,
                             WSO2InstanceType,
                             KeyPairName,
                             CertificateName,
                             DBUsername,
                             DBPassword,
                             DBType,
                             AMIId,
                             Product,
                             Version,
                             Environment,
                             VPCID,
                             NetworkStackName]
                    , timeoutInMinutes: 30, pollInterval: 1000)
            return outputs."${config.testEndpoint}"
        }
    }
}
