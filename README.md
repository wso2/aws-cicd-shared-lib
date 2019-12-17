# Shared resources in AWS CICD Pipeline

This repository contains the library resources used in AWS Pipeline. [Jenkins shared library](https://github.com/wso2/aws-cicd-shared-lib.git) contains set of functions used in [Jenkins pipeline artifacts](https://github.com/wso2/aws-cicd-pipeline.git).


#### Prerequisites  
This library depends on following Jenkins plugins:

* [AnsiColor plugin](https://wiki.jenkins.io/display/JENKINS/AnsiColor+Plugin)
* [Pipeline AWS Plugin](https://wiki.jenkins.io/display/JENKINS/Pipeline+AWS+Plugin)
* [Pipeline Utility Steps Plugin](https://wiki.jenkins.io/display/JENKINS/Pipeline+Utility+Steps+Plugin)


#### Quick Start Guide

 **Step 1**: Configure this repository as a shared library under the name "wso2-jenkins-shared-lib"
 
 **Step 2**: Use the functions under vars folder. Refer the text files for each function for samples.
 
 * [applyConfig](vars/applyConfig.groovy)
 * [buildArtifacts](vars/buildArtifacts.groovy)
 * [buildImage](vars/buildImage.groovy)
 * [cloneRepotoDir](vars/cloneRepotoDir.groovy)
 * [copy](vars/copy.groovy)
 * [copyArtifacts](vars/copyArtifacts.groovy)
 * [deployAWS](vars/deployAWS.groovy)
 * [deployAWSNetwork](vars/deployAWSNetwork.groovy)
 * [deployAWSProd](vars/deployAWSProd.groovy)
 * [executeTests](vars/executeTests.groovy)
 * [getAvailabilityZone](vars/getAvailabilityZone.groovy)
 * [log](vars/log.groovy)
 * [mountEFS](vars/mountEFS.groovy)
 * [unmountEFS](vars/unmountEFS.groovy)
 * [writeEFSIP](vars/writeEFSIP.groovy)