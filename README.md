Pour la technique SOAP, on a recourt a cette technique puisqu'elle nous a permet de communiquer en se basant sur xml qui definit le fichier wsdl qui presente le contrat entre le client et le serveur.

cette technique aussi possede une architechture en couche resemblant à celle de rest dont on a la couche Model prsentant les tables de base de données et la couche dao presentant les methodes de
liaison entre la logique metier  a appliquer et les entites de la base de données.
et ici apprait la difference entre REST et soap , dont ona la couche services presentant les interfaces des ervices à exposer annotées pas @webservice es ses methodes annotées par @wevmethod 
et la classe de son implementation annotées par @webservice (@webservice : pour montere qu'il s'agit d'un service web)

puis par le serveur on a pu deployer notre service a l'aide de la methode endpoint.publish . et grace a cette derniere ona pu acceder a wsdl a partir des url.
dont on a tout d'abord definit les urls de bases dans serverJWS et  apres les urls specifique pour chque endpoint.
ces wsdl decrivent les operations, les types de donneés et les protocoles utilisées 

Et finalement on a testé avec SoapUI representant notre client . dont on a creer un projet pour chaque endpoint en lui attribuant l'url et il gere automatiquement les requetes
