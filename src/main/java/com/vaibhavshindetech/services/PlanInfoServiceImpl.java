package com.vaibhavshindetech.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhavshindetech.entities.CoTriggerEntity;
import com.vaibhavshindetech.entities.PlanInfoEntity;
import com.vaibhavshindetech.repository.PlanInfoRepository;
import com.vaibhavshindetech.util.EmailUtils;

@Service
public class PlanInfoServiceImpl implements PlanInfoService {
	@Autowired
	private PlanInfoRepository planInfoRepository;
	@Autowired
	private CoTriggerService coTriggerService;

	@Autowired
	private EmailUtils emailUtils;
//	getting citizen eligiblity details
	@Override
	public void getCitizensPlanInfo() {
		List<CoTriggerEntity> pendingRecords = coTriggerService.getAllPendingRecords();
		for (CoTriggerEntity record : pendingRecords) {
			PlanInfoEntity planInfoEntity = planInfoRepository.findAllByCaseId(record.getCaseId());
			if (sendRegEmail(planInfoEntity)) {
				record.setCoTriggerStatus("COMPLETED");
				coTriggerService.updateCoTriggerStatus(record);
			}
		}
	}
//	sending co mail to citizen
	private boolean sendRegEmail(PlanInfoEntity user) {
		boolean emailSent = false;

//			Map<String, String> messages = appProperties.getMessages();

		String subject = "KES Notice";

		String regEmailFileName = "CO-EMAIL-BODY-TEMPLATE.txt";

		String body = this.readMailBody(regEmailFileName, user);

		try {
			emailSent = emailUtils.sendEmail(user.getName(), subject, body);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emailSent;
	}
//	reading data from template file
	public String readMailBody(String fileName, PlanInfoEntity user) {
		String finalMailBody = null;
		StringBuffer buffer = new StringBuffer();
		Path path = Paths.get(fileName);

		try (Stream<String> stream = Files.lines(path)) {
			stream.forEach(line -> {
				buffer.append(line);
			});
			String originalMailBody = buffer.toString();
			finalMailBody = originalMailBody.replace("{FNAME}", user.getName());
			finalMailBody = finalMailBody.replace("{CASE-ID}", String.valueOf(user.getCaseId()));
			System.out.println(finalMailBody);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return finalMailBody;

	}
}
