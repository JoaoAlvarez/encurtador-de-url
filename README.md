# encurtador-de-url
Foi utilizado :springboot2 e mongodb

Desafio:
Serviço RESTful que ao enviar uma URL qualquer para um endpoint, este deverá retornar um link encurtado desta URL.
Essa URL ao ser acessada, deverá redirecionar para a url original. 
Um outro endpoint a ser criado deverá retornar estatísticas de acessos a url selecionada.

endPoints:

rota de insert = "/" usando metodo POST: deverá ser enviar um Json no corpo da requisição com o atributo "url" e valor da url que deseja encurtar
exemplo: {"url": "http://facebook.com.br"}

rota de redirecionamento = "/" usando metodo GET : devera ser enviado o codigo referencia da url encurtada.
exemplo : http://localhost:8080/Y6WhrOsXCjfv7HyB

rota de statísticas de acessos = "/historico" : devera ser enviado o codigo referencia da url encurtada.
exemplo : http://localhost:8080/historico/Y6WhrOsXCjfv7HyB


