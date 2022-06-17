package com.santiagoposadag.cs50.receiverconsumer.config;





import com.santiagoposadag.cs50.receiverconsumer.usecases.RecieveFromBuyActionQueueUseCase;
import com.santiagoposadag.cs50.receiverconsumer.usecases.RecieveFromGeneralActionQueueUseCase;
import com.santiagoposadag.cs50.receiverconsumer.usecases.RecieveFromSellActionQueueUseCase;
import com.santiagoposadag.cs50.receiverconsumer.usecases.RecieveInfoFromUserQueueUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String GENERAL_QUEUE = "action.general";
    public static final String SELL_QUEUE = "action.sell";
    public static final String BUY_QUEUE = "action.buy";
    public static final String USER_QUEUE = "action.user";

    @Autowired
    RecieveFromGeneralActionQueueUseCase generalAction;

    @Autowired
    RecieveFromBuyActionQueueUseCase buyAction;

    @Autowired
    RecieveFromSellActionQueueUseCase sellAction;

    @Autowired
    RecieveInfoFromUserQueueUseCase userAction;



    @RabbitListener(queues = {GENERAL_QUEUE})
    public void listenerOfGenralActions(String received){
        generalAction.receiveMessage(received);
    }

    @RabbitListener(queues = SELL_QUEUE)
    public void listenerOfSellActions(String received){
        sellAction.receiveMessage(received);
    }

    @RabbitListener(queues = BUY_QUEUE)
    public void listenerOfBuyActions(String received){
        buyAction.receiveMessage(received);
    }

    @RabbitListener(queues = USER_QUEUE)
    public void listenerOfUserActions(String received) {userAction.receiveMessage(received);}

}
