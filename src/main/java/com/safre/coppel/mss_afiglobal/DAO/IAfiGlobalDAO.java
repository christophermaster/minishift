package com.safre.coppel.mss_afiglobal.DAO;

import com.safre.coppel.mss_afiglobal.models.entity.MssAfilGlobalEntity;

public interface IAfiGlobalDAO {
	public MssAfilGlobalEntity findByCLV(String clv);
}
