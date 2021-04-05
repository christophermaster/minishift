package com.safre.coppel.mss_afiglobal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safre.coppel.mss_afiglobal.DAO.IAfiGlobalDAO;
import com.safre.coppel.mss_afiglobal.Utilities.Utilities;
import com.safre.coppel.mss_afiglobal.models.entity.MssAfilGlobalEntity;

/**
 * @author christopher J. Siverio 11/12/2020 Afore Coppel
 */
@Service
public class MssAfilGlobalService implements IMssAfilGlobalService {

	@Autowired
	IAfiGlobalDAO iAfiGlobalDAO;

	@Override
	public MssAfilGlobalEntity findByCLV(String clv) {

		Utilities.log("mss_afiglobal", "Entra al Servicio de findByCLV");

		MssAfilGlobalEntity mssAfilGlobalEntity = new MssAfilGlobalEntity();
		try {
			mssAfilGlobalEntity = iAfiGlobalDAO.findByCLV(clv);
			if (mssAfilGlobalEntity != null) {
				mssAfilGlobalEntity.setUrl(mssAfilGlobalEntity.getUrl() + "/" + mssAfilGlobalEntity.getClv());
			}
		} catch (Exception e) {
			Utilities.log("mss_afiglobal", "Entra al Servicio de findByCLV \n" + e.getMessage());
			return null;
		}

		Utilities.log("mss_afiglobal", "Sale del Servicio de findByCLV");

		return mssAfilGlobalEntity;
	}

}
