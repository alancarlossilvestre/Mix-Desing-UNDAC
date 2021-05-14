package org.alan.mixdesign;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class templatePDF {
    private Context context;
    private File pdfFile;
    private com.itextpdf.text.Document document;
    private PdfWriter pdfWriter;
    private Paragraph paragraph;
    private Font fTitle = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);
    private Font fSubTitle = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private Font fText = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private Font fHightText = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.RED);

    public templatePDF(Context context) {
        this.context=context;

    }

    public void openDocument(){
        createFile();
        try{
            document =new Document(PageSize.A4);
            pdfWriter=PdfWriter.getInstance(document,new FileOutputStream(pdfFile));
            document.open();

        }catch (Exception e){
            Log.e("OpenDocument", e.toString());
        }
    }
    private void  createFile(){

        File folder = new File(Environment.getExternalStorageDirectory().toString(), "PDF");
        if(!folder.exists())
            folder.mkdirs();
        pdfFile = new File(folder, "Diseño_De_Mezcla.pdf");
    }
    public void closeDocument(){
        document.close();
    }
    public void addMetaData(String title, String subject, String author){
        document.addTitle(title);
        document.addSubject(subject);
        document.addAuthor(author);
    }

    public void addTittles(String title){
        try{
            paragraph =new Paragraph();
            addChildP(new Paragraph(title,fTitle ));
            paragraph.setSpacingAfter(30);
            document.add(paragraph);
        }catch (Exception e){
            Log.e("Error al añadir títulos", e.toString());
        }
    }

    public void addsubTittles(String subtitle){
        try{
            paragraph =new Paragraph();
            addChildP(new Paragraph(subtitle,fSubTitle ));
            paragraph.setSpacingAfter(30);
            document.add(paragraph);
        }catch (Exception e){
            Log.e("Error al de subtítulos", e.toString());
        }
    }

    private void addChildP(Paragraph childParagraph){
        childParagraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.add(childParagraph);
    }

    public void addTexto(String titulo){
        try{
            paragraph= new Paragraph(titulo, fText);
            paragraph.setSpacingAfter(5);
            paragraph.setSpacingBefore(5);
            document.add(paragraph);

        }catch (Exception e){
            Log.e("addParagraph", e.toString());
        }
    }

    public void createTable(String []header, ArrayList<String[]> clients){
        try{
            paragraph= new Paragraph();
            paragraph.setFont(fText);
            PdfPTable pdfPTable = new PdfPTable(header.length);
            pdfPTable.setWidthPercentage(100);
            pdfPTable.setSpacingBefore(20);
            PdfPCell pdfPCell;
            int indexC=0;
            while(indexC<header.length){
                pdfPCell= new PdfPCell(new Phrase(header[indexC++], fSubTitle));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfPCell.setBackgroundColor(BaseColor.GREEN);
                pdfPTable.addCell(pdfPCell);
            }

            for (int indexR=0; indexR<clients.size(); indexR++){

                String[]row = clients.get(indexR);
                for ( indexC=0; indexC<header.length; indexC++){
                    pdfPCell=new PdfPCell(new Phrase(row[indexC]));
                    pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfPCell.setFixedHeight(40);
                    pdfPTable.addCell(pdfPCell);
                }
            }

            paragraph.add(pdfPTable);
            document.add(paragraph);
        }catch (Exception e){
            Log.e("createTable", e.toString());
        }
    }

    public void appviewPDF(Activity activity){
        if(pdfFile.exists()){
            Uri uri=Uri.fromFile(pdfFile);
            Intent intent= new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri, "application/pdf");
            try{
                activity.startActivity(intent);
            }catch (ActivityNotFoundException e){
                activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.adobe.reader")));
                Toast.makeText(activity.getApplicationContext(),"No cuentas con un aplicacion", Toast.LENGTH_SHORT).show();

            }

        }else{
            Toast.makeText(activity.getApplicationContext(),"No Se encontro el archivo", Toast.LENGTH_SHORT).show();

        }

    }

    public void viewPDF_a(){
        Intent intent= new Intent(context, ViewPDF.class);
        intent.putExtra("path", pdfFile.getAbsolutePath());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }
}
