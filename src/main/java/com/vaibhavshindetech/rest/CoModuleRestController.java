package com.vaibhavshindetech.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.vaibhavshindetech.entities.PlanInfoEntity;
import com.vaibhavshindetech.export.CoPDFExporter;
import com.vaibhavshindetech.repository.PlanInfoRepository;
import com.vaibhavshindetech.services.PlanInfoService;

@RestController
public class CoModuleRestController {
	@Autowired
	private PlanInfoService planInfoService;
	
	@Autowired
	private PlanInfoRepository planInfoRepository;
	@GetMapping(value = "/co")
	public void sendCo() {
//		List<PlanInfoEntity> citizensPlanInfo =
		 planInfoService.getCitizensPlanInfo();
//		return citizensPlanInfo;
	}
	@GetMapping("/pdf")
	public void generator(@RequestParam Integer caseid,HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
//	  DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
//	  String currentDateTime = dateFormat.format(new Date());
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=Notice" + ".pdf";
		response.setHeader(headerkey, headervalue);
		PlanInfoEntity planInfo = planInfoRepository.findByCaseId(caseid);
		CoPDFExporter generetorUser = new CoPDFExporter();
		generetorUser.setPlanInfo(planInfo);
		generetorUser.generate(response);
	}

}
