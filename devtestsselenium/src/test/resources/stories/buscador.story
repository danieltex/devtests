Narrative:
O usuário usa o navegador para acessar buscadores e realizar pesquisas


Scenario: O usuário busca por Selenium no Google e encontra um resultado
Given uma página de busca https://www.google.com
When usamos o campo de busca q para procurar por 'selenium'
Then conseguimos encontrar uma página como 'Selenium - Web Browser Automation'

Scenario: O usuário busca por JBehave no DuckDuckGo e encontra um resultado
Given uma página de busca https://duckduckgo.com/
When usamos o campo de busca q para procurar por 'JBehave'
Then conseguimos encontrar uma página como 'What is JBehave'

Scenario: O usuário busca por notebook i7 no Buscapé e encontra um resultado
Given uma página de busca https://www.buscape.com.br/
When usamos o campo de busca produto para procurar por 'notebook i7'
Then conseguimos encontrar uma página como 'Core i7'

