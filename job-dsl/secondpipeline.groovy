def app_name = 'petclinic'
/*
    service/component build job
*/
pipelineJob("${app_name}-pipeline") {
    concurrentBuild(false)
    logRotator {
        daysToKeep(14)
    }
    triggers {
        scm('H/1 * * * *')
    }
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        github("hamid2013/spring-${app_name}", "https")
                    }
                    branch('refs/heads/master')
                }
            }
            scriptPath("Jenkinsfile")
        }
    }
}