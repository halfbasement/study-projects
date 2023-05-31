package hello.pay;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrdPayClient implements PayClient{

    @Override
    public void pay(int money) {
        log.info("운ㅛ 결제 money={}",money);
    }
}
