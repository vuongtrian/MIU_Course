package com.FinalProject;

public interface IApplicationEventPublisher {
	void publishEvent(NewTransactionEvent event);
}
