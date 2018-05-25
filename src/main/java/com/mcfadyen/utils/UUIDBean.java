package com.mcfadyen.utils;

import java.util.UUID;

import javax.annotation.ManagedBean;

@ManagedBean
public class UUIDBean {
	private UUID uuid;
	
	public UUIDBean(){
		this.uuid = UUID.randomUUID();
	}
	public String generateUniqueId(){
        return uuid.toString();
	}
}
