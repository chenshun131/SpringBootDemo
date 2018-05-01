package com.chenshun.consumer.util.command;

import com.chenshun.consumer.bean.User;
import com.netflix.hystrix.HystrixObservableCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

/**
 * User: chenshun131 <p />
 * Time: 18/4/30 15:38  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class UserObservableCommand extends HystrixObservableCommand<User> {

    private RestTemplate restTemplate;

    private Long id;

    public UserObservableCommand(Setter setter, RestTemplate restTemplate, Long id) {
        super(setter);
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected Observable<User> construct() {
        return Observable.unsafeCreate(subscriber -> {
            try {
                if (!subscriber.isUnsubscribed()) {
                    ResponseEntity<User> responseEntity =
                            restTemplate.getForEntity("http://HELLO-SERVICE-GROUP/hello/user?id={1}", User.class, id);
                    User user = responseEntity.getBody();
                    subscriber.onNext(user);
                    subscriber.onCompleted();
                }
            } catch (RestClientException e) {
                e.printStackTrace();
                subscriber.onError(e);
            }
        });
    }

    @Override
    protected Observable<User> resumeWithFallback() {
        return Observable.error(new Throwable("failure from CommandThatFailsFast"));
    }

}
