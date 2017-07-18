package com.baz.metier;

import com.baz.entities.Client;

public interface IClientService {

	public Client create(Client c);
	public Client connect(Client c);
	public Client selectById(Long id);
	public void delete(Long id);
	public Client findByEmail(Client c);

	
}