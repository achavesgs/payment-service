localhost:8080/save

{
      "idTransacao":1,
      "nroCartao":"157443",
      "validadeCartao":"22/03/2019",
      "valorCompra":200.50,
      "bandeira":"cielo"
}

http://localhost:8080/save/1

localhost:8080/findById/1
{"idTransacao":1,"nroCartao":157443,"validadeCartao":"22/03/2019","valorCompra":200.50,"bandeira":"cielo"}

localhost:8080/update
{
      "idTransacao":1,
      "nroCartao":"6666",
      "validadeCartao":"22/03/2019",
      "valorCompra":200.50,
      "bandeira":"cielo"


}


localhost:8080/findById/1

{"idTransacao":1,"nroCartao":6666,"validadeCartao":"22/03/2019","valorCompra":200.50,"bandeira":"cielo"}
