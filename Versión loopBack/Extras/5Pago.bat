set cb="tstPagoOnline.jar"

if [%1] NEQ [] goto conHost
java -Djava.rmi.server.codebase=file:///%cb% -jar %cb% tstpagoonline.Master localhost reporta
goto fin

:conHost
java -Djava.rmi.server.codebase=file:///%cb% -jar %cb% tstpagoonline.Master %1 reporta
:fin


