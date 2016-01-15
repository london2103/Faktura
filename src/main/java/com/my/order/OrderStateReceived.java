package com.my.order;

import com.my.executor.InvalidStateException;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by marcin on 07.01.16.
 */

@Entity
@DiscriminatorValue("RE")
public class OrderStateReceived extends OrderState {

    public OrderStateReceived() {
        orderStateType = OrderStateType.RECEIVED;
    }

    @Override
    public void cancel() throws InvalidStateException {
        throw new InvalidStateException();

    }

    @Override
    public void send() throws InvalidStateException {
        throw new InvalidStateException();

    }

    @Override
    public void pay() throws InvalidStateException {
        throw new InvalidStateException();

    }

    @Override
    public void complete() throws InvalidStateException {
        throw new InvalidStateException();
    }

    @Override
    public void unableToComplete() throws InvalidStateException {
        throw new InvalidStateException();

    }
}
