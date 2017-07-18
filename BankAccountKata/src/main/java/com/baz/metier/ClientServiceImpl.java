package com.baz.metier;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baz.dao.IClientRepository;
import com.baz.dao.ICompteRepository;
import com.baz.dao.IOperationRepository;
import com.baz.entities.Client;
import com.baz.entities.Compte;
import com.baz.entities.Operation;


@Service
@Transactional
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientRepository clientDao;
	
	@Autowired
	private ICompteRepository compteDao;
	
	@Autowired
	private IOperationRepository operationDao;
	
	private static Logger logger = Logger.getLogger(ClientServiceImpl.class);
	
	@Override
	/**
	 * @param client, le client que l'on souhaite creer
	 * @return Client si tout est OK, null sinon
	 */
	public Client create(Client client) {
		Client c = null;
		if (findByEmail(client) != null) {
			logger.error("Ce mail est déjà existant");

		} else {

			c = clientDao.save(client);
			String codeCompteAutoMatic = Long.valueOf(new Date().getTime()).toString();
			Compte compte = new Compte(codeCompteAutoMatic, new Date(), 1000, 200, c);
			compte = compteDao.save(compte);
			c.setCompte(compte);
			logger.debug("Vous avez été bien inscrit");
		}
		return c;
	}
	

	@Override
	public Client selectById(Long id) {

		Client c = clientDao.findOne(id);
		return c;
	}
	

	@Override
	/**
	 * @param id, l'id du client a supprimer
	 */
	public void delete(Long id) {
		Client client = clientDao.findOne(id);
		operationDao.deleteOperationByCompte(client.getCompte().getCodeCompte());
		compteDao.delete(client.getCompte());
		clientDao.delete(id);
	}


	@Override
	/**
	 * @param client, on utilise l email et password pour se connecter
	 * @return client ou null si la connection n'a pas eu lieu
	 */
	public Client connect(Client c) {
		Client c2 = null;
		List<Client> listCli = null;
		try {
			listCli = clientDao.connectClientLogin(c.getEmail(), c.getPassword());
			if (listCli != null && listCli.size() > 0) {
				c2 = listCli.get(0);
			}
		} catch (Exception e) {
		}
		return c2;
	}
	
	
	/**
	 * @param c, le client que l'on recherche grace a son mail
	 * @return Client, null sinon
	 */
	public Client findByEmail(Client c) {
		Client c3 = null;
		List<Client> listCli = null;
		try {
			listCli = clientDao.clientExiste(c.getEmail());
			if (listCli != null && listCli.size() > 0) {
				c3 = listCli.get(0);
			}
		} catch (Exception e) {
		}
		return c3;
	}

}
