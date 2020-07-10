@REM ----------------------------------------------------------------------------
@REM Copyright 2001-2004 The Apache Software Foundation.
@REM
@REM Licensed under the Apache License, Version 2.0 (the "License");
@REM you may not use this file except in compliance with the License.
@REM You may obtain a copy of the License at
@REM
@REM      http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing, software
@REM distributed under the License is distributed on an "AS IS" BASIS,
@REM WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM See the License for the specific language governing permissions and
@REM limitations under the License.
@REM ----------------------------------------------------------------------------
@REM

@echo off

set ERROR_CODE=0

:init
@REM Decide how to startup depending on the version of windows

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" @setlocal

@REM -- 4NT shell
if "%eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set CMD_LINE_ARGS=%*
goto WinNTGetScriptDir

@REM The 4NT Shell from jp software
:4NTArgs
set CMD_LINE_ARGS=%$
goto WinNTGetScriptDir

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto Win9xGetScriptDir
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto Win9xApp

:Win9xGetScriptDir
set SAVEDIR=%CD%
%0\
cd %0\..\.. 
set BASEDIR=%CD%
cd %SAVEDIR%
set SAVE_DIR=
goto repoSetup

:WinNTGetScriptDir
set BASEDIR=%~dp0\..

:repoSetup


if "%JAVACMD%"=="" set JAVACMD=java

if "%REPO%"=="" set REPO=%BASEDIR%\repo

