package com.safre.coppel.mss_afiglobal.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.safre.coppel.mss_afiglobal.Utilities.Utilities;
import com.safre.coppel.mss_afiglobal.models.entity.MssAfilGlobalEntity;
import com.safre.coppel.mss_afiglobal.models.request.LeerArchivoRequest;
import com.safre.coppel.mss_afiglobal.models.request.MssAfilGlobalRequest;
import com.safre.coppel.mss_afiglobal.services.IMssAfilGlobalService;

import net.minidev.json.JSONObject;


/**
 * @Proyecto => Sistema de Afores.
 * @Programa => AFIGLOBALS
 * @Descripcion => Fuunciones generales del sistema safre
 * @author christopher J. Siverio
 * @fecha => 01/12/2020
 */
@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.OPTIONS })
@RequestMapping("/mss_afiglobal")
public class MssAfilGlobalControllador {

	@Autowired
	private IMssAfilGlobalService iMssAfilGlobalService;

	/**
	 * Metodo que se encarga de obtener la ruta y puerto de los microservicios
	 * 
	 * @param mssAfilGlobalRequest
	 * @param servletResponse
	 * @return
	 */
	@PostMapping(value = "/consultarliga", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public JSONObject findByCLV(@RequestBody MssAfilGlobalRequest mssAfilGlobalRequest,
			HttpServletResponse servletResponse) {

		Utilities.log("mss_afiglobal", "Entra Controlador de consultar liga \n" + mssAfilGlobalRequest.toString());

		MssAfilGlobalEntity mssAfilGlobalEntity = new MssAfilGlobalEntity();
		JSONObject jsonObject = new JSONObject();

		mssAfilGlobalEntity = iMssAfilGlobalService.findByCLV(mssAfilGlobalRequest.getClv());

		servletResponse.setStatus(HttpServletResponse.SC_OK);
		jsonObject.put("status", HttpServletResponse.SC_OK);
		jsonObject.put("result", mssAfilGlobalEntity);
		Utilities.log("mss_afiglobal", "Sale del Controlador de consultar liga");
		return jsonObject;
	}

	@PostMapping(value = "/leerArchivoFTP", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public JSONObject leerArchivoFTP(@RequestBody LeerArchivoRequest leerArchivoRequest,
			HttpServletResponse servletResponse) {

		Utilities.log("mss_afiglobal", "leerArchivoFTP() prueba\n" + leerArchivoRequest.toString());
				
		JSONObject text = Utilities.leerArchivoFTP(leerArchivoRequest.getServidor(), leerArchivoRequest.getPuerto(),
				leerArchivoRequest.getuFtp(), leerArchivoRequest.getpFtp(), leerArchivoRequest.getLocalPath(),
				leerArchivoRequest.getFilename());
		
		JSONObject jsonObject = new JSONObject();
		
		servletResponse.setStatus(HttpServletResponse.SC_OK);
		jsonObject.put("status", HttpServletResponse.SC_OK);
		jsonObject.put("result", text);

		return jsonObject;

	}

}
