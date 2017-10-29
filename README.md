# MARCO27 AEM 6.2

= AEM 6.2
cd ~/dev/myStash/aem62-servers
mvn cq-start

= DEPLOY into AEM SERVERS
mvn clean install -Pserver-package-deploy -Dcq.server=http://localhost:6200
mvn clean install -Pserver-package-deploy -Dcq.server=http://localhost:6201

= JSPINFO
http://localhost:6200/editor.html/content/m27/jspinfo.html
http://localhost:6200/content/m27/jspinfo.html
http://localhost:6201/content/m27/jspinfo.html

= HTLINFO
http://localhost:6200/editor.html/content/m27/htlinfo.html
http://localhost:6200/content/m27/htlinfo.html
http://localhost:6201/content/m27/htlinfo.html

= HTLTEMPLATE
http://localhost:6200/editor.html/content/m27/htltemplate.html
http://localhost:6200/content/m27/htltemplate.html
http://localhost:6201/content/m27/htltemplate.html