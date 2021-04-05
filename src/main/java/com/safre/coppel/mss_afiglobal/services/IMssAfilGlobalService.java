package com.safre.coppel.mss_afiglobal.services;

import org.springframework.stereotype.Service;

import com.safre.coppel.mss_afiglobal.models.entity.MssAfilGlobalEntity;

/**
 * @author christopher J. Siverio 11/12/2020 Afore Coppel
 */
@Service
public interface IMssAfilGlobalService {
	public MssAfilGlobalEntity findByCLV(String clv);
}
