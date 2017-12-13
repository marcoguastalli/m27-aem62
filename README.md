# MARCO27 AEM 6.2

## AEM 6.2
cd ~/dev/myStash/aem62-servers
mvn cq-start

##### Translations
http://localhost:6200/libs/cq/i18n/translator.html

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
##### DumpLibs
http://localhost:6200/libs/granite/ui/content/dumplibs.html
http://localhost:6200/libs/granite/ui/content/dumplibs.test.html?categories=m27.author
http://localhost:6201/libs/granite/ui/content/dumplibs.test.html?categories=m27.publish

## BASE OSGi
http://localhost:6200/editor.html/content/m27/baseosgi.html
http://localhost:6200/content/m27/baseosgi.html
http://localhost:6201/content/m27/baseosgi.html
##### OSGi Configuration Settings
https://helpx.adobe.com/experience-manager/6-2/sites/deploying/using/osgi-configuration-settings.html
https://helpx.adobe.com/experience-manager/6-2/sites/deploying/using/osgi-configuration-settings.html#AEMHTMLLibraryManager

## ISBN
http://localhost:6200/editor.html/content/m27/isbn.html
http://localhost:6200/content/m27/isbn.html
http://localhost:6201/content/m27/isbn.html

## SADNESS
http://localhost:6200/editor.html/content/m27/sadness.html?sadness=marco
http://localhost:6200/content/m27/sadness.html?sadness=marco
http://localhost:6201/content/m27/sadness.html?sadness=marco

## JsonXML
http://localhost:6200/editor.html/content/m27/jsonxml.html
http://localhost:6200/content/m27/jsonxml.html
http://localhost:6201/content/m27/jsonxml.html
##### Require a System-User with content-write permissions
Create using http://localhost:6201/crx/explorer/index.jsp
Add permissions using http://localhost:6201/useradmin adding it in the content-author group
Then in http://localhost:6201/crx/de/index.jsp#/content/m27/jsonxml/jcr%3Acontent/par/jsonxml the content will be created
