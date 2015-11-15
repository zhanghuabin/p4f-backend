// Register Status Listener
statusListener OnConsoleStatusListener


def otherAppenders  = ['console', 'otherDailyRollingFile']
def appAppenders    = ['console', 'appDailyRollingFile']

def commonAppenderNames = [
    'other',
    'app'
]
def individualAppenderNames = [
    'views'
]

def externalCategories = [
]

def patternLayout = '[USER:%X{user}] [DEVICE:%X{deviceType}] [SESSIONID:%X{sessionId}] [IP:%X{ip}] %d{HH:mm:ss.SSS} [%thread] %-5level %logger{30} - %msg %n'


def logFilePathPrefix = ('target' as File).exists() ? 'target/logs' : 'logs'

def maxLogArchiveHistoryDays = 180


// Appenders
appender('console', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = patternLayout
    }
}

(commonAppenderNames + individualAppenderNames).each { name ->
    createAppender name, logFilePathPrefix, maxLogArchiveHistoryDays, patternLayout
}


/**
 * Loggers
 * ROOT：other.log文件，每天归档，在产品环境下不会向console输出
 * 其他：写入app.log文件，每天归档，cheche包下的全用DEBUG级别，其他同上
 */
root WARN, otherAppenders

// internal
logger 'p4f', DEBUG, appAppenders


individualAppenderNames.each { name ->
    logger "p4f.$name", DEBUG, ["${name}DailyRollingFile"], false
}


// external
externalCategories.each { category ->
    logger category, DEBUG, appAppenders, false
}




private void createAppender(name, logFilePathPrefix, maxLogArchiveHistoryDays, patternLayout) {
    appender("${name}DailyRollingFile", RollingFileAppender) {
        file = "$logFilePathPrefix/${name}.log"
        rollingPolicy(TimeBasedRollingPolicy) {
            fileNamePattern = "$logFilePathPrefix/${name}.%d{yyyy-MM-dd}.gz"
            maxHistory = maxLogArchiveHistoryDays
        }
        encoder(PatternLayoutEncoder) {
            pattern = patternLayout
        }
    }
}
