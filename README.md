# MARCO27 AEM 6.2

## AEM 6.2
cd ~/dev/myStash/aem62-servers
mvn cq-start

## DEPLOY into AEM SERVERS
mvn clean install -Pserver-package-deploy -Dcq.server=http://localhost:6200
mvn clean install -Pserver-package-deploy -Dcq.server=http://localhost:6201

## JSPINFO
http://localhost:6200/editor.html/content/m27/jspinfo.html
http://localhost:6200/content/m27/jspinfo.html
http://localhost:6201/content/m27/jspinfo.html

## HTLINFO
http://localhost:6200/editor.html/content/m27/htlinfo.html
http://localhost:6200/content/m27/htlinfo.html
http://localhost:6201/content/m27/htlinfo.html

## HTLTEMPLATE
http://localhost:6200/editor.html/content/m27/htltemplate.html
http://localhost:6200/content/m27/htltemplate.html
http://localhost:6201/content/m27/htltemplate.html

## JORA
http://localhost:6200/editor.html/content/m27/jora.html
http://localhost:6200/content/m27/jora.html
http://localhost:6201/content/m27/jora.html
## JORA SERVLET
http://localhost:6201/content/m27/jora.jora.html

## TEXTANDIMAGE
http://localhost:6200/editor.html/content/m27/textandimage.html
http://localhost:6200/content/m27/textandimage.html
http://localhost:6201/content/m27/textandimage.html

## TEXTIMAGE
http://localhost:6200/editor.html/content/m27/textimage.html
http://localhost:6200/content/m27/textimage.html
http://localhost:6201/content/m27/textimage.html

## MIGRATION TOOL
http://localhost:6200/editor.html/etc/migrationtool.html
http://localhost:6200/etc/migrationtool.html
http://localhost:6201/etc/migrationtool.html

## BASE ClientLib
http://localhost:6200/editor.html/content/m27/baseclientlib.html
http://localhost:6200/content/m27/baseclientlib.html
http://localhost:6201/content/m27/baseclientlib.html

## BASE OSGi
http://localhost:6200/editor.html/content/m27/baseosgi.html
http://localhost:6200/content/m27/baseosgi.html
http://localhost:6201/content/m27/baseosgi.html
