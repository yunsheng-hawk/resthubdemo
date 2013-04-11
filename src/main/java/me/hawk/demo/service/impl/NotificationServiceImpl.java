package me.hawk.demo.service.impl;

import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import me.hawk.demo.service.NotificationService;
@Named("notificationService")
public class NotificationServiceImpl implements NotificationService {
	private Log logger = LogFactory.getLog(getClass());

	@Override
	public void sendMessage(String email, String message) {
		logger.info("send mail to " + email + ", msg:" + message);
	}

}