set CLASSPATH="%BASEDIR%"\etc;"%REPO%"\org\telegram\telegrambots\4.9\telegrambots-4.9.jar;"%REPO%"\org\telegram\telegrambots-meta\4.9\telegrambots-meta-4.9.jar;"%REPO%"\com\google\inject\guice\4.2.2\guice-4.2.2.jar;"%REPO%"\javax\inject\javax.inject\1\javax.inject-1.jar;"%REPO%"\aopalliance\aopalliance\1.0\aopalliance-1.0.jar;"%REPO%"\com\google\guava\guava\28.1-jre\guava-28.1-jre.jar;"%REPO%"\com\google\guava\failureaccess\1.0.1\failureaccess-1.0.1.jar;"%REPO%"\com\google\guava\listenablefuture\9999.0-empty-to-avoid-conflict-with-guava\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;"%REPO%"\com\google\code\findbugs\jsr305\3.0.2\jsr305-3.0.2.jar;"%REPO%"\org\checkerframework\checker-qual\2.8.1\checker-qual-2.8.1.jar;"%REPO%"\com\google\errorprone\error_prone_annotations\2.3.2\error_prone_annotations-2.3.2.jar;"%REPO%"\com\google\j2objc\j2objc-annotations\1.3\j2objc-annotations-1.3.jar;"%REPO%"\org\codehaus\mojo\animal-sniffer-annotations\1.18\animal-sniffer-annotations-1.18.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-annotations\2.9.0\jackson-annotations-2.9.0.jar;"%REPO%"\com\fasterxml\jackson\jaxrs\jackson-jaxrs-json-provider\2.9.7\jackson-jaxrs-json-provider-2.9.7.jar;"%REPO%"\com\fasterxml\jackson\jaxrs\jackson-jaxrs-base\2.9.7\jackson-jaxrs-base-2.9.7.jar;"%REPO%"\com\fasterxml\jackson\module\jackson-module-jaxb-annotations\2.9.7\jackson-module-jaxb-annotations-2.9.7.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-core\2.9.7\jackson-core-2.9.7.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-databind\2.9.7\jackson-databind-2.9.7.jar;"%REPO%"\org\glassfish\jersey\inject\jersey-hk2\2.27\jersey-hk2-2.27.jar;"%REPO%"\org\glassfish\jersey\core\jersey-common\2.27\jersey-common-2.27.jar;"%REPO%"\org\glassfish\hk2\osgi-resource-locator\1.0.1\osgi-resource-locator-1.0.1.jar;"%REPO%"\org\glassfish\hk2\hk2-locator\2.5.0-b42\hk2-locator-2.5.0-b42.jar;"%REPO%"\org\glassfish\hk2\external\aopalliance-repackaged\2.5.0-b42\aopalliance-repackaged-2.5.0-b42.jar;"%REPO%"\org\glassfish\hk2\hk2-api\2.5.0-b42\hk2-api-2.5.0-b42.jar;"%REPO%"\org\glassfish\hk2\hk2-utils\2.5.0-b42\hk2-utils-2.5.0-b42.jar;"%REPO%"\org\javassist\javassist\3.22.0-CR2\javassist-3.22.0-CR2.jar;"%REPO%"\org\glassfish\jersey\media\jersey-media-json-jackson\2.27\jersey-media-json-jackson-2.27.jar;"%REPO%"\org\glassfish\jersey\ext\jersey-entity-filtering\2.27\jersey-entity-filtering-2.27.jar;"%REPO%"\org\glassfish\jersey\containers\jersey-container-grizzly2-http\2.27\jersey-container-grizzly2-http-2.27.jar;"%REPO%"\org\glassfish\hk2\external\javax.inject\2.5.0-b42\javax.inject-2.5.0-b42.jar;"%REPO%"\org\glassfish\grizzly\grizzly-http-server\2.4.0\grizzly-http-server-2.4.0.jar;"%REPO%"\org\glassfish\grizzly\grizzly-http\2.4.0\grizzly-http-2.4.0.jar;"%REPO%"\org\glassfish\grizzly\grizzly-framework\2.4.0\grizzly-framework-2.4.0.jar;"%REPO%"\javax\ws\rs\javax.ws.rs-api\2.1\javax.ws.rs-api-2.1.jar;"%REPO%"\org\glassfish\jersey\core\jersey-server\2.27\jersey-server-2.27.jar;"%REPO%"\org\glassfish\jersey\core\jersey-client\2.27\jersey-client-2.27.jar;"%REPO%"\org\glassfish\jersey\media\jersey-media-jaxb\2.27\jersey-media-jaxb-2.27.jar;"%REPO%"\javax\annotation\javax.annotation-api\1.3.2\javax.annotation-api-1.3.2.jar;"%REPO%"\javax\validation\validation-api\2.0.1.Final\validation-api-2.0.1.Final.jar;"%REPO%"\org\json\json\20180813\json-20180813.jar;"%REPO%"\org\apache\httpcomponents\httpclient\4.5.6\httpclient-4.5.6.jar;"%REPO%"\org\apache\httpcomponents\httpcore\4.4.10\httpcore-4.4.10.jar;"%REPO%"\commons-codec\commons-codec\1.11\commons-codec-1.11.jar;"%REPO%"\org\apache\httpcomponents\httpmime\4.5.6\httpmime-4.5.6.jar;"%REPO%"\commons-io\commons-io\2.6\commons-io-2.6.jar;"%REPO%"\org\slf4j\slf4j-api\1.7.25\slf4j-api-1.7.25.jar;"%REPO%"\org\telegram\telegrambotsextensions\4.9\telegrambotsextensions-4.9.jar;"%REPO%"\org\springframework\boot\spring-boot-starter-web\2.1.1.RELEASE\spring-boot-starter-web-2.1.1.RELEASE.jar;"%REPO%"\org\springframework\boot\spring-boot-starter\2.1.1.RELEASE\spring-boot-starter-2.1.1.RELEASE.jar;"%REPO%"\org\springframework\boot\spring-boot\2.1.1.RELEASE\spring-boot-2.1.1.RELEASE.jar;"%REPO%"\org\springframework\boot\spring-boot-autoconfigure\2.1.1.RELEASE\spring-boot-autoconfigure-2.1.1.RELEASE.jar;"%REPO%"\org\springframework\boot\spring-boot-starter-logging\2.1.1.RELEASE\spring-boot-starter-logging-2.1.1.RELEASE.jar;"%REPO%"\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;"%REPO%"\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;"%REPO%"\org\apache\logging\log4j\log4j-to-slf4j\2.11.1\log4j-to-slf4j-2.11.1.jar;"%REPO%"\org\apache\logging\log4j\log4j-api\2.11.1\log4j-api-2.11.1.jar;"%REPO%"\org\slf4j\jul-to-slf4j\1.7.25\jul-to-slf4j-1.7.25.jar;"%REPO%"\org\springframework\spring-core\5.1.3.RELEASE\spring-core-5.1.3.RELEASE.jar;"%REPO%"\org\springframework\spring-jcl\5.1.3.RELEASE\spring-jcl-5.1.3.RELEASE.jar;"%REPO%"\org\yaml\snakeyaml\1.23\snakeyaml-1.23.jar;"%REPO%"\org\springframework\boot\spring-boot-starter-json\2.1.1.RELEASE\spring-boot-starter-json-2.1.1.RELEASE.jar;"%REPO%"\com\fasterxml\jackson\datatype\jackson-datatype-jdk8\2.9.7\jackson-datatype-jdk8-2.9.7.jar;"%REPO%"\com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.9.7\jackson-datatype-jsr310-2.9.7.jar;"%REPO%"\com\fasterxml\jackson\module\jackson-module-parameter-names\2.9.7\jackson-module-parameter-names-2.9.7.jar;"%REPO%"\org\springframework\boot\spring-boot-starter-tomcat\2.1.1.RELEASE\spring-boot-starter-tomcat-2.1.1.RELEASE.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-core\9.0.13\tomcat-embed-core-9.0.13.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-el\9.0.13\tomcat-embed-el-9.0.13.jar;"%REPO%"\org\apache\tomcat\embed\tomcat-embed-websocket\9.0.13\tomcat-embed-websocket-9.0.13.jar;"%REPO%"\org\hibernate\validator\hibernate-validator\6.0.13.Final\hibernate-validator-6.0.13.Final.jar;"%REPO%"\org\jboss\logging\jboss-logging\3.3.2.Final\jboss-logging-3.3.2.Final.jar;"%REPO%"\com\fasterxml\classmate\1.4.0\classmate-1.4.0.jar;"%REPO%"\org\springframework\spring-web\5.1.3.RELEASE\spring-web-5.1.3.RELEASE.jar;"%REPO%"\org\springframework\spring-beans\5.1.3.RELEASE\spring-beans-5.1.3.RELEASE.jar;"%REPO%"\org\springframework\spring-webmvc\5.1.3.RELEASE\spring-webmvc-5.1.3.RELEASE.jar;"%REPO%"\org\springframework\spring-aop\5.1.3.RELEASE\spring-aop-5.1.3.RELEASE.jar;"%REPO%"\org\springframework\spring-context\5.1.3.RELEASE\spring-context-5.1.3.RELEASE.jar;"%REPO%"\org\springframework\spring-expression\5.1.3.RELEASE\spring-expression-5.1.3.RELEASE.jar;"%REPO%"\org\example\telegramtouristbot\1.0-SNAPSHOT\telegramtouristbot-1.0-SNAPSHOT.jar
set EXTRA_JVM_ARGUMENTS=
goto endInit

@REM Reaching here means variables are defined and arguments have been captured
:endInit

%JAVACMD% %JAVA_OPTS% %EXTRA_JVM_ARGUMENTS% -classpath %CLASSPATH_PREFIX%;%CLASSPATH% -Dapp.name="telegramtouristbot" -Dapp.repo="%REPO%" -Dbasedir="%BASEDIR%" com.home.server.TelegramBot %CMD_LINE_ARGS%
if ERRORLEVEL 1 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
set ERROR_CODE=1

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set CMD_LINE_ARGS=
goto postExec

:endNT
@endlocal

:postExec

if "%FORCE_EXIT_ON_ERROR%" == "on" (
  if %ERROR_CODE% NEQ 0 exit %ERROR_CODE%
)

exit /B %ERROR_CODE%
