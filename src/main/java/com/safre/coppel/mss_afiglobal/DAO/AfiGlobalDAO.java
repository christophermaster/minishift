package com.safre.coppel.mss_afiglobal.DAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.safre.coppel.mss_afiglobal.Utilities.Utilities;
import com.safre.coppel.mss_afiglobal.models.entity.MssAfilGlobalEntity;

@Repository
public class AfiGlobalDAO implements IAfiGlobalDAO {

	private final EntityManager em;

	public AfiGlobalDAO() {
		this.em = null;
	}
	
	public AfiGlobalDAO(EntityManager em) {
		this.em = em;
	}

	@Override
	public MssAfilGlobalEntity findByCLV(String clv) {

		Utilities.log("mss_afiglobal", "Entra al DAO de findByCLV");

		Object[] obj = null;
		MssAfilGlobalEntity mssAfilGlobalEntity = new MssAfilGlobalEntity();

		Query nativeQuery = em.createNativeQuery(
				"SELECT idservicio, clvservicio, descripcion, ipservicio, puertoservicio, urlservicio, estado, fechaalta"
						+ "	FROM mscatalogosafre where clvservicio = :clv");
		nativeQuery.setParameter("clv", clv);
		try {
			obj = (Object[]) nativeQuery.getSingleResult();

		} catch (NoResultException nre) {
			Utilities.log("mss_afiglobal", "Error del DAO de findByCLV \n" + nre.getMessage());
		}

		if (obj != null) {
			mssAfilGlobalEntity = new MssAfilGlobalEntity(Integer.valueOf((int) obj[0]), (String) obj[1],
					(String) obj[2], (String) obj[3], (String) obj[4], (String) obj[5], Integer.valueOf((int) obj[6]));
		}
		Utilities.log("mss_afiglobal", "Sale del DAO de findByCLV");
		return mssAfilGlobalEntity;
	}

}
