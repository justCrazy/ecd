package com.ecd.tool;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class MessageSend {

	public static String myEmailAccount = "1062646428@qq.com";
	public static String myEmailPassword = "yrrkeczttzuxbehj";
	public static String myEmailSMTPHost = "smtp.qq.com";

	public static void sendMessage(String vText, String receiveMailAccount) throws Exception {
		// 1. 创建参数配置, 用于连接邮件服务器的参数配置
		Properties props = new Properties(); // 参数配置
		props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
		props.setProperty("mail.smtp.host", myEmailSMTPHost); // 发件人的邮箱的 SMTP 服务器地址
		props.setProperty("mail.smtp.auth", "true"); // 需要请求认证

		final String smtpPort = "465";
		props.setProperty("mail.smtp.port", smtpPort);
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.socketFactory.port", smtpPort);
		// 2. 根据配置创建会话对象, 用于和邮件服务器交互
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true); // 设置为debug模式, 可以查看详细的发送 log
		// 3. 创建一封邮件
		MimeMessage message = MessageCreate.createMimeMessage(vText, session, receiveMailAccount);
		// 4. 根据 Session 获取邮件传输对象
		Transport transport = session.getTransport();
		transport.connect(myEmailAccount, myEmailPassword);
		// 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人,
		// 密送人
		transport.sendMessage(message, message.getAllRecipients());
		// 7. 关闭连接
		transport.close();
	}
}
