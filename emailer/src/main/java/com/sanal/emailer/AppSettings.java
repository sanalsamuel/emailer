package com.sanal.emailer;




public class AppSettings {
   
	
	public String getHost() {
		return host;
	}



	public String getSender() {
		return sender;
	}



	public String getReciepient() {
		return reciepient;
	}



	public String getPort() {
		return port;
	}



	public void setHost(String host) {
		this.host = host;
	}



	public void setSender(String sender) {
		this.sender = sender;
	}



	public void setReciepient(String reciepient) {
		this.reciepient = reciepient;
	}



	public void setPort(String port) {
		this.port = port;
	}



	private String host;
    private String sender;
    private String reciepient;
    private String port;


	
	@Override
	public String toString() {
		return "AppSettings [host=" + host + ", sender=" + sender + ", reciepient="
				+ reciepient + ", port=" + port + "]";
	}
	

}
