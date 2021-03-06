package com.codeseeker.microUserService.internals.idgenerator;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class GenericUserIDGenerator implements IdentifierGenerator{

	private static final String USER_PREFIX="US";
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String id=USER_PREFIX+UUID.randomUUID().toString().substring(0, 4).toUpperCase();
		return id;
	}

}
 