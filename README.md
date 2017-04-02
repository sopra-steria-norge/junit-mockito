# Introduksjon til JUnit og Mockito

Kodegjennomgang. 

For mer informasjon om mockito - se her: https://github.com/mockito/mockito/wiki

* Produksjonskode testes ikke når du mocker - vær obs på 'for mye mocking'
* Ikke mock domeneobjekter, vo etc.  - bruk testdatabuildere e.l. isteden (gjerne med randomisert data)
* Det er generelt ønskelig å verifisere tilstand - ikke interaksjon - interaksjon kun unntaksvis. 
* Mocker er velegnet for å isolere eksterne integrasjoner. 
* Mocker <b>kan</b> benyttes for å unngå kall mot database, filsystem etc, men det er ofte bedre å benytte h2 e.l. 
* Mocker <b>kan</b> benyttes for å isolere avhengigheter for å teste en klasse i isolasjon (men se 1. punkt)

 


