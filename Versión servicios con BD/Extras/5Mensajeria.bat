set cb="tstMensajeriaExpress.jar"

if [%1] NEQ [] goto conHost
java -Djava.rmi.server.codebase=file:///%cb% -jar %cb% tstmensajeriaexpress.Master localhost reporta
goto fin

:conHost
java -Djava.rmi.server.codebase=file:///%cb% -jar %cb% tstmensajeriaexpress.Master %1 reporta
:fin


