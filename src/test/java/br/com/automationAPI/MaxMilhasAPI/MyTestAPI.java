package br.com.automationAPI.MaxMilhasAPI;


import org.junit.AssumptionViolatedException;
import org.junit.internal.runners.model.EachTestNotifier;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
 
public class MyTestAPI extends BlockJUnit4ClassRunner {
 
    public MyTestAPI(Class<?> klass) throws InitializationError {
        super(klass);
    }
 
    @Override
    public void run (RunNotifier notifier){
    	
    	System.out.println("............. Teste Técnico QA - Automação API ;...........");
        System.out.println("Iniciando a execução dos Casos de Teste()");
        //Adicionando o Listener. 
        notifier.addListener(new MyExecutionListener());
 
        //Pega o notificador de cada teste
        EachTestNotifier testNotifier = new EachTestNotifier(notifier,
                getDescription());
        try {
            // Para capturar o método testRunStarted no início do teste, adicionaremos o código abaixo
            //Invoca método testRunStarted() 
            notifier.fireTestRunStarted(getDescription());
            Statement statement = classBlock(notifier);
            statement.evaluate();
        } catch (AssumptionViolatedException e) {
            testNotifier.fireTestIgnored();
        } catch (StoppedByUserException e) {
            throw e;
        } catch (Throwable e) {
            testNotifier.addFailure(e);
        }
    }
}