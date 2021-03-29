# Release Note

|  Versão |  Data Implantação | Data descontinuação  | Revisor | Dependencias |
| ------------ | ------------ | ------------ | ------------ | ------------ |
|  2.5.0 | 12/08/2020  | - | Tiago Ribeiro | Bff-App-Acesso  |
|  2.5.1 | - | - | Tiago Ribeiro |  - |
|        |             |   |               |    |



### Features:

#### Release_2.5.1

Pacote que corrige o retorno do método de handler error **handlerCodigoSegurancaException**
agora retorna o objeto **InformacaoCodigoSeguranca** invés de **~~InformacaoContadorConta~~**.


#### Release_2.5.0

Pacote gerado com 5 novas operações:
Data de implantação: 12/08/2020

**Segundo fator de autenticação:**

 POST: /usuario/{cpfCnpj}/envia/codigo/acesso/celular
 
 POST: /usuario/{cpfCnpj}/envia/codigo/acesso/email
 
 POST: /usuario/{cpfCnpj}/valida/codigo/acesso/{pin}

**Acesso Falha:**

POST: /usuario/{cpfCnpj}/acesso/falha

**Acesso Sucesso:**

POST /usuario/{cpfCnpj}/acesso/sucesso


