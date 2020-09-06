# OSExecPlugin
OSExecPlugin for JSPWiki [http://jspwiki.apache.org/]

Plugin to call OS Commands and to show Java System Properties.

## Example

An example CopyrightNotice page:

> [{OSExec systemproperty='java.vm.name'}] [{OSExec systemproperty='java.version'}] - 
[{OSExec systemproperty='os.name'}] [{OSExec systemproperty='os.version'}] -
[{OSExec commandline='uptime'}]

which outputs

> OpenJDK 64-Bit Server VM 11.0.8 - FreeBSD 12.1-RELEASE-p9 - 1:25PM up 3 days, 15:33, 3 users, load averages: 0.94, 0.80, 0.76

## License

Apache License 2.0