package ages.alfa.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import ages.alfa.dto.StudentStatsDto;
import ages.alfa.service.StudentStatsExcelExporterService;
import lombok.val;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StudentStatsExcelExporterServiceImpl implements StudentStatsExcelExporterService {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<StudentStatsDto> listUsers;

    public StudentStatsExcelExporterServiceImpl(List<StudentStatsDto> listUsers) {
        this.listUsers = listUsers;
        workbook = new XSSFWorkbook();
    }

    @Override
    public void write(){
        writeHeaderLine();
        writeDataLines();
    }

    @Override
    public XSSFWorkbook getWorkbook(){
        return workbook;
    }


    private void writeHeaderLine() {
        sheet = workbook.createSheet("Users");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Nome", style);
        createCell(row, 1, "E-mail", style);
        createCell(row, 2, "Questões Respondidas", style);
        createCell(row, 3, "Acertos", style);
        createCell(row, 4, "Erros", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (StudentStatsDto user : listUsers) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, user.getStudentName(), style);
            createCell(row, columnCount++, user.getEmail(), style);
            createCell(row, columnCount++, user.getActivitiesAnswered(), style);
            createCell(row, columnCount++, user.getActivitiesCorrect(), style);
            createCell(row, columnCount++, user.getActivitiesWrong(), style);

        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();




        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }
}