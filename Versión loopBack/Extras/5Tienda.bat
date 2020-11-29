set cb="tstTiendaElectronica.jar"

if [%1] NEQ [] goto conHost
java -Djava.rmi.server.codebase=file:///%cb% -jar %cb% tsttiendaelectronica.Master localhost reporta
goto fin

:conHost
java -Djava.rmi.server.codebase=file:///%cb% -jar %cb% tsttiendaelectronica.Master %1 reporta
:fin


