package com.vaibhavshindetech.export;

import java.awt.Color;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.vaibhavshindetech.entities.PlanInfoEntity;

import lombok.Setter;

@Setter
public class CoPDFExporter {
	private PlanInfoEntity planInfo;

	public void generate(HttpServletResponse response) throws DocumentException, IOException {
		// Create the Object of Document
		Document document = new Document(PageSize.A4);
		// get the document and write the response to output stream
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		// Add Font
		Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTiltle.setSize(20);
		// Create Object of Paragraph
		Paragraph paragraph = new Paragraph("Plan Info and Benifits Details", fontTiltle);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);
///////////////////////////////////////////////

		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100f);
		table.setWidths(new int[] { 3, 3 });
		table.setSpacingBefore(5);
		// Create Table Header
		PdfPCell cell = new PdfPCell();
//		cell.setBackgroundColor(Color.BLACK);
		cell.setPadding(5);
		// Add Font
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(Color.BLACK);
		cell.setPhrase(new Phrase("Case Id", font));
		table.addCell(cell);
		table.addCell(String.valueOf(planInfo.getCaseId()));

		cell.setPhrase(new Phrase("Plan Name", font));
		table.addCell(cell);
		table.addCell(planInfo.getPlanName());

		cell.setPhrase(new Phrase("Holder Name", font));
		table.addCell(cell);
		table.addCell(planInfo.getName());

		cell.setPhrase(new Phrase("Holder SSN", font));
		table.addCell(cell);
		table.addCell(planInfo.getSsn());

		cell.setPhrase(new Phrase("Plan Status", font));
		table.addCell(cell);
		table.addCell(planInfo.getPlanStatus());

		if (planInfo.getBenefitAmt() != null) {
			cell.setPhrase(new Phrase("Benifit Amount in Dollar($)", font));
			table.addCell(cell);
			table.addCell(String.valueOf(planInfo.getBenefitAmt()) + "$");
		}

		if (planInfo.getStartDate() != null)
		{
			cell.setPhrase(new Phrase("Plan Start Date", font));
			table.addCell(cell);
			table.addCell(planInfo.getStartDate());
		}
			

		if (planInfo.getEndDate() != null)
		{
			cell.setPhrase(new Phrase("Plan End Date", font));
			table.addCell(cell);
			table.addCell(planInfo.getEndDate());
		}
			

		if (planInfo.getDenialReason() != null)
		{
			cell.setPhrase(new Phrase("Denial Reason", font));
			table.addCell(cell);
			table.addCell(planInfo.getDenialReason());
		}
			
//			table.addCell(String.valueOf(insuranceResponse.getPlanId()));
//			table.addCell(insuranceResponse.getPlanName());
//			table.addCell(insuranceResponse.getHolderName());
//			table.addCell(String.valueOf(insuranceResponse.getHolderSSN()));
//			table.addCell(insuranceResponse.getPlanStatus());
		// Add table to document
		document.add(table);

		////////////////////////////////////////////

		   List list = new List(List.UNORDERED);
//		    list.setIndentationLeft(100);
//		    list.add(new ListItem("Case ID:"+planInfo.getCaseId()));
//		    list.add(new ListItem("Name:"+planInfo.getName()));
//		    list.add(new ListItem("SSN:"+planInfo.getSsn()));
//		    list.add(new ListItem("Plan Name:"+planInfo.getPlanName()));
//		    list.add(new ListItem("Plan Status:"+planInfo.getPlanStatus()));
//		    list.add(new ListItem("Benefit Amount:"+planInfo.getBenefitAmt()));
//		    list.add(new ListItem("Start Date:"+planInfo.getStartDate()));
//		    list.add(new ListItem("End Date:"+planInfo.getEndDate()));
//		    if(planInfo.getDenialReason()!=null)
		    list.add(new ListItem("Note: For more information please visit to DHS Office"));
		    document.add(list);

		document.close();
	}
}