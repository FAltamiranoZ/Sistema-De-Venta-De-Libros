echo off
echo ejecuta el estresador para sembrar los clientes
echo uso:
echo 4_estresa NumCltes NumSolicitudesPorClte HOSTNAME (en caso de omitirlo se usa localhost, si se omiten los clientes usa 15 y el localhost)
echo on

set cb=%cd%\tstTiendaElectronica.jar

if [%1] NEQ [] goto conclientes
estresador 20 -Djava.rmi.server.codebase=file:%cb% -jar %cb% tsttiendaelectronica.Cliente localhost 200
goto fin

:conclientes

if [%2] NEQ [] goto consolicitudes
estresador %1 -Djava.rmi.server.codebase=file:%cb% -jar %cb% tsttiendaelectronica.Cliente localhost 200
goto fin

:consolicitudes
if [%3] NEQ [] goto conHost
estresador %1 -Djava.rmi.server.codebase=file:%cb% -jar %cb% tsttiendaelectronica.Cliente localhost %2
goto fin

:conHost
if [%4] NEQ [] goto conTiempo
estresador %1 -Djava.rmi.server.codebase=file:///%cb% -jar %cb% tsttiendaelectronica.Cliente %3 %2

:conTiempo
estresador %1 -Djava.rmi.server.codebase=file:///%cb% -jar %cb% tsttiendaelectronica.Cliente %3 %2 %4


:fin