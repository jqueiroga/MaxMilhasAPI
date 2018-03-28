package br.com.automationAPI.MaxMilhasAPI;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@RunWith(MyTestAPI.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testAPI {

	
	
	//URI fica da API a ser testada
	public testAPI() {
		baseURI = "https://flight-pricing-hmg.maxmilhas.com.br";
	}

	//Método para pegar a data atual
	private String getDateTime() { 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		Date date = new Date(); 
		return dateFormat.format(date); 
	}
	
	@Test
	/*Test to validate a Search with Infant Greater than Adult*/
	public void testAdultsGreaterInfantsValidation() {
		String myJson = "{\"tripType\":\"RT\",\"from\":\"CNF\",\"to\":\"GRU\",\"adults\":1,\"children\":0,\"infants\":2,\"outboundDate\":\"2018-05-01\",\"inboundDate\":\"2018-05-21\",\"cabin\":\"EC\"}";
		
		System.out.println(">>>>> Realizar busca com um adult e dois infants <<<<<");
		
		given()
			.contentType("application/json")
			.headers("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJtYXhtaWxoYXMuY29tLmJyIiwiaWF0IjoxNTIxNTc4MTg3LCJleHAiOjE1MjQyNTY1ODgsImF1ZCI6InRlc3RlLXFhIiwic3ViIjoidGVzdGUtcWEiLCJlbnYiOiJobWcifQ.-Q04QmHo_Hoy3rq0y3V3hhyIeqdzqTlo27rLkhAOI7s")
			.body(myJson)
		.when()
			.post("/search")
		.then()
			.statusCode(422)
			.body("type", containsString("AdultsGreaterInfantsValidationError"))
			.body("message", containsString("The number of adults must be greater than that of infants"));
	
		//Se o Caso de Teste chegar a esse ponto é que foi executado com sucesso.
		System.out.println("Caso de Teste executado com SUCESSO !!!");
		
	}

	@Test
	/*Test to validate a Search with Adult quantity Greater than nine (9)*/
	public void testPassengersQuantityValidation() {
		String myJson = "{\"tripType\":\"RT\",\"from\":\"CNF\",\"to\":\"GRU\",\"adults\":10,\"children\":0,\"infants\":0,\"outboundDate\":\"2018-05-01\",\"inboundDate\":\"2018-05-21\",\"cabin\":\"EC\"}";

		System.out.println(">>>>> Realizar busca com 10 adults <<<<<");
		
		given()
			.contentType("application/json")
			.headers("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJtYXhtaWxoYXMuY29tLmJyIiwiaWF0IjoxNTIxNTc4MTg3LCJleHAiOjE1MjQyNTY1ODgsImF1ZCI6InRlc3RlLXFhIiwic3ViIjoidGVzdGUtcWEiLCJlbnYiOiJobWcifQ.-Q04QmHo_Hoy3rq0y3V3hhyIeqdzqTlo27rLkhAOI7s")
			.body(myJson)
		.when()
			.post("/search")
		.then()
			.statusCode(422)
			.body("type", containsString("PassengersQuantityValidationError"))
			.body("message", containsString("The total number of passengers exceeds the maximum 9 allowed"));
		
		//Se o Caso de Teste chegar a esse ponto é que foi executado com sucesso.
		System.out.println("Caso de Teste executado com SUCESSO !!!");
	}
	
	@Test
	/*Test to validate a Search with Airport(from) code invalid*/
	public void testResourceNotFoundFrom() {
		String myJson = "{\"tripType\":\"RT\",\"from\":\"AAA\",\"to\":\"GRU\",\"adults\":1,\"children\":0,\"infants\":0,\"outboundDate\":\"2018-05-01\",\"inboundDate\":\"2018-05-21\",\"cabin\":\"EC\"}";

		System.out.println(">>>>> Realizar busca de aeroporto DE ORIGEM inexistente (AAA)  <<<<<");
		
		given()
			.contentType("application/json")
			.headers("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJtYXhtaWxoYXMuY29tLmJyIiwiaWF0IjoxNTIxNTc4MTg3LCJleHAiOjE1MjQyNTY1ODgsImF1ZCI6InRlc3RlLXFhIiwic3ViIjoidGVzdGUtcWEiLCJlbnYiOiJobWcifQ.-Q04QmHo_Hoy3rq0y3V3hhyIeqdzqTlo27rLkhAOI7s")
			.body(myJson)
		.when()
			.post("/search")
		.then()
			.statusCode(404)
			.body("type", containsString("ResourceNotFoundError"))
			.body("message", containsString("Could not create search resource due to some incorrect parameter."));
		
		//Se o Caso de Teste chegar a esse ponto é que foi executado com sucesso.
		System.out.println("Caso de Teste executado com SUCESSO !!!");
	}
	
	@Test
	/*
	Test to validate a Search with Airport(To) code invalid*/
	public void testResourceNotFoundTo() {
		String myJson = "{\"tripType\":\"RT\",\"from\":\"GRU\",\"to\":\"AAA\",\"adults\":1,\"children\":0,\"infants\":0,\"outboundDate\":\"2018-05-01\",\"inboundDate\":\"2018-05-21\",\"cabin\":\"EC\"}";

		System.out.println(">>>>> Realizar busca de aeroporto DE CHEGADA inexistente (AAA)  <<<<<");
		
		given()
			.contentType("application/json")
			.headers("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJtYXhtaWxoYXMuY29tLmJyIiwiaWF0IjoxNTIxNTc4MTg3LCJleHAiOjE1MjQyNTY1ODgsImF1ZCI6InRlc3RlLXFhIiwic3ViIjoidGVzdGUtcWEiLCJlbnYiOiJobWcifQ.-Q04QmHo_Hoy3rq0y3V3hhyIeqdzqTlo27rLkhAOI7s")
			.body(myJson)
		.when()
			.post("/search")
		.then()
			.statusCode(404)
			.body("type", containsString("ResourceNotFoundError"))
			.body("message", containsString("Could not create search resource due to some incorrect parameter."));
	
		//Se o Caso de Teste chegar a esse ponto é que foi executado com sucesso.
		System.out.println("Caso de Teste executado com SUCESSO !!!");
	}
	
	
	@Test
	/*
	Test to validate a Search with unavailability of Business Class in Avianca*/
	public void testUnavailableAviacaBusinessClass() {
		String myJson = "{\"tripType\":\"RT\",\"from\":\"CNF\",\"to\":\"GRU\",\"adults\":1,\"children\":0,\"infants\":0,\"outboundDate\":\"2018-05-01\",\"inboundDate\":\"2018-05-21\",\"cabin\":\"EX\"}";

		System.out.println(">>>>> Realizar busca de voo executivo para trecho de aeroportos nacionais <<<<<");
		
		given()
			.contentType("application/json")
			.headers("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJtYXhtaWxoYXMuY29tLmJyIiwiaWF0IjoxNTIxNTc4MTg3LCJleHAiOjE1MjQyNTY1ODgsImF1ZCI6InRlc3RlLXFhIiwic3ViIjoidGVzdGUtcWEiLCJlbnYiOiJobWcifQ.-Q04QmHo_Hoy3rq0y3V3hhyIeqdzqTlo27rLkhAOI7s")
			.body(myJson)
		.when()
			.post("/search")
		.then()
			.statusCode(200)
			.body("airlines.label", hasItems("avianca"))
			.body("airlines.status.message", hasItems("Indisponível para classe executiva"));
	
		//Se o Caso de Teste chegar a esse ponto é que foi executado com sucesso.
		System.out.println("Caso de Teste executado com SUCESSO !!!");
	}
	
	@Test
	/*
	Test to validate a Search with current date*/
	public void testSearchCurrentDate() {
		String currentDate = getDateTime();
		String myJson = "{\"tripType\":\"RT\",\"from\":\"CNF\",\"to\":\"GRU\",\"adults\":1,\"children\":0,\"infants\":0,\"outboundDate\":\"" + currentDate +"\",\"inboundDate\":\""+ currentDate +"\",\"cabin\":\"EC\"}";

		System.out.println(">>>>> Realizar busca com data atual <<<<<");
				
		given()
			.contentType("application/json")
			.headers("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJtYXhtaWxoYXMuY29tLmJyIiwiaWF0IjoxNTIxNTc4MTg3LCJleHAiOjE1MjQyNTY1ODgsImF1ZCI6InRlc3RlLXFhIiwic3ViIjoidGVzdGUtcWEiLCJlbnYiOiJobWcifQ.-Q04QmHo_Hoy3rq0y3V3hhyIeqdzqTlo27rLkhAOI7s")
			.body(myJson)
		.when()
			.post("/search")
		.then()
			.statusCode(200)
			.body("airlines.label", hasItems("gol"))
			.body("airlines.status.message", hasItems("Somente partidas superiores a 24 horas"));
	
		//Se o Caso de Teste chegar a esse ponto é que foi executado com sucesso.
		System.out.println("Caso de Teste executado com SUCESSO !!!");
	}
	
	@Test
	/*
	Test to validate the format of contract*/
	public void testValitateContractFormat() {
		String myJson = "{\"tripType\":\"RT\",\"from\":\"CNF\",\"to\":\"GRU\",\"adults\":1,\"children\":0,\"infants\":0,\"outboundDate\":\"2018-05-01\",\"inboundDate\":\"2018-05-21\",\"cabin\":\"EC\"}";

		System.out.println(">>>>> Validar a estrutura do contrato <<<<<");
		
		given()
			.contentType("application/json")
			.headers("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJtYXhtaWxoYXMuY29tLmJyIiwiaWF0IjoxNTIxNTc4MTg3LCJleHAiOjE1MjQyNTY1ODgsImF1ZCI6InRlc3RlLXFhIiwic3ViIjoidGVzdGUtcWEiLCJlbnYiOiJobWcifQ.-Q04QmHo_Hoy3rq0y3V3hhyIeqdzqTlo27rLkhAOI7s")
			.body(myJson)
		.when()
			.post("/search")
		.then()
			.body(matchesJsonSchemaInClasspath("schema_Json.json"));
			
		//Se o Caso de Teste chegar a esse ponto é que foi executado com sucesso.
		System.out.println("Caso de Teste executado com SUCESSO !!!");
	}
}
