package controllers;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import beans.Book;
import dao.BookDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExcelController {

    @Autowired
    @Qualifier("BookDao") 
    private BookDao dao;

    @GetMapping("/upload")
    public String showUploadForm() {
        return "excelupload"; // Create a JSP page for the form
    }

    @PostMapping("/uploadsave")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            List<Book> books = ExcelFileParser.parseExcel(file.getInputStream());
            for (Book book : books) {
                dao.insertBook(book);
            }
        }
        return "redirect:/upload";
    }
    
    
    public static class ExcelFileParser {
        public static List<Book> parseExcel(InputStream fileStream) throws IOException {
            List<Book> books = new ArrayList<>();
            try (Workbook workbook = WorkbookFactory.create(fileStream)) {
                Sheet sheet = workbook.getSheetAt(0); // Assuming data is on the first sheet
                for (Row row : sheet) {
                    Book book = new Book();
                    book.setTitle(row.getCell(0).getStringCellValue());
                    book.setAuthor(row.getCell(1).getStringCellValue());
                    book.setCollection(row.getCell(2).getStringCellValue());
                    books.add(book);
                }
            } catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            return books;
        }
    }


}
