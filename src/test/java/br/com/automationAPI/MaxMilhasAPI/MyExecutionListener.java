package br.com.automationAPI.MaxMilhasAPI;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import java.util.Date;

public class MyExecutionListener extends RunListener {

    //Variáveis para pegar o início e o Fim dos testes
    long startTime;
    long endTime;

    @Override
    public void testRunStarted(Description description) throws Exception {
        //Pegar o ínicio do teste
        startTime = new Date().getTime();
        //Imprimi na tela a quantidade de casos de testes executados
        System.out.println("Suite de Testes Iniciada! Número de Casos de Testes: " + description.testCount() + "\n");
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        //Pegar oo tempo final da execução do teste
        endTime = new Date().getTime();
        
        //Imprimi as linhas de cada teste na medida que são executados
        System.out.println("Testes finalizados! Numeros de Casos de Testes executados: " + result.getRunCount());
        long elapsedSeconds = (endTime-startTime)/1000;
        System.out.println("Duração da execução dos Casos de Testes: " + elapsedSeconds +" segundos");
    }

    @Override
    public void testStarted(Description description) throws Exception {
        //Imprimi o nome do caso de teste no momento que for executado.
        System.out.println("Caso de Teste " + description.getMethodName() + " iniciando...");
    }

    @Override
    public void testFinished(Description description) throws Exception {
        //Imprimi o nome do caso de teste quando terminar a execução.
        System.out.println("Caso de Teste " +description.getMethodName() + " finalizado...\n");
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        //Imprimi o nome do caso de teste no momento que o teste falhar.
        System.out.println("Caso de Teste executado com FALHA!!!");
        System.out.println(failure.getMessage());
    }

   
}